package fi.oulu.smartkitchen.recipier.nlp.model;

import fi.oulu.smartkitchen.recipier.model.RecipeSource;

import java.util.List;
import java.util.Map;

/**
 * Created by Sam on 11/30/2016.
 */
public class TaggedRecipe {

    private RecipeSource recipeSource;
    private Map<String, List<TaggedToken>> taggedTokens;

    public RecipeSource getRecipeSource() {
        return recipeSource;
    }

    public void setRecipeSource(RecipeSource recipeSource) {
        this.recipeSource = recipeSource;
    }

    public Map<String, List<TaggedToken>> getTaggedTokens() {
        return taggedTokens;
    }

    public void setTaggedTokens(Map<String, List<TaggedToken>> taggedTokens) {
        this.taggedTokens = taggedTokens;
    }
}
