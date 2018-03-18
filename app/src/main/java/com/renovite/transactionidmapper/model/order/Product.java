
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

public class Product implements Serializable, Parcelable
{

    @SerializedName("brands")
    @Expose
    private List<String> brands = null;
    @SerializedName("category")
    @Expose
    private List<String> category = null;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imageUrl")
    @Expose
    private ImageUrl imageUrl;
    @SerializedName("logoUrl")
    @Expose
    private LogoUrl logoUrl;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("productIdentifier")
    @Expose
    private ProductIdentifier productIdentifier;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("url")
    @Expose
    private Url url;
    public final static Creator<Product> CREATOR = new Creator<Product>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return (new Product[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6601003725228392086L;

    protected Product(Parcel in) {
        in.readList(this.brands, (String.class.getClassLoader()));
        in.readList(this.category, (String.class.getClassLoader()));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.imageUrl = ((ImageUrl) in.readValue((ImageUrl.class.getClassLoader())));
        this.logoUrl = ((LogoUrl) in.readValue((LogoUrl.class.getClassLoader())));
        this.manufacturer = ((String) in.readValue((String.class.getClassLoader())));
        this.model = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.productIdentifier = ((ProductIdentifier) in.readValue((ProductIdentifier.class.getClassLoader())));
        this.sku = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((Url) in.readValue((Url.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Product() {
    }

    /**
     * 
     * @param brands
     * @param model
     * @param category
     * @param imageUrl
     * @param productIdentifier
     * @param manufacturer
     * @param description
     * @param name
     * @param logoUrl
     * @param sku
     * @param url
     */
    public Product(List<String> brands, List<String> category, String description, ImageUrl imageUrl, LogoUrl logoUrl, String manufacturer, String model, String name, ProductIdentifier productIdentifier, String sku, Url url) {
        super();
        this.brands = brands;
        this.category = category;
        this.description = description;
        this.imageUrl = imageUrl;
        this.logoUrl = logoUrl;
        this.manufacturer = manufacturer;
        this.model = model;
        this.name = name;
        this.productIdentifier = productIdentifier;
        this.sku = sku;
        this.url = url;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public Product withBrands(List<String> brands) {
        this.brands = brands;
        return this;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public Product withCategory(List<String> category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product withDescription(String description) {
        this.description = description;
        return this;
    }

    public ImageUrl getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ImageUrl imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Product withImageUrl(ImageUrl imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public LogoUrl getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(LogoUrl logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Product withLogoUrl(LogoUrl logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Product withManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Product withModel(String model) {
        this.model = model;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product withName(String name) {
        this.name = name;
        return this;
    }

    public ProductIdentifier getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(ProductIdentifier productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public Product withProductIdentifier(ProductIdentifier productIdentifier) {
        this.productIdentifier = productIdentifier;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Product withSku(String sku) {
        this.sku = sku;
        return this;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public Product withUrl(Url url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("brands", brands).append("category", category).append("description", description).append("imageUrl", imageUrl).append("logoUrl", logoUrl).append("manufacturer", manufacturer).append("model", model).append("name", name).append("productIdentifier", productIdentifier).append("sku", sku).append("url", url).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(brands).append(model).append(category).append(imageUrl).append(productIdentifier).append(manufacturer).append(description).append(name).append(logoUrl).append(sku).append(url).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Product) == false) {
            return false;
        }
        Product rhs = ((Product) other);
        return new EqualsBuilder().append(brands, rhs.brands).append(model, rhs.model).append(category, rhs.category).append(imageUrl, rhs.imageUrl).append(productIdentifier, rhs.productIdentifier).append(manufacturer, rhs.manufacturer).append(description, rhs.description).append(name, rhs.name).append(logoUrl, rhs.logoUrl).append(sku, rhs.sku).append(url, rhs.url).isEquals();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(brands);
        dest.writeList(category);
        dest.writeValue(description);
        dest.writeValue(imageUrl);
        dest.writeValue(logoUrl);
        dest.writeValue(manufacturer);
        dest.writeValue(model);
        dest.writeValue(name);
        dest.writeValue(productIdentifier);
        dest.writeValue(sku);
        dest.writeValue(url);
    }

    public int describeContents() {
        return  0;
    }

}
