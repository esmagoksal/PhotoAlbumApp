package com.goksale.mvp.photoList;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.goksale.mvp.R;
import com.goksale.mvp.model.PhotoUIModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.item_photo_list_imageview)
    ImageView imageViewPhoto;

    @BindView(R.id.item_photo_list_title)
    TextView textViewPhotoTitle;

    private PhotoClickListener photoClickListener;
    private PhotoUIModel photoUIModel;

    public PhotoListViewHolder(ViewGroup parent, PhotoClickListener photoClickListener) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_list, parent, false));
        ButterKnife.bind(this, itemView);
        this.photoClickListener = photoClickListener;
        adjustHeight(parent);
    }

    public void onBindViewHolder(PhotoUIModel photoUIModel) {

        this.photoUIModel = photoUIModel;
        Picasso.with(itemView.getContext())
                .load(photoUIModel.getThumbnailUrl())
                .into(imageViewPhoto);

        textViewPhotoTitle.setText(photoUIModel.getTitle());

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        photoClickListener.onPhotoClick(photoUIModel);
    }

    public void adjustHeight(ViewGroup parent) {
        final GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) itemView.getLayoutParams();
        final int width = parent.getMeasuredWidth();
        final float height = (float) width / 2;
        layoutParams.height = Math.round(height);
        itemView.setLayoutParams(layoutParams);
    }
}
