package com.goksale.mediamonks.albumList;


import com.goksale.mediamonks.core.BaseView;
import com.goksale.mediamonks.model.AlbumUIModel;
import com.goksale.mediamonks.model.PhotoUIModel;

import java.util.ArrayList;

public interface AlbumView extends BaseView {

    void showAlbumList(ArrayList<AlbumUIModel> albumUIModelList);

    void getCoverPhotos(ArrayList<PhotoUIModel> photoUIModelList);
}
