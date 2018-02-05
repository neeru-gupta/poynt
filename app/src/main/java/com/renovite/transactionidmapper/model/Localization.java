
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Localization implements Parcelable
{

    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    public final static Creator<Localization> CREATOR = new Creator<Localization>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Localization createFromParcel(Parcel in) {
            return new Localization(in);
        }

        public Localization[] newArray(int size) {
            return (new Localization[size]);
        }

    }
    ;

    protected Localization(Parcel in) {
        this.locale = ((String) in.readValue((String.class.getClassLoader())));
        this.timezone = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Localization() {
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(locale);
        dest.writeValue(timezone);
    }

    public int describeContents() {
        return  0;
    }

}
