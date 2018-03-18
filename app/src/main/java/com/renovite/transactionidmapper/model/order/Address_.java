
package com.renovite.transactionidmapper.model.order;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Address_ implements Serializable, Parcelable
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
    public final static Creator<Address_> CREATOR = new Creator<Address_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Address_ createFromParcel(Parcel in) {
            return new Address_(in);
        }

        public Address_[] newArray(int size) {
            return (new Address_[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6568222418690416603L;

    protected Address_(Parcel in) {
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.locality = ((String) in.readValue((String.class.getClassLoader())));
        this.postalCode = ((String) in.readValue((String.class.getClassLoader())));
        this.region = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.streetLines, (String.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Address_() {
    }

    /**
     * 
     * @param region
     * @param postalCode
     * @param streetLines
     * @param locality
     * @param country
     */
    public Address_(String country, String locality, String postalCode, String region, List<String> streetLines) {
        super();
        this.country = country;
        this.locality = locality;
        this.postalCode = postalCode;
        this.region = region;
        this.streetLines = streetLines;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address_ withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Address_ withLocality(String locality) {
        this.locality = locality;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Address_ withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Address_ withRegion(String region) {
        this.region = region;
        return this;
    }

    public List<String> getStreetLines() {
        return streetLines;
    }

    public void setStreetLines(List<String> streetLines) {
        this.streetLines = streetLines;
    }

    public Address_ withStreetLines(List<String> streetLines) {
        this.streetLines = streetLines;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("country", country).append("locality", locality).append("postalCode", postalCode).append("region", region).append("streetLines", streetLines).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(region).append(postalCode).append(streetLines).append(locality).append(country).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Address_) == false) {
            return false;
        }
        Address_ rhs = ((Address_) other);
        return new EqualsBuilder().append(region, rhs.region).append(postalCode, rhs.postalCode).append(streetLines, rhs.streetLines).append(locality, rhs.locality).append(country, rhs.country).isEquals();
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
