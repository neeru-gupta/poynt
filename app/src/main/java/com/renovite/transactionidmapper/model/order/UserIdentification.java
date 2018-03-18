
package com.renovite.transactionidmapper.model.order;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserIdentification implements Serializable, Parcelable
{

    @SerializedName("isGuest")
    @Expose
    private Boolean isGuest;
    @SerializedName("retailerUserRef")
    @Expose
    private String retailerUserRef;
    public final static Creator<UserIdentification> CREATOR = new Creator<UserIdentification>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserIdentification createFromParcel(Parcel in) {
            return new UserIdentification(in);
        }

        public UserIdentification[] newArray(int size) {
            return (new UserIdentification[size]);
        }

    }
    ;
    private final static long serialVersionUID = -407761949809821738L;

    protected UserIdentification(Parcel in) {
        this.isGuest = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.retailerUserRef = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public UserIdentification() {
    }

    /**
     * 
     * @param isGuest
     * @param retailerUserRef
     */
    public UserIdentification(Boolean isGuest, String retailerUserRef) {
        super();
        this.isGuest = isGuest;
        this.retailerUserRef = retailerUserRef;
    }

    public Boolean getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(Boolean isGuest) {
        this.isGuest = isGuest;
    }

    public UserIdentification withIsGuest(Boolean isGuest) {
        this.isGuest = isGuest;
        return this;
    }

    public String getRetailerUserRef() {
        return retailerUserRef;
    }

    public void setRetailerUserRef(String retailerUserRef) {
        this.retailerUserRef = retailerUserRef;
    }

    public UserIdentification withRetailerUserRef(String retailerUserRef) {
        this.retailerUserRef = retailerUserRef;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("isGuest", isGuest).append("retailerUserRef", retailerUserRef).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(isGuest).append(retailerUserRef).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UserIdentification) == false) {
            return false;
        }
        UserIdentification rhs = ((UserIdentification) other);
        return new EqualsBuilder().append(isGuest, rhs.isGuest).append(retailerUserRef, rhs.retailerUserRef).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(isGuest);
        dest.writeValue(retailerUserRef);
    }

    public int describeContents() {
        return  0;
    }

}
