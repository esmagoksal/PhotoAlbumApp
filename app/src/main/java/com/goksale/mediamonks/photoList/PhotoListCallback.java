package com.goksale.mediamonks.photoList;


import com.goksale.mediamonks.model.PhotoUIModel;

import java.util.ArrayList;

public interface PhotoListCallback {
    void onSuccess(ArrayList<PhotoUIModel> photoUIModelList);
    void onError();
}

