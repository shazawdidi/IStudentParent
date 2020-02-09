package com.tztechs.student.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Attend {

    @SerializedName("id")
    private String id;

    @SerializedName("attend")
    private String attend;

    @SerializedName("attend_date")
    private String attendDate;

    public String getId() {
        return id;
    }

    public String getAttend() {
        return attend;
    }

    public String getAttendDate() {
        return attendDate;
    }
}
