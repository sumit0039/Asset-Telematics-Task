package com.app.assettelematicsyask.Listener;

import com.app.assettelematicsyask.Models.Response;

public class AppListener {

    public interface OnDataListener{
        void onSuccess(Response response);
        void onFailure(String message);
    }
}
