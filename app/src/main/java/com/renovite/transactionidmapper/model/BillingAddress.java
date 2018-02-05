
package com.renovite.transactionidmapper.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BillingAddress implements Parcelable
{

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("streetLines")
    @Expose
    private List<String> streetLines = null;
    public final static Creator<BillingAddress> CREATOR = new Creator<BillingAddress>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BillingAddress createFromParcel(Parcel in) {
            return new BillingAddress(in);
        }

        public BillingAddress[] newArray(int size) {
            return (new BillingAddress[size]);
        }

    }
    ;

    protected BillingAddress(Parcel in) {
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.locality = ((String) in.readValue((String.class.getClassLoader())));
        this.postalCode = ((String) in.readValue((String.class.getClassLoader())));
        this.region = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.streetLines, (String.class.getClassLoader()));
    }

    public BillingAddress() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<String> getStreetLines() {
        return streetLines;
    }

    public void setStreetLines(List<String> streetLines) {
        this.streetLines = streetLines;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(country);
        dest.writeValue(locality);
        dest.writeValue(postalCode);
        dest.writeValue(region);
        dest.writeList(streetLines);
    }

    public int describeContents() {
        return  0;
    }

}
