
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Optin implements Parcelable
{

    @SerializedName("channel")
    @Expose
    private String channel;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;
    @SerializedName("feature")
    @Expose
    private String feature;
    public final static Creator<Optin> CREATOR = new Creator<Optin>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Optin createFromParcel(Parcel in) {
            return new Optin(in);
        }

        public Optin[] newArray(int size) {
            return (new Optin[size]);
        }

    }
    ;

    protected Optin(Parcel in) {
        this.channel = ((String) in.readValue((String.class.getClassLoader())));
        this.enabled = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.feature = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Optin() {
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(channel);
        dest.writeValue(enabled);
        dest.writeValue(feature);
    }

    public int describeContents() {
        return  0;
    }

}
