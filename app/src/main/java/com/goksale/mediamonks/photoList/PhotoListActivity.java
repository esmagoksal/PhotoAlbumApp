package com.goksale.mediamonks.photoList;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.goksale.mediamonks.core.BaseActivity;
import com.goksale.mediamonks.model.AlbumUIModel;

public class PhotoListActivity extends BaseActivity {

    private static final String KEY_ALBUM = "keyAlbum";

    private AlbumUIModel album;

    public static Intent newInstance(Context context, AlbumUIModel album) {
        final Intent intent = new Intent(context, PhotoListActivity.class);
        intent.putExtra(KEY_ALBUM, album);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        album = getIntent().getParcelableExtra(KEY_ALBUM);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    protected Fragment getContainedFragment() {
        return PhotoListFragment.newInstance(album);
    }
}
