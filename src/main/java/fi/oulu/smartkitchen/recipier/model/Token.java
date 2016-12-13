package fi.oulu.smartkitchen.recipier.model;

/**
 * Created by Sam on 12/13/2016.
 */
public class Token {

    private Long id;
    private RecipeSource source;
    private AnalysisTool tool;
    private String token;
    private String tag;
    private boolean isCorrect;
    private String correctTag;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RecipeSource getSource() {
        return source;
    }

    public void setSource(RecipeSource source) {
        this.source = source;
    }

    public AnalysisTool getTool() {
        return tool;
    }

    public void setTool(AnalysisTool tool) {
        this.tool = tool;
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
