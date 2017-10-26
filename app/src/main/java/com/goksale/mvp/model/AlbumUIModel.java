package com.goksale.mvp.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AlbumUIModel implements Parcelable {

    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.userId);
        dest.writeInt(this.id);
        dest.writeString(this.title);
    }

    protected AlbumUIModel(Parcel in) {
        this.userId = in.readInt();
        this.id = in.readInt();
        this.title = in.readString();
    }

    public static final Creator<AlbumUIModel> CREATOR = new Creator<AlbumUIModel>() {
        @Override
        public AlbumUIModel createFromParcel(Parcel source) {
            return new AlbumUIModel(source);
        }

        @Override
        public AlbumUIModel[] newArray(int size) {
            return new AlbumUIModel[size];
        }
    };
}
