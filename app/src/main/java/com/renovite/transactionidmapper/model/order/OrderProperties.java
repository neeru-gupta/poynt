
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

public class OrderProperties implements Serializable, Parcelable
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
    private final static long serialVersionUID = -6354701113244085865L;

    protected OrderProperties(Parcel in) {
        this.operator = ((String) in.readValue((String.class.getClassLoader())));
        this.salesPerson = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public OrderProperties() {
    }

    /**
     * 
     * @param salesPerson
     * @param operator
     */
    public OrderProperties(String operator, String salesPerson) {
        super();
        this.operator = operator;
        this.salesPerson = salesPerson;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public OrderProperties withOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }

    public OrderProperties withSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("operator", operator).append("salesPerson", salesPerson).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(salesPerson).append(operator).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OrderProperties) == false) {
            return false;
        }
        OrderProperties rhs = ((OrderProperties) other);
        return new EqualsBuilder().append(salesPerson, rhs.salesPerson).append(operator, rhs.operator).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(operator);
        dest.writeValue(salesPerson);
    }

    public int describeContents() {
        return  0;
    }

}
