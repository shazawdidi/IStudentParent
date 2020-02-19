package com.tztechs.student.data;


import com.tztechs.student.models.Events;
import com.tztechs.student.models.response.AttendanceResponse;
import com.tztechs.student.models.response.EventsResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public  interface DataInterface {


    @GET("attendance")
     Call<AttendanceResponse> getservice(
    );

    @GET("Events")
    Call<EventsResponse> getEvents(
    );
}
