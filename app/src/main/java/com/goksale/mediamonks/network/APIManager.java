package com.goksale.mediamonks.network;


import com.goksale.mediamonks.model.AlbumUIModel;
import com.goksale.mediamonks.model.PhotoUIModel;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIManager {

    @GET("/albums")
    Observable<ArrayList<AlbumUIModel>> getAlbumList();

    @GET("/photos")
    Observable<ArrayList<PhotoUIModel>> getPhotoList();

    @GET("/photos")
    Observable<ArrayList<PhotoUIModel>> getAlbumsPhotos(@Query("albumId") int albumId);
}
