
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderProperties implements Parcelable
{

    @SerializedName("operator")
    @Expose
    private String operator;
    @SerializedName("salesPerson")
    @Expose
    private String salesPerson;
    public final static Creator<OrderProperties> CREATOR = new Creator<OrderProperties>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OrderProperties createFromParcel(Parcel in) {
            return new OrderProperties(in);
        }

        public OrderProperties[] newArray(int size) {
            return (new OrderProperties[size]);
        }

    }
    ;

    protected OrderProperties(Parcel in) {
        this.operator = ((String) in.readValue((String.class.getClassLoader())));
        this.salesPerson = ((String) in.readValue((String.class.getClassLoader())));
    }

    public OrderProperties() {
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(operator);
        dest.writeValue(salesPerson);
    }

    public int describeContents() {
        return  0;
    }

}
