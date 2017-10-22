package com.goksale.mediamonks.core;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.goksale.mediamonks.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            Fragment initialFragment = getContainedFragment();
            if (initialFragment != null) {
                addFragment(initialFragment, initialFragment.getTag(), false);
            }
        }
    }

    protected int getLayoutResId() {
        return R.layout.activity_base;
    }

    protected void addFragment(Fragment fragment, String tag, boolean addToBackStack) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(tag);
        }
        transaction.add(getFragmentContainerId(), fragment, tag).commit();
    }

    protected int getFragmentContainerId() {
        return R.id.activity_base_framelayout_container;
    }

    @Nullable
    protected abstract Fragment getContainedFragment();
}
