package com.goksale.mvp.photoDetails;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.goksale.mvp.R;
import com.goksale.mvp.core.BaseFragment;
import com.goksale.mvp.model.PhotoUIModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class PhotoDetailsFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.fragment_photo_details_photo)
    ImageView imageViewPhoto;

    @BindView(R.id.fragment_photo_details_photo_title)
    TextView textViewPhotoTitle;

    @BindView(R.id.fragment_photo_details_cancel)
    ImageView imageViewCancelButton;

    private static final String KEY_PHOTO = "keyPhoto";

    public static PhotoDetailsFragment newInstance(PhotoUIModel photoUIModel) {

        final Bundle args = new Bundle();
        args.putParcelable(KEY_PHOTO, photoUIModel);

        final PhotoDetailsFragment fragment = new PhotoDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private PhotoUIModel photoUIModel;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_photo_details;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        photoUIModel = getArguments().getParcelable(KEY_PHOTO);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initUserInterface(LayoutInflater inflater, View rootView) {
        super.initUserInterface(inflater, rootView);
        Picasso.with(getContext())
                .load(photoUIModel.getUrl())
                .into(imageViewPhoto);
        textViewPhotoTitle.setText(photoUIModel.getTitle());
        imageViewCancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fragment_photo_details_cancel) {
            getActivity().finish();
        }
    }

}
