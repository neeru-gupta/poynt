
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Url implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Creator<Url> CREATOR = new Creator<Url>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Url createFromParcel(Parcel in) {
            return new Url(in);
        }

        public Url[] newArray(int size) {
            return (new Url[size]);
        }

    }
    ;

    protected Url(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Url() {
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
