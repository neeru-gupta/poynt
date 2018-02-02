
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageUrl implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Creator<ImageUrl> CREATOR = new Creator<ImageUrl>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ImageUrl createFromParcel(Parcel in) {
            return new ImageUrl(in);
        }

        public ImageUrl[] newArray(int size) {
            return (new ImageUrl[size]);
        }

    }
    ;

    protected ImageUrl(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ImageUrl() {
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
