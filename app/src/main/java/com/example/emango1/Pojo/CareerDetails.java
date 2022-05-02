package com.example.emango1.Pojo;

import com.google.gson.annotations.SerializedName;

public class CareerDetails {

    @SerializedName("title")
    private String title;
    @SerializedName("slug")
    private String slug;
    @SerializedName("careerImage")
    private String careerImage;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("image_url2")
    private String imageUrl2;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getCareerImage() {
        return careerImage;
    }

    public void setCareerImage(String careerImage) {
        this.careerImage = careerImage;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

}
