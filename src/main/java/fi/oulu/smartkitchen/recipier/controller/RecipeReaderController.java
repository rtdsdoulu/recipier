package fi.oulu.smartkitchen.recipier.controller;

import fi.oulu.smartkitchen.recipier.model.RecipeSource;
import fi.oulu.smartkitchen.recipier.nlp.model.TaggedRecipe;
import fi.oulu.smartkitchen.recipier.nlp.model.TaggedToken;
import fi.oulu.smartkitchen.recipier.nlp.service.NLPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Samitha on 11/5/2016.
 */
@RestController
public class RecipeReaderController {

    private final Logger logger = LoggerFactory.getLogger(RecipeReaderController.class);

    @RequestMapping(value="/analyze", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public TaggedRecipe analyzeRecipe(@RequestBody RecipeSource source) {
        logger.info("recipe:" + source.getRecipeText());

        NLPService nlpService = new NLPService();

        return nlpService.getTaggedTokensByTool(source);
    }

    @RequestMapping(value="/analyzes", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public TaggedRecipe analyzeRecipeStrinh(@RequestBody String source) {

        logger.info("recipe:" + source);

        NLPService nlpService = new NLPService();

        return new TaggedRecipe();
    }
}
