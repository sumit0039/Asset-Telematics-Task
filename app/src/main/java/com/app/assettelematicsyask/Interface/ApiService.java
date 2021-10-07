package com.app.assettelematicsyask.Interface;

import com.app.assettelematicsyask.Models.Request;
import com.app.assettelematicsyask.Models.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("task")
    Call<Response> getAllData(@Body Request request);

}



