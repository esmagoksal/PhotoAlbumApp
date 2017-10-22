package com.goksale.mediamonks.photoList;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.goksale.mediamonks.core.BaseActivity;

public class PhotoListActivity extends BaseActivity {

    private static final String KEY_ALBUM_ID = "keyPhotoList";

    private int albumId;

    public static Intent newInstance(Context context, int albumId) {
        final Intent intent = new Intent(context, PhotoListActivity.class);
        intent.putExtra(KEY_ALBUM_ID, albumId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        albumId = getIntent().getIntExtra(KEY_ALBUM_ID, 0);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    protected Fragment getContainedFragment() {
        return PhotoListFragment.newInstance(albumId);
    }
}
