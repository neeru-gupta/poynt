
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Store implements Parcelable
{

    @SerializedName("address")
    @Expose
    private Store_Address address;
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

    protected Store(Parcel in) {
        this.address = ((Store_Address) in.readValue((Store_Address.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.storeRef = ((String) in.readValue((String.class.getClassLoader())));
        this.tillRef = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Store() {
    }

    public Store_Address getAddress() {
        return address;
    }

    public void setAddress(Store_Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStoreRef() {
        return storeRef;
    }

    public void setStoreRef(String storeRef) {
        this.storeRef = storeRef;
    }

    public String getTillRef() {
        return tillRef;
    }

    public void setTillRef(String tillRef) {
        this.tillRef = tillRef;
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
