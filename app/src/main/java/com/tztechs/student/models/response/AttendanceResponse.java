package com.tztechs.student.models.response;

import com.google.gson.annotations.SerializedName;
import com.tztechs.student.models.Attend;

import java.util.ArrayList;
import java.util.List;

public class AttendanceResponse {

    @SerializedName("data")
    private List<Attend> attends;


    public List<Attend> getAttends() {
        return attends;
    }
}
