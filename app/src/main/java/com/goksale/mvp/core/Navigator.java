package com.goksale.mvp.core;


import android.content.Context;

import com.goksale.mvp.model.AlbumUIModel;
import com.goksale.mvp.model.PhotoUIModel;
import com.goksale.mvp.photoDetails.PhotoDetailsActivity;
import com.goksale.mvp.photoList.PhotoListActivity;

public final class Navigator {

    public void navigateToPhotoList(Context context, AlbumUIModel album){
        context.startActivity(PhotoListActivity.newInstance(context, album));
    }

    public void navigateToPhotoDetails(Context context, PhotoUIModel photoUIModel) {
        context.startActivity(PhotoDetailsActivity.newInstance(context, photoUIModel));
    }
}
