package com.goksale.mvp.albumList;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.goksale.mvp.R;
import com.goksale.mvp.core.BaseFragment;
import com.goksale.mvp.model.AlbumUIModel;
import com.goksale.mvp.model.PhotoUIModel;
import com.goksale.mvp.network.APIManagerProvider;
import com.goksale.mvp.util.DialogUtil;

import java.util.ArrayList;

import butterknife.BindView;

public class AlbumListFragment extends BaseFragment implements AlbumView, AlbumClickListener {

    private static final String KEY_ALBUM_LIST = "keyAlbumList";
    private static final String KEY_PHOTO_LIST = "keyPhotoList";

    @BindView(R.id.fragment_album_list_recyclerview)
    RecyclerView recyclerViewMovieList;

    private AlbumListPresenter albumListPresenter;
    private AlbumListAdapter albumListAdapter;
    private ArrayList<AlbumUIModel> albumUIModelList;
    private ArrayList<PhotoUIModel> coverPhotoUIModelList;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_album_list;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        albumListPresenter = new AlbumListPresenter(new APIManagerProvider(), this);
    }

    @Override
    protected void initUserInterface(LayoutInflater inflater, View rootView) {
        super.initUserInterface(inflater, rootView);

        albumListAdapter = new AlbumListAdapter(this);
        final RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewMovieList.setLayoutManager(layoutManager);
        recyclerViewMovieList.setAdapter(albumListAdapter);
        if (albumUIModelList == null || albumUIModelList.isEmpty()) {
            albumListPresenter.getAlbumList(getContext());
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY_ALBUM_LIST, albumUIModelList);
        outState.putParcelableArrayList(KEY_PHOTO_LIST, coverPhotoUIModelList);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            coverPhotoUIModelList = savedInstanceState.getParcelableArrayList(KEY_PHOTO_LIST);
            albumUIModelList = savedInstanceState.getParcelableArrayList(KEY_ALBUM_LIST);
        }
        if (albumUIModelList != null && coverPhotoUIModelList != null) {
            albumListAdapter.updateAlbums(albumUIModelList, coverPhotoUIModelList);
        }
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void showAlbumList(ArrayList<AlbumUIModel> albumUIModelList) {
        this.albumUIModelList = albumUIModelList;
        albumListPresenter.getCoverPhotoList(albumUIModelList);

    }

    @Override
    public void getCoverPhotos(ArrayList<PhotoUIModel> photoUIModelList) {
        this.coverPhotoUIModelList = photoUIModelList;
        albumListAdapter.updateAlbums(albumUIModelList, coverPhotoUIModelList);
        DialogUtil.dismissProgress();
    }

    @Override
    public void onAlbumClick(AlbumUIModel albumUIModel) {
        albumListPresenter.onAlbumClick(getContext(), albumUIModel);
    }
}
