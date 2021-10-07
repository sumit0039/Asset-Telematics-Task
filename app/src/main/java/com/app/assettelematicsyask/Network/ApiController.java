package com.app.assettelematicsyask.Network;

import android.content.Context;

import com.app.assettelematicsyask.Interface.ApiService;
import com.app.assettelematicsyask.Listener.AppListener;
import com.app.assettelematicsyask.Models.Request;
import com.app.assettelematicsyask.Models.Response;

import retrofit2.Call;
import retrofit2.Callback;


public class ApiController {
    private Context context;
    private ApiService apiService;


    public ApiController(Context context) {
        this.context = context;
        apiService = RetrofitClient.getInterface();

    }

    public void getAllData(Request request, final AppListener.OnDataListener onDataListener){
        apiService.getAllData(request)
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                        if (response.isSuccessful()){
                            if (response.body().getStatus() == 200){
                                onDataListener.onSuccess(response.body());
                            }else {
                                onDataListener.onFailure(response.body().getMessage());
                            }
                        }else {
                            onDataListener.onFailure("Something went wrong");
                        }
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {

                        onDataListener.onFailure(t.getMessage());
                    }
                });
    }
}
