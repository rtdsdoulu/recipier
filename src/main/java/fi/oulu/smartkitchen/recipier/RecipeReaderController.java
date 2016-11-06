package fi.oulu.smartkitchen.recipier;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Samitha on 11/5/2016.
 */
@RestController
public class RecipeReaderController {

    @RequestMapping("/analyze")
    public String index() {
          return "This is the recipe analyzer get method. ";
    }
}
