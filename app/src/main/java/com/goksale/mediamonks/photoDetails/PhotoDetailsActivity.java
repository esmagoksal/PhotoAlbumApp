package com.goksale.mediamonks.photoDetails;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.goksale.mediamonks.core.BaseActivity;
import com.goksale.mediamonks.model.PhotoUIModel;

public class PhotoDetailsActivity extends BaseActivity {

    private static final String KEY_PHOTO = "keyPhoto";

    private PhotoUIModel photoUIModel;

    public static Intent newInstance(Context context, PhotoUIModel photoUIModel) {

        final Intent intent = new Intent(context, PhotoDetailsActivity.class);
        intent.putExtra(KEY_PHOTO, photoUIModel);
        return intent;
    }

    @Nullable
    @Override
    protected Fragment getContainedFragment() {
        return PhotoDetailsFragment.newInstance(photoUIModel);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        photoUIModel = getIntent().getParcelableExtra(KEY_PHOTO);
        super.onCreate(savedInstanceState);
    }
}
