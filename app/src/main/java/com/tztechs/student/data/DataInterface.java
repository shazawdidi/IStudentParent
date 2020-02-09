package com.tztechs.student.data;


import com.tztechs.student.models.AttendanceResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public  interface DataInterface {


    @GET("attendance")
     Call<AttendanceResponse> getservice(
    );
}
