package com.tztechs.student.models;

import com.google.gson.annotations.SerializedName;

public class Notes {

    @SerializedName("id")
    private String id;

    @SerializedName("note_title")
    private String title;

    @SerializedName("note_date")
    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return
                "Events{" +
                        "id = '" + id + '\'' +
                        ",event_title = '" + title + '\'' +
                        ",event_date = '" + date + '\'' +
                        "}";
    }
}
