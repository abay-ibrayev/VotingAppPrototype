package com.shareholder.abay.finapps.finappsproject.model;

/**
 * Created by abay on 10/23/16.
 */
public class Decision {
    private String question;
    private String[] answerVariants;

    public Decision(String question, String[] answerVariants) {
        this.question = question;
        this.answerVariants = answerVariants;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswerVariants() {
        return answerVariants;
    }

    public void setAnswerVariants(String[] answerVariants) {
        this.answerVariants = answerVariants;
    }




}
