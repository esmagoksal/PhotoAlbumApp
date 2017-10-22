package com.goksale.mediamonks.photoList;


import com.goksale.mediamonks.core.BaseView;
import com.goksale.mediamonks.model.PhotoUIModel;

import java.util.ArrayList;

public interface PhotoView extends BaseView{

    void showPhotos(ArrayList<PhotoUIModel> photoUIModelList);
}
