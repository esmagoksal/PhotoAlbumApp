package com.goksale.mediamonks.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PhotoUIModel implements Parcelable {

    @SerializedName("albumId")
    private int albumId;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.albumId);
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.thumbnailUrl);
    }

    public PhotoUIModel() {
    }

    protected PhotoUIModel(Parcel in) {
        this.albumId = in.readInt();
        this.id = in.readInt();
        this.title = in.readString();
        this.url = in.readString();
        this.thumbnailUrl = in.readString();
    }

    public static final Creator<PhotoUIModel> CREATOR = new Creator<PhotoUIModel>() {
        @Override
        public PhotoUIModel createFromParcel(Parcel source) {
            return new PhotoUIModel(source);
        }

        @Override
        public PhotoUIModel[] newArray(int size) {
            return new PhotoUIModel[size];
        }
    };
}
