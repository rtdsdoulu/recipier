package fi.oulu.smartkitchen.recipier.controller;

import fi.oulu.smartkitchen.recipier.model.RecipeSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Samitha on 11/5/2016.
 */
@RestController
public class RecipeReaderController {

    private final Logger logger = LoggerFactory.getLogger(RecipeReaderController.class);

    @RequestMapping(value="/analyze", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public String analyzeRecipe(@RequestBody RecipeSource source) {
           logger.info("recipe:" + source.getRecipeText());
          return "This is the recipe analyzer get method. ";
    }
}
