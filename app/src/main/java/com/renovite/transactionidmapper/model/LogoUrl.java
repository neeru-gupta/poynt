
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogoUrl implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Creator<LogoUrl> CREATOR = new Creator<LogoUrl>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LogoUrl createFromParcel(Parcel in) {
            return new LogoUrl(in);
        }

        public LogoUrl[] newArray(int size) {
            return (new LogoUrl[size]);
        }

    }
    ;

    protected LogoUrl(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public LogoUrl() {
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
