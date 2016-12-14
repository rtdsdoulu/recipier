package fi.oulu.smartkitchen.recipier.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fi.oulu.smartkitchen.recipier.dao.AnalysisToolDao;
import fi.oulu.smartkitchen.recipier.dao.RecipeSourceDao;
import fi.oulu.smartkitchen.recipier.model.RecipeSource;
import fi.oulu.smartkitchen.recipier.model.Token;
import fi.oulu.smartkitchen.recipier.nlp.model.TaggedRecipe;
import fi.oulu.smartkitchen.recipier.nlp.model.TaggedToken;
import fi.oulu.smartkitchen.recipier.service.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Sam on 11/30/2016.
 */
@RestController
public class RecipeValidatorController {

    @Autowired
    private RecipeService recipeService;

    private final Logger logger = LoggerFactory.getLogger(RecipeValidatorController.class);

    @RequestMapping(value="/validate", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void validate(@RequestBody String taggedRecipe) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            TaggedRecipe tagged = mapper.readValue(taggedRecipe, TaggedRecipe.class);
            recipeService.saveTaggedRecipe(tagged);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("taggedrecipe:" + taggedRecipe);
    }


}
