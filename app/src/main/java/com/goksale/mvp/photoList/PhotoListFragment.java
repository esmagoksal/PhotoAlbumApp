package com.goksale.mvp.photoList;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.goksale.mvp.R;
import com.goksale.mvp.core.BaseFragment;
import com.goksale.mvp.model.AlbumUIModel;
import com.goksale.mvp.model.PhotoUIModel;
import com.goksale.mvp.network.APIManagerProvider;
import com.goksale.mvp.util.DialogUtil;

import java.util.ArrayList;

import butterknife.BindView;

public class PhotoListFragment extends BaseFragment implements PhotoView, PhotoClickListener {

    private static final String KEY_PHOTO_LIST = "keyPhotoList";
    private static final String KEY_ALBUM = "keyAlbum";

    @BindView(R.id.fragment_photo_list_recyclerview)
    RecyclerView recyclerViewPhotoList;

    @BindView(R.id.fragment_photo_list_album_title)
    TextView textViewAlbumTitle;

    private AlbumUIModel album;
    private ArrayList<PhotoUIModel> photoUIModelList;
    private PhotoListAdapter photoListAdapter;
    private PhotoListPresenter photoListPresenter;

    public static PhotoListFragment newInstance(AlbumUIModel album) {

        final Bundle args = new Bundle();
        args.putParcelable(KEY_ALBUM, album);

        final PhotoListFragment fragment = new PhotoListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        album = getArguments().getParcelable(KEY_ALBUM);
        photoListPresenter = new PhotoListPresenter(APIManagerProvider.getInstance(), this);
        if (photoUIModelList == null || photoUIModelList.isEmpty()) {
            photoListPresenter.getAlbumsPhotoList(getContext(), album.getId());
        }
    }

    @Override
    protected void initUserInterface(LayoutInflater inflater, View rootView) {
        super.initUserInterface(inflater, rootView);
        photoListAdapter = new PhotoListAdapter(this);
        final RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerViewPhotoList.setLayoutManager(layoutManager);
        recyclerViewPhotoList.setAdapter(photoListAdapter);
        textViewAlbumTitle.setText(album.getTitle());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_photo_list;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY_PHOTO_LIST, photoUIModelList);
        outState.putParcelable(KEY_ALBUM, album);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            photoUIModelList = savedInstanceState.getParcelableArrayList(KEY_PHOTO_LIST);
            album = savedInstanceState.getParcelable(KEY_ALBUM);
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
        DialogUtil.dismissProgress();
    }

    @Override
    public void onPhotoClick(PhotoUIModel photoUIModel) {
        photoListPresenter.onPhotoClick(getContext(), photoUIModel);
    }
}
