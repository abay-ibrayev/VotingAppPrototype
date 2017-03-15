package com.shareholder.abay.finapps.finappsproject.model;

import java.util.Date;

/**
 * Created by abay on 10/23/16.
 */
public class QuestionVote {

    private int id;
    private String question_name;
    private String company_name;
    private Date end_date;

    public QuestionVote(int id, String question_name, String company_name, Date end_date) {
        this.id = id;
        this.question_name = question_name;
        this.company_name = company_name;
        this.end_date = end_date;
    }
    public QuestionVote(int id, String question_name, String company_name) {
        this.id = id;
        this.question_name = question_name;
        this.company_name = company_name;
        this.end_date = null;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Date getDate() {
        return end_date;
    }

    public void setDate(Date end_date) {
        this.end_date = end_date;
    }




    public String getQuestion_name() {
        return question_name;
    }

    public void setQuestion_name(String question_name) {
        this.question_name = question_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





}
