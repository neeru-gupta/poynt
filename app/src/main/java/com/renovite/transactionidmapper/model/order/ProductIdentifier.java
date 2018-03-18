
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

public class ProductIdentifier implements Serializable, Parcelable
{

    @SerializedName("gtin12")
    @Expose
    private String gtin12;
    @SerializedName("gtin13")
    @Expose
    private String gtin13;
    @SerializedName("gtin14")
    @Expose
    private String gtin14;
    @SerializedName("gtin8")
    @Expose
    private String gtin8;
    public final static Creator<ProductIdentifier> CREATOR = new Creator<ProductIdentifier>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProductIdentifier createFromParcel(Parcel in) {
            return new ProductIdentifier(in);
        }

        public ProductIdentifier[] newArray(int size) {
            return (new ProductIdentifier[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8810762202684813022L;

    protected ProductIdentifier(Parcel in) {
        this.gtin12 = ((String) in.readValue((String.class.getClassLoader())));
        this.gtin13 = ((String) in.readValue((String.class.getClassLoader())));
        this.gtin14 = ((String) in.readValue((String.class.getClassLoader())));
        this.gtin8 = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductIdentifier() {
    }

    /**
     * 
     * @param gtin14
     * @param gtin13
     * @param gtin12
     * @param gtin8
     */
    public ProductIdentifier(String gtin12, String gtin13, String gtin14, String gtin8) {
        super();
        this.gtin12 = gtin12;
        this.gtin13 = gtin13;
        this.gtin14 = gtin14;
        this.gtin8 = gtin8;
    }

    public String getGtin12() {
        return gtin12;
    }

    public void setGtin12(String gtin12) {
        this.gtin12 = gtin12;
    }

    public ProductIdentifier withGtin12(String gtin12) {
        this.gtin12 = gtin12;
        return this;
    }

    public String getGtin13() {
        return gtin13;
    }

    public void setGtin13(String gtin13) {
        this.gtin13 = gtin13;
    }

    public ProductIdentifier withGtin13(String gtin13) {
        this.gtin13 = gtin13;
        return this;
    }

    public String getGtin14() {
        return gtin14;
    }

    public void setGtin14(String gtin14) {
        this.gtin14 = gtin14;
    }

    public ProductIdentifier withGtin14(String gtin14) {
        this.gtin14 = gtin14;
        return this;
    }

    public String getGtin8() {
        return gtin8;
    }

    public void setGtin8(String gtin8) {
        this.gtin8 = gtin8;
    }

    public ProductIdentifier withGtin8(String gtin8) {
        this.gtin8 = gtin8;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("gtin12", gtin12).append("gtin13", gtin13).append("gtin14", gtin14).append("gtin8", gtin8).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(gtin14).append(gtin13).append(gtin12).append(gtin8).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProductIdentifier) == false) {
            return false;
        }
        ProductIdentifier rhs = ((ProductIdentifier) other);
        return new EqualsBuilder().append(gtin14, rhs.gtin14).append(gtin13, rhs.gtin13).append(gtin12, rhs.gtin12).append(gtin8, rhs.gtin8).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(gtin12);
        dest.writeValue(gtin13);
        dest.writeValue(gtin14);
        dest.writeValue(gtin8);
    }

    public int describeContents() {
        return  0;
    }

}
