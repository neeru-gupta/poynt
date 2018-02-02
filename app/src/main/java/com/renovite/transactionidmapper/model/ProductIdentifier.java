
package com.renovite.transactionidmapper.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductIdentifier implements Parcelable
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

    protected ProductIdentifier(Parcel in) {
        this.gtin12 = ((String) in.readValue((String.class.getClassLoader())));
        this.gtin13 = ((String) in.readValue((String.class.getClassLoader())));
        this.gtin14 = ((String) in.readValue((String.class.getClassLoader())));
        this.gtin8 = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ProductIdentifier() {
    }

    public String getGtin12() {
        return gtin12;
    }

    public void setGtin12(String gtin12) {
        this.gtin12 = gtin12;
    }

    public String getGtin13() {
        return gtin13;
    }

    public void setGtin13(String gtin13) {
        this.gtin13 = gtin13;
    }

    public String getGtin14() {
        return gtin14;
    }

    public void setGtin14(String gtin14) {
        this.gtin14 = gtin14;
    }

    public String getGtin8() {
        return gtin8;
    }

    public void setGtin8(String gtin8) {
        this.gtin8 = gtin8;
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
