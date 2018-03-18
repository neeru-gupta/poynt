
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

public class Store implements Serializable, Parcelable
{

    @SerializedName("address")
    @Expose
    private Address_ address;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("storeRef")
    @Expose
    private String storeRef;
    @SerializedName("tillRef")
    @Expose
    private String tillRef;
    public final static Creator<Store> CREATOR = new Creator<Store>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        public Store[] newArray(int size) {
            return (new Store[size]);
        }

    }
    ;
    private final static long serialVersionUID = -7632718012557118687L;

    protected Store(Parcel in) {
        this.address = ((Address_) in.readValue((Address_.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.storeRef = ((String) in.readValue((String.class.getClassLoader())));
        this.tillRef = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Store() {
    }

    /**
     * 
     * @param phone
     * @param address
     * @param storeRef
     * @param name
     * @param tillRef
     */
    public Store(Address_ address, String name, String phone, String storeRef, String tillRef) {
        super();
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.storeRef = storeRef;
        this.tillRef = tillRef;
    }

    public Address_ getAddress() {
        return address;
    }

    public void setAddress(Address_ address) {
        this.address = address;
    }

    public Store withAddress(Address_ address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store withName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Store withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getStoreRef() {
        return storeRef;
    }

    public void setStoreRef(String storeRef) {
        this.storeRef = storeRef;
    }

    public Store withStoreRef(String storeRef) {
        this.storeRef = storeRef;
        return this;
    }

    public String getTillRef() {
        return tillRef;
    }

    public void setTillRef(String tillRef) {
        this.tillRef = tillRef;
    }

    public Store withTillRef(String tillRef) {
        this.tillRef = tillRef;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("address", address).append("name", name).append("phone", phone).append("storeRef", storeRef).append("tillRef", tillRef).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(phone).append(address).append(storeRef).append(name).append(tillRef).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Store) == false) {
            return false;
        }
        Store rhs = ((Store) other);
        return new EqualsBuilder().append(phone, rhs.phone).append(address, rhs.address).append(storeRef, rhs.storeRef).append(name, rhs.name).append(tillRef, rhs.tillRef).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(address);
        dest.writeValue(name);
        dest.writeValue(phone);
        dest.writeValue(storeRef);
        dest.writeValue(tillRef);
    }

    public int describeContents() {
        return  0;
    }

}
