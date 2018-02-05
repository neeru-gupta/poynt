
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrackingUrl implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Creator<TrackingUrl> CREATOR = new Creator<TrackingUrl>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TrackingUrl createFromParcel(Parcel in) {
            return new TrackingUrl(in);
        }

        public TrackingUrl[] newArray(int size) {
            return (new TrackingUrl[size]);
        }

    }
    ;

    protected TrackingUrl(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TrackingUrl() {
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
