package fi.oulu.smartkitchen.recipier.nlp.tools;

import edu.emory.mathcs.nlp.component.template.node.NLPNode;
import edu.emory.mathcs.nlp.decode.NLPDecoder;
import fi.oulu.smartkitchen.recipier.model.RecipeSource;
import fi.oulu.smartkitchen.recipier.nlp.model.TaggedToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 11/28/2016.
 */
public class NLP4JTagger {

    private NLPDecoder decoder;

    public List<TaggedToken> tokenizeAndTag(RecipeSource source) throws IOException {

        List<TaggedToken> taggedTokens = new ArrayList<>();
        NLPDecoder wordTagger = nlpDecoderFactory();
        List<NLPNode[]> nodes = wordTagger.decodeDocument(source.getRecipeText());
        int seqNo = 0;
        for(NLPNode[] nodesArr:nodes){
           for(int i=1;i<nodesArr.length;i++){
               NLPNode node = nodesArr[i];
               TaggedToken token = new TaggedToken();
               token.setSequenceNo(seqNo++);
               token.setCorrect(true);
               token.setTaggedToken(node.getWordForm()+"/"+node.getPartOfSpeechTag());
               taggedTokens.add(token);
           }
        }

        return taggedTokens;
    }

    public NLPDecoder nlpDecoderFactory() throws FileNotFoundException {
        if(decoder == null) {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("config-decode-pos.xml").getFile());
            InputStream is = new FileInputStream(file);
            decoder = new NLPDecoder(is);
            return decoder;
        }else{
            return decoder;
        }
    }
}
