package com.goksale.mvp.photoList;


import android.content.Context;

import com.goksale.mvp.core.BasePresenter;
import com.goksale.mvp.model.PhotoUIModel;
import com.goksale.mvp.network.APIManagerProvider;
import com.goksale.mvp.util.DialogUtil;

import java.util.ArrayList;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class PhotoListPresenter extends BasePresenter {

    private APIManagerProvider apiManagerProvider;
    private PhotoView photoView;
    private CompositeSubscription subscriptions;

    public PhotoListPresenter(APIManagerProvider apiManagerProvider, PhotoView photoView) {
        this.apiManagerProvider = apiManagerProvider;
        this.photoView = photoView;
        subscriptions = new CompositeSubscription();
    }

    public void getAlbumsPhotoList(Context context, int albumId) {

        DialogUtil.showProgress(context);
        final Subscription subscription = apiManagerProvider.getAlbumsPhotos(albumId, new PhotoListCallback() {
            @Override
            public void onSuccess(ArrayList<PhotoUIModel> photoList) {
                photoView.showPhotos(photoList);
            }

            @Override
            public void onError() {

            }
        });
    }

    public void onPhotoClick(Context context, PhotoUIModel photoUIModel) {
        navigator.navigateToPhotoDetails(context, photoUIModel);
    }
}
