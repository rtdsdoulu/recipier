package fi.oulu.smartkitchen.recipier.nlp.service;

import fi.oulu.smartkitchen.recipier.CoreNLPTagger;
import fi.oulu.smartkitchen.recipier.model.RecipeSource;
import fi.oulu.smartkitchen.recipier.nlp.model.TaggedToken;
import fi.oulu.smartkitchen.recipier.nlp.tools.NLP4JTokenizer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sam on 11/28/2016.
 */
public class NLPService {


    public Map<String, List<TaggedToken>> getTaggedTokensByTool(RecipeSource source){
        Map<String, List<TaggedToken>> toolMappedTokens = new HashMap<>();

        //NLP4J
        NLP4JTokenizer tokenizer = new NLP4JTokenizer();
        //CoreNLP
        CoreNLPTagger tagger = new CoreNLPTagger();

        try {
            List<TaggedToken> nlp4jTokens = tokenizer.tokenizeAndTag(source);
            toolMappedTokens.put("NLP4J", nlp4jTokens);

            List<TaggedToken> corenlpTokens = tagger.tagWords(source);
            toolMappedTokens.put("CORENLP", corenlpTokens);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toolMappedTokens;
    }
}
