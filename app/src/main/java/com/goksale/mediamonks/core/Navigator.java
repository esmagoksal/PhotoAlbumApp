package com.goksale.mediamonks.core;


import android.content.Context;

import com.goksale.mediamonks.model.PhotoUIModel;
import com.goksale.mediamonks.photoDetails.PhotoDetailsActivity;
import com.goksale.mediamonks.photoList.PhotoListActivity;

public final class Navigator {

    public void navigateToPhotoList(Context context, int albumId){
        context.startActivity(PhotoListActivity.newInstance(context, albumId));
    }

    public void navigateToPhotoDetails(Context context, PhotoUIModel photoUIModel) {
        context.startActivity(PhotoDetailsActivity.newInstance(context, photoUIModel));
    }
}
