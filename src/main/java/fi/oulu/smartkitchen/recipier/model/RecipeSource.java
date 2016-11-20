package fi.oulu.smartkitchen.recipier.model;

/**
 * Created by Sam on 11/20/2016.
 */
public class RecipeSource {

    private String urlAddress;
    private String recipeText;

    public String getRecipeText() {
        return recipeText;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setRecipeText(String recipeText) {
        this.recipeText = recipeText;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }
}
