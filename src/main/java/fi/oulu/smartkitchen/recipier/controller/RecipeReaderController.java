package fi.oulu.smartkitchen.recipier.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fi.oulu.smartkitchen.recipier.model.RecipeSource;
import fi.oulu.smartkitchen.recipier.nlp.model.TaggedRecipe;
import fi.oulu.smartkitchen.recipier.nlp.service.NLPService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Samitha on 11/5/2016.
 */
@RestController
public class RecipeReaderController {

    @Autowired
    private NLPService nlpService;

    private final Logger logger = LoggerFactory.getLogger(RecipeReaderController.class);

    @RequestMapping(value="/analyze", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TaggedRecipe analyzeRecipeStrinh(@RequestBody String source) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        RecipeSource source1 = mapper.readValue(source, RecipeSource.class);
        logger.info("recipe:" + source);

        return nlpService.getTaggedTokensByTool(source1);
    }
}
