package com.goksale.mvp.albumList;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.goksale.mvp.core.BaseActivity;


public class AlbumListActivity extends BaseActivity {


    @Nullable
    @Override
    protected Fragment getContainedFragment() {
        return new AlbumListFragment();
    }
}
