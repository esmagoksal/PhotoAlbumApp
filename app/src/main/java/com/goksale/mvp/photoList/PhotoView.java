package com.goksale.mvp.photoList;


import com.goksale.mvp.core.BaseView;
import com.goksale.mvp.model.PhotoUIModel;

import java.util.ArrayList;

public interface PhotoView extends BaseView{

    void showPhotos(ArrayList<PhotoUIModel> photoUIModelList);
}
