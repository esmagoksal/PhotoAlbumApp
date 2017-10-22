package com.goksale.mediamonks.core;


import android.content.Context;

import com.goksale.mediamonks.model.AlbumUIModel;
import com.goksale.mediamonks.model.PhotoUIModel;
import com.goksale.mediamonks.photoDetails.PhotoDetailsActivity;
import com.goksale.mediamonks.photoList.PhotoListActivity;

public final class Navigator {

    public void navigateToPhotoList(Context context, AlbumUIModel album){
        context.startActivity(PhotoListActivity.newInstance(context, album));
    }

    public void navigateToPhotoDetails(Context context, PhotoUIModel photoUIModel) {
        context.startActivity(PhotoDetailsActivity.newInstance(context, photoUIModel));
    }
}
