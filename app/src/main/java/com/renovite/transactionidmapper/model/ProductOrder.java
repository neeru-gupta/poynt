
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductOrder implements Parcelable
{

    @SerializedName("order")
    @Expose
    private Order order;
    public final static Creator<ProductOrder> CREATOR = new Creator<ProductOrder>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProductOrder createFromParcel(Parcel in) {
            return new ProductOrder(in);
        }

        public ProductOrder[] newArray(int size) {
            return (new ProductOrder[size]);
        }

    }
    ;

    protected ProductOrder(Parcel in) {
        this.order = ((Order) in.readValue((Order.class.getClassLoader())));
    }

    public ProductOrder() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(order);
    }

    public int describeContents() {
        return  0;
    }

}
