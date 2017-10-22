package com.goksale.mediamonks.core;


import android.content.Context;

import com.goksale.mediamonks.photoList.PhotoListActivity;

public final class Navigator {

    public void navigateToPhotoList(Context context, int albumId){
        context.startActivity(PhotoListActivity.newInstance(context, albumId));
    }
}
