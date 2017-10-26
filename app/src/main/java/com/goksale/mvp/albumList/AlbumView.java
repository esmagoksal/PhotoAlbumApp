package com.goksale.mvp.albumList;


import com.goksale.mvp.core.BaseView;
import com.goksale.mvp.model.AlbumUIModel;
import com.goksale.mvp.model.PhotoUIModel;

import java.util.ArrayList;

public interface AlbumView extends BaseView {

    void showAlbumList(ArrayList<AlbumUIModel> albumUIModelList);

    void getCoverPhotos(ArrayList<PhotoUIModel> photoUIModelList);
}
