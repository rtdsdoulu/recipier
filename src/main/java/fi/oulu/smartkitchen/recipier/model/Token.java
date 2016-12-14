package fi.oulu.smartkitchen.recipier.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Sam on 12/13/2016.
 */
@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private RecipeSource recipes;

    @ManyToOne(cascade = CascadeType.ALL)
    private AnalysisTool analysis_tool;

    @NotNull
    private String token;

    @NotNull
    private String tag;

    @NotNull
    private boolean isCorrect;
    private String correctTag;
    private String comment;

    public Token() {
    }

    public Token(RecipeSource source, AnalysisTool tool, String token, String tag, boolean isCorrect, String correctTag, String comment) {
        this.recipes = source;
        this.analysis_tool = tool;
        this.token = token;
        this.tag = tag;
        this.isCorrect = isCorrect;
        this.correctTag = correctTag;
        this.comment = comment;
    }

    public Token(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RecipeSource getRecipes() {
        return recipes;
    }

    public void setRecipes(RecipeSource recipes) {
        this.recipes = recipes;
    }

    public AnalysisTool getAnalysis_tool() {
        return analysis_tool;
    }

    public void setAnalysis_tool(AnalysisTool analysis_tool) {
        this.analysis_tool = analysis_tool;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getCorrectTag() {
        return correctTag;
    }

    public void setCorrectTag(String correctTag) {
        this.correctTag = correctTag;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
