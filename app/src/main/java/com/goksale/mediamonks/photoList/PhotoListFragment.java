package com.goksale.mediamonks.photoList;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.goksale.mediamonks.R;
import com.goksale.mediamonks.core.BaseFragment;
import com.goksale.mediamonks.model.PhotoUIModel;
import com.goksale.mediamonks.network.APIManagerProvider;

import java.util.ArrayList;

import butterknife.BindView;

public class PhotoListFragment extends BaseFragment implements PhotoView, PhotoClickListener {

    private static final String KEY_PHOTO_LIST = "keyPhotoList";
    private static final String KEY_ALBUM_ID = "keyAlbumId";

    @BindView(R.id.fragment_photo_list_recyclerview)
    RecyclerView recyclerViewPhotoList;

    private int albumId;
    private ArrayList<PhotoUIModel> photoUIModelList;
    private PhotoListAdapter photoListAdapter;
    private PhotoListPresenter photoListPresenter;

    public static PhotoListFragment newInstance(int albumId) {

        final Bundle args = new Bundle();
        args.putInt(KEY_ALBUM_ID, albumId);

        final PhotoListFragment fragment = new PhotoListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        albumId = getArguments().getInt(KEY_ALBUM_ID, 0);
        photoListPresenter = new PhotoListPresenter(APIManagerProvider.getInstance(), this);
        photoListPresenter.getAlbumsPhotoList(albumId);
    }

    @Override
    protected void initUserInterface(LayoutInflater inflater, View rootView) {
        super.initUserInterface(inflater, rootView);
        photoListAdapter = new PhotoListAdapter(this);
        final RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewPhotoList.setLayoutManager(layoutManager);
        recyclerViewPhotoList.setAdapter(photoListAdapter);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_photo_list;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY_PHOTO_LIST,photoUIModelList);
        outState.putInt(KEY_ALBUM_ID, albumId);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState!= null) {
            photoUIModelList = savedInstanceState.getParcelableArrayList(KEY_PHOTO_LIST);
            albumId = savedInstanceState.getInt(KEY_ALBUM_ID);
        }
        if (photoUIModelList != null) {
            photoListAdapter.updatePhotos(photoUIModelList);
        }
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void showPhotos(ArrayList<PhotoUIModel> photoUIModelList) {
        this.photoUIModelList = photoUIModelList;
        photoListAdapter.updatePhotos(photoUIModelList);
    }

    @Override
    public void onPhotoClick(PhotoUIModel photoUIModel) {
        //TODO:show photo details
    }
}
