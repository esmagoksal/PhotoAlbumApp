/*
 * Copyright 2003-2017 Monitise Group Limited. All Rights Reserved.
 *
 * Save to the extent permitted by law, you may not use, copy, modify,
 * distribute or create derivative works of this material or any part
 * of it without the prior written consent of Monitise Group Limited.
 * Any reproduction of this material must contain this notice.
 */

package com.goksale.mediamonks.albumList;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.goksale.mediamonks.model.AlbumUIModel;
import com.goksale.mediamonks.model.PhotoUIModel;
import com.goksale.mediamonks.util.ListUtil;

import java.util.ArrayList;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListViewHolder> {

    private ArrayList<AlbumUIModel> albumUIModelList;
    private ArrayList<PhotoUIModel> photoUIModelList;
    private AlbumClickListener albumClickListener;

    public AlbumListAdapter(AlbumClickListener albumClickListener) {
        albumUIModelList = new ArrayList<>();
        this.albumClickListener = albumClickListener;
    }

    @Override
    public AlbumListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AlbumListViewHolder(parent, albumClickListener);
    }

    @Override
    public void onBindViewHolder(AlbumListViewHolder holder, int position) {
        final AlbumUIModel albumUIModel = albumUIModelList.get(position);
        final ArrayList<PhotoUIModel> photosOfAlbum = ListUtil.getPhotosOfAlbum(photoUIModelList, albumUIModel.getId());
        holder.onBindViewHolder(albumUIModel, photosOfAlbum.get(0), photosOfAlbum.size());
    }

    @Override
    public int getItemCount() {
        return albumUIModelList.size();
    }

    public void updateAlbums(ArrayList<AlbumUIModel> albumUIModelList, ArrayList<PhotoUIModel> photoUIModelList) {
        this.albumUIModelList = albumUIModelList;
        //FIXME:update this
        this.photoUIModelList = photoUIModelList;
        notifyDataSetChanged();
    }
}
