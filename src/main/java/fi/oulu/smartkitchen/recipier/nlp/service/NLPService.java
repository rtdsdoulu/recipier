package fi.oulu.smartkitchen.recipier.nlp.service;

import fi.oulu.smartkitchen.recipier.model.RecipeSource;
import fi.oulu.smartkitchen.recipier.nlp.model.TaggedRecipe;
import fi.oulu.smartkitchen.recipier.nlp.model.TaggedToken;
import fi.oulu.smartkitchen.recipier.nlp.tools.CoreNLPTagger;
import fi.oulu.smartkitchen.recipier.nlp.tools.NLP4JTagger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sam on 11/28/2016.
 */
public class NLPService {


    public TaggedRecipe getTaggedTokensByTool(RecipeSource source) {
        Map<String, List<TaggedToken>> toolMappedTokens = new HashMap<>();
        TaggedRecipe taggedRecipe = new TaggedRecipe();
        taggedRecipe.setRecipeSource(source);

        try {
            //NLP4J
            NLP4JTagger tokenizer = new NLP4JTagger();
            List<TaggedToken> nlp4jTokens = tokenizer.tokenizeAndTag(source);
            toolMappedTokens.put("NLP4J", nlp4jTokens);

            //CoreNLP
            CoreNLPTagger tagger = new CoreNLPTagger();
            List<TaggedToken> corenlpTokens = tagger.tagWords(source);
            toolMappedTokens.put("CORENLP", corenlpTokens);

            //Add more tools...

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        taggedRecipe.setTaggedTokens(toolMappedTokens);
        return taggedRecipe;
    }
}
