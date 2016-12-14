package fi.oulu.smartkitchen.recipier.model;

import javax.persistence.*;

/**
 * Created by Sam on 11/20/2016.
 */
@Entity
@Table(name = "recipes")
public class RecipeSource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "url")
    private String urlAddress;

    @Column(name = "original_text")
    private String recipeText;

    public RecipeSource() {
    }

    public RecipeSource(Long id){
        this.id = id;
    }

    public RecipeSource(String urlAddress, String recipeText) {
        this.urlAddress = urlAddress;
        this.recipeText = recipeText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
