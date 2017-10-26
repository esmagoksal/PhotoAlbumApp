package com.goksale.mvp.core;


import android.app.Application;

import com.goksale.mvp.network.APIManager;
import com.goksale.mvp.network.RetrofitAPI;

public class PhotoAlbumApp extends Application {

    private static final String TAG = PhotoAlbumApp.class.getSimpleName();
    private static APIManager apiManager;


    public static APIManager getApiManager() {
        if (apiManager == null) {
            apiManager = RetrofitAPI.getClient().create(APIManager.class);
        }
        return apiManager;
    }

}
