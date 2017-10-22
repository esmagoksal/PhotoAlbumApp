package com.goksale.mediamonks.photoList;


import android.content.Context;

import com.goksale.mediamonks.core.BasePresenter;
import com.goksale.mediamonks.model.PhotoUIModel;
import com.goksale.mediamonks.network.APIManagerProvider;

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

    public void getAlbumsPhotoList(int albumId) {

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
