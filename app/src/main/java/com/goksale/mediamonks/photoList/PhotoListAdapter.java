package com.goksale.mediamonks.photoList;


import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.goksale.mediamonks.model.PhotoUIModel;

import java.util.ArrayList;
import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListViewHolder> {

    private List<PhotoUIModel> photoUIModelList;
    private PhotoClickListener photoClickListener;

    public PhotoListAdapter(PhotoClickListener photoClickListener) {
        photoUIModelList = new ArrayList<>();
        this.photoClickListener = photoClickListener;
    }

    @Override
    public PhotoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PhotoListViewHolder(parent, photoClickListener);
    }

    @Override
    public void onBindViewHolder(PhotoListViewHolder holder, int position) {
        holder.onBindViewHolder(photoUIModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return photoUIModelList.size();
    }

    public void updatePhotos(List<PhotoUIModel> photoUIModelList) {
        this.photoUIModelList = photoUIModelList;
        notifyDataSetChanged();
    }
}
