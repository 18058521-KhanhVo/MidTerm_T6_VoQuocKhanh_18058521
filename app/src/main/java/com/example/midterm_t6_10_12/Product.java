package com.example.midterm_t6_10_12;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Product implements Parcelable {
    private int imgID;
    private String name, description, price;
    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public Product() {
    }

    public Product(Parcel in) {
        this.imgID = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.price = in.readString();
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(int imgID, String name, String description, String price) {
        this.imgID = imgID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return imgID == product.imgID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imgID);
    }

    @Override
    public String toString() {
        return "Product{" +
                "imgID=" + imgID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imgID);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(price);
    }
}
