package fi.oulu.smartkitchen.recipier.nlp.tools;

import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import fi.oulu.smartkitchen.recipier.model.RecipeSource;
import fi.oulu.smartkitchen.recipier.nlp.model.TaggedToken;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Created by Leevi on 29.11.2016.
 */
public class CoreNLPTagger {

    public List<TaggedToken> tagWords(RecipeSource source) throws IOException {
        // Initialize the tagger and list
        MaxentTagger tagger = new MaxentTagger(
                "edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger");
        List<TaggedToken> tagTokens = new ArrayList<>();

        // Read the target text, and replace all "_" with "/" to ensure compatibility with other NLP
        Annotation document = new Annotation(source.getRecipeText());
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        pipeline.annotate(document);
        String taggedString = tagger.tagString(String.valueOf(document));
        taggedString = taggedString.replace("_", "/");
        String[] taggedTokens = taggedString.split(" ");

        // Iterate through all the words in the target text
        int seqNo = 0;
        for(String token : taggedTokens) {
                TaggedToken tagToken = new TaggedToken();
                tagToken.setSequenceNo(seqNo++);
                tagToken.setCorrect(true);
                tagToken.setTaggedToken(token);
                tagTokens.add(tagToken);
        }

        return (tagTokens);
    }
}
