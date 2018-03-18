
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

public class Localization implements Serializable, Parcelable
{

    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    public final static Creator<Localization> CREATOR = new Creator<Localization>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Localization createFromParcel(Parcel in) {
            return new Localization(in);
        }

        public Localization[] newArray(int size) {
            return (new Localization[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5350763080849850376L;

    protected Localization(Parcel in) {
        this.locale = ((String) in.readValue((String.class.getClassLoader())));
        this.timezone = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Localization() {
    }

    /**
     * 
     * @param timezone
     * @param locale
     */
    public Localization(String locale, String timezone) {
        super();
        this.locale = locale;
        this.timezone = timezone;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Localization withLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Localization withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("locale", locale).append("timezone", timezone).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(timezone).append(locale).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Localization) == false) {
            return false;
        }
        Localization rhs = ((Localization) other);
        return new EqualsBuilder().append(timezone, rhs.timezone).append(locale, rhs.locale).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(locale);
        dest.writeValue(timezone);
    }

    public int describeContents() {
        return  0;
    }

}
