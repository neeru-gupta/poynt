
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

public class LogoUrl implements Serializable, Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Creator<LogoUrl> CREATOR = new Creator<LogoUrl>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LogoUrl createFromParcel(Parcel in) {
            return new LogoUrl(in);
        }

        public LogoUrl[] newArray(int size) {
            return (new LogoUrl[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6711360387434693013L;

    protected LogoUrl(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public LogoUrl() {
    }

    /**
     * 
     * @param href
     */
    public LogoUrl(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public LogoUrl withHref(String href) {
        this.href = href;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("href", href).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(href).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LogoUrl) == false) {
            return false;
        }
        LogoUrl rhs = ((LogoUrl) other);
        return new EqualsBuilder().append(href, rhs.href).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
