package com.goksale.mediamonks.albumList;


import com.goksale.mediamonks.model.AlbumUIModel;

import java.util.ArrayList;

public interface AlbumListCallback {

    void onSuccess(ArrayList<AlbumUIModel> albumUIModels);
    void onError();
}
