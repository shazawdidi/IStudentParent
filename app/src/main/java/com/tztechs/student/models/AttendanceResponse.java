package com.tztechs.student.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AttendanceResponse {

    @SerializedName("data")
    private List<Attend> attends;


    public List<Attend> getAttends() {
        return attends;
    }
}
