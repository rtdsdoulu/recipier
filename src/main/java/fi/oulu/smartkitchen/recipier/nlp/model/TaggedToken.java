package fi.oulu.smartkitchen.recipier.nlp.model;

/**
 * Created by Sam on 11/29/2016.
 */
public class TaggedToken {

    private int sequenceNo;
    private String taggedToken;
    private boolean isCorrect = true;
    private String correctTag;
    private String reason;

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getTaggedToken() {
        return taggedToken;
    }

    public void setTaggedToken(String taggedToken) {
        this.taggedToken = taggedToken;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
