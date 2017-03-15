package com.shareholder.abay.finapps.finappsproject.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by abay on 10/22/16.
 */
public class Vote {
    private int id;
    private String company_name;
    private Date end_date;
    private ArrayList<QuestionVote> questions;

    public Vote(int id, String company_name,  Date end_date) {
        this.id = id;
        this.company_name = company_name;
        this.end_date = end_date;
    }

    public ArrayList<QuestionVote> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QuestionVote> questions) {
        this.questions = questions;
    }

    public Date getDate() {
        return end_date;
    }

    public void setDate(Date end_date) {
        this.end_date = end_date;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
