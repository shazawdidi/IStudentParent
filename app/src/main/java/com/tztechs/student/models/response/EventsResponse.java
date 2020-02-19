
package com.tztechs.student.models.response;


import com.google.gson.annotations.SerializedName;
import com.tztechs.student.models.Events;

import java.util.List;

@SuppressWarnings("unused")
public class EventsResponse {

    @SerializedName("")
    private List<Events> data;

    public List<Events> getData() {
        return data;
    }

    @Override
    public String toString(){
        return
                "{" +
                        " = '" + data + '\'' +
                        "}";
    }
}
