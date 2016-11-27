package fi.oulu.smartkitchen.recipier.controller;

import fi.oulu.smartkitchen.recipier.model.CoreNLPTagger;
import fi.oulu.smartkitchen.recipier.model.RecipeSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Leevi on 27.11.2016.
 */
@RestController
public class CoreNLPController {

    private final Logger logger = LoggerFactory.getLogger(RecipeReaderController.class);

    @RequestMapping(value="/corenlp", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public String coreTagger(@RequestBody RecipeSource source) {
        logger.info("recipe:" + source.getRecipeText());
        CoreNLPTagger core = new CoreNLPTagger();
        String testing = core.tagWords();
        return(testing);
    }
}
