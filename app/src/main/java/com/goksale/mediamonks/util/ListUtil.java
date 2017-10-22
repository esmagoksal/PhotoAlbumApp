package com.goksale.mediamonks.util;


import com.goksale.mediamonks.model.AlbumUIModel;
import com.goksale.mediamonks.model.PhotoUIModel;

import java.util.ArrayList;

public final class ListUtil {

    private ListUtil() {
    }

    public static ArrayList<PhotoUIModel> getPhotosOfAlbum(ArrayList<PhotoUIModel> photoUIModelList, int albumId) {
        final ArrayList<PhotoUIModel> photosOfAlbum = new ArrayList<>();
        for (PhotoUIModel photoUIModel : photoUIModelList) {
            if (photoUIModel.getAlbumId() == albumId) {
                photosOfAlbum.add(photoUIModel);
            }
        }
        return photosOfAlbum;
    }

    public static ArrayList<PhotoUIModel> getCoverPhotoList(ArrayList<PhotoUIModel> photoUIModelList, ArrayList<AlbumUIModel> albumUIModelList) {
        final ArrayList<PhotoUIModel> coverPhotoUIModelList = new ArrayList<>();

        for (AlbumUIModel albumUIModel : albumUIModelList) {
            for (PhotoUIModel photoUIModel : photoUIModelList) {
                if (albumUIModel.getId() == photoUIModel.getAlbumId()) {
                    coverPhotoUIModelList.add(photoUIModel);
                    break;
                }
            }
        }
        return coverPhotoUIModelList;
    }
}
