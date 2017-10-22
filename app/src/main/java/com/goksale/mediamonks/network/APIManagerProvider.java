package com.goksale.mediamonks.network;


import com.goksale.mediamonks.albumList.AlbumListCallback;
import com.goksale.mediamonks.core.PhotoAlbumApp;
import com.goksale.mediamonks.model.AlbumUIModel;
import com.goksale.mediamonks.model.PhotoUIModel;
import com.goksale.mediamonks.photoList.PhotoListCallback;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


@javax.inject.Singleton
public class APIManagerProvider {

    private static APIManagerProvider apiManagerProvider;

    public static APIManagerProvider getInstance() {
        if (apiManagerProvider == null) {
            apiManagerProvider = new APIManagerProvider();
        }
        return apiManagerProvider;
    }

    public Subscription getAlbums(final AlbumListCallback callback) {

        return PhotoAlbumApp.getApiManager().getAlbumList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ArrayList<AlbumUIModel>>>() {
                    @Override
                    public Observable<? extends ArrayList<AlbumUIModel>> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<ArrayList<AlbumUIModel>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError();
                    }

                    @Override
                    public void onNext(ArrayList<AlbumUIModel> albumUIModels) {
                        callback.onSuccess(albumUIModels);
                    }
                });
    }

    public Subscription getPhotoList(final PhotoListCallback callBack) {

        return PhotoAlbumApp.getApiManager().getPhotoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ArrayList<PhotoUIModel>>>() {
                    @Override
                    public Observable<? extends ArrayList<PhotoUIModel>> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<ArrayList<PhotoUIModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError();
                    }

                    @Override
                    public void onNext(ArrayList<PhotoUIModel> photoUIModelList) {
                        callBack.onSuccess(photoUIModelList);
                    }
                });
    }

    public Subscription getAlbumsPhotos(int albumId, final PhotoListCallback callBack) {

        return PhotoAlbumApp.getApiManager().getAlbumsPhotos(albumId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends ArrayList<PhotoUIModel>>>() {
                    @Override
                    public Observable<? extends ArrayList<PhotoUIModel>> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<ArrayList<PhotoUIModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onError();
                    }

                    @Override
                    public void onNext(ArrayList<PhotoUIModel> photoUIModelList) {
                        callBack.onSuccess(photoUIModelList);
                    }

                });
    }
}
