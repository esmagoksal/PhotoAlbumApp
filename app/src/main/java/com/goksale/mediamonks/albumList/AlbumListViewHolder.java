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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.goksale.mediamonks.R;
import com.goksale.mediamonks.model.AlbumUIModel;
import com.goksale.mediamonks.model.PhotoUIModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AlbumListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.item_album_background)
    ImageView imageViewAlbumCover;

    @BindView(R.id.item_album_title)
    TextView textViewAlbumTitle;

    private AlbumClickListener albumClickListener;
    private AlbumUIModel albumUIModel;

    public AlbumListViewHolder(ViewGroup parent, AlbumClickListener albumClickListener) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album_list, parent, false));
        ButterKnife.bind(this, itemView);
        this.albumClickListener = albumClickListener;
    }

    public void onBindViewHolder(AlbumUIModel albumUIModel, PhotoUIModel coverPhotoUIModel) {
        this.albumUIModel = albumUIModel;
        textViewAlbumTitle.setText(albumUIModel.getTitle());

        Picasso.with(itemView.getContext())
                .load(coverPhotoUIModel.getThumbnailUrl())
                .into(imageViewAlbumCover);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        albumClickListener.onAlbumClick(albumUIModel);
    }
}
