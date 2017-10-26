package com.goksale.mvp.core;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(getLayoutResId(), container, false);
        initUserInterface(inflater, view);
        return view;
    }

    protected abstract int getLayoutResId();

    protected void initUserInterface(LayoutInflater inflater, View rootView) {
        ButterKnife.bind(this, rootView);
    }
}
