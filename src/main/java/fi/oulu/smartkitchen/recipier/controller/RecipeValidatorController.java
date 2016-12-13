package fi.oulu.smartkitchen.recipier.controller;

import fi.oulu.smartkitchen.recipier.nlp.model.TaggedRecipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sam on 11/30/2016.
 */
@RestController
public class RecipeValidatorController {

    private final Logger logger = LoggerFactory.getLogger(RecipeReaderController.class);

    @RequestMapping(value="/validate", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void validate(@RequestBody String taggedRecipe) {
      //  logger.info("recipe:" + source.getRecipeText());
        logger.info("taggedrecipe:" + taggedRecipe);
       // NLPService nlpService = new NLPService();
    }
}
