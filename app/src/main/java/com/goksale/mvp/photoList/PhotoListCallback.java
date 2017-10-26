package com.goksale.mvp.photoList;


import com.goksale.mvp.model.PhotoUIModel;

import java.util.ArrayList;

public interface PhotoListCallback {
    void onSuccess(ArrayList<PhotoUIModel> photoUIModelList);
    void onError();
}

