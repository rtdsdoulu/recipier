package fi.oulu.smartkitchen.recipier;

import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;


import java.io.IOException;
import java.util.Properties;

/**
 * Created by Leevi on 27.11.2016.
 */
public class CoreNLPTagger {

    public String tagWords(){

        // Initialize the tagger
        MaxentTagger tagger = new MaxentTagger(
                "edu/stanford/nlp/models/pos-tagger/english-left3words/english-left3words-distsim.tagger");

        Annotation document = new Annotation("Stir together 2 cups flour and the yeast. In a separate bowl, heat milk, water, oil, sugar and salt to lukewarm in microwave. Add all at once to the flour mixture, and beat until smooth, about 3 minutes.");
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        pipeline.annotate(document);
        String example = tagger.tagString(String.valueOf(document));
        return (example);
    }
}
