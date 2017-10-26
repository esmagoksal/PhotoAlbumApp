package com.goksale.mvp.albumList;


import android.content.Context;

import com.goksale.mvp.core.BasePresenter;
import com.goksale.mvp.model.AlbumUIModel;
import com.goksale.mvp.model.PhotoUIModel;
import com.goksale.mvp.network.APIManagerProvider;
import com.goksale.mvp.photoList.PhotoListCallback;
import com.goksale.mvp.util.DialogUtil;
import com.goksale.mvp.util.ListUtil;

import java.util.ArrayList;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class AlbumListPresenter extends BasePresenter {

    private APIManagerProvider apiManagerProvider;
    private AlbumView albumView;
    private CompositeSubscription subscriptions;

    public AlbumListPresenter(APIManagerProvider apiManagerProvider, AlbumView albumView) {
        this.apiManagerProvider = apiManagerProvider;
        this.albumView = albumView;
        subscriptions = new CompositeSubscription();
    }

    public void getAlbumList(Context context) {

        DialogUtil.showProgress(context);
        final Subscription subscription = apiManagerProvider.getAlbums(new AlbumListCallback() {
            @Override
            public void onSuccess(ArrayList<AlbumUIModel> albumList) {
                albumView.showAlbumList(albumList);
            }

            @Override
            public void onError() {
                //TODO:showError
            }
        });

        subscriptions.add(subscription);
    }

    //Since it is too big data to keep I decided to keep only cover photos
    public void getCoverPhotoList(final ArrayList<AlbumUIModel> albumUIModelList) {

        final Subscription subscription = apiManagerProvider.getPhotoList(new PhotoListCallback() {
            @Override
            public void onSuccess(ArrayList<PhotoUIModel> photoList) {
                albumView.getCoverPhotos(ListUtil.getCoverPhotoList(photoList, albumUIModelList));
            }

            @Override
            public void onError() {
                //TODO:showError
            }
        });
    }

    public void onAlbumClick(Context context, AlbumUIModel album) {
        navigator.navigateToPhotoList(context, album);
    }
}
