package com.goksale.mvp.albumList;


import com.goksale.mvp.model.AlbumUIModel;

import java.util.ArrayList;

public interface AlbumListCallback {

    void onSuccess(ArrayList<AlbumUIModel> albumUIModels);
    void onError();
}
