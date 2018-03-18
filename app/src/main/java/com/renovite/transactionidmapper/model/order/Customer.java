
package com.renovite.transactionidmapper.model.order;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Customer implements Serializable, Parcelable
{

    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("middleName")
    @Expose
    private String middleName;
    @SerializedName("phoneNumbers")
    @Expose
    private List<String> phoneNumbers = null;
    @SerializedName("taxIdentificationNumber")
    @Expose
    private String taxIdentificationNumber;
    @SerializedName("title")
    @Expose
    private String title;
    public final static Creator<Customer> CREATOR = new Creator<Customer>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        public Customer[] newArray(int size) {
            return (new Customer[size]);
        }

    }
    ;
    private final static long serialVersionUID = -7878642115914190439L;

    protected Customer(Parcel in) {
        this.address = ((Address) in.readValue((Address.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.middleName = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.phoneNumbers, (String.class.getClassLoader()));
        this.taxIdentificationNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Customer() {
    }

    /**
     * 
     * @param middleName
     * @param lastName
     * @param title
     * @param taxIdentificationNumber
     * @param email
     * @param address
     * @param gender
     * @param phoneNumbers
     * @param firstName
     */
    public Customer(Address address, String email, String firstName, String gender, String lastName, String middleName, List<String> phoneNumbers, String taxIdentificationNumber, String title) {
        super();
        this.address = address;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumbers = phoneNumbers;
        this.taxIdentificationNumber = taxIdentificationNumber;
        this.title = title;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer withAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Customer withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Customer withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Customer withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Customer withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Customer withPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public Customer withTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Customer withTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("address", address).append("email", email).append("firstName", firstName).append("gender", gender).append("lastName", lastName).append("middleName", middleName).append("phoneNumbers", phoneNumbers).append("taxIdentificationNumber", taxIdentificationNumber).append("title", title).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(middleName).append(lastName).append(title).append(taxIdentificationNumber).append(email).append(address).append(gender).append(phoneNumbers).append(firstName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Customer) == false) {
            return false;
        }
        Customer rhs = ((Customer) other);
        return new EqualsBuilder().append(middleName, rhs.middleName).append(lastName, rhs.lastName).append(title, rhs.title).append(taxIdentificationNumber, rhs.taxIdentificationNumber).append(email, rhs.email).append(address, rhs.address).append(gender, rhs.gender).append(phoneNumbers, rhs.phoneNumbers).append(firstName, rhs.firstName).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(address);
        dest.writeValue(email);
        dest.writeValue(firstName);
        dest.writeValue(gender);
        dest.writeValue(lastName);
        dest.writeValue(middleName);
        dest.writeList(phoneNumbers);
        dest.writeValue(taxIdentificationNumber);
        dest.writeValue(title);
    }

    public int describeContents() {
        return  0;
    }

}
