package com.shareholder.abay.finapps.finappsproject.model;

/**
 * Created by abay on 10/23/16.
 */
public class HistoryVote {
     private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HistoryVote(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
