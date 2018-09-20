package com.example.catherine.foodproject;

import android.app.Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Member implements Serializable {
    private String name;
    private String image;
    private int distance;
    private String image1;
    private String address;
    private float priceEvaluation;//RatingBar數量
    private String cuisineType;
    private String foodType;
    private int id;


    public Member() {
    }

    public Member(String name, String image, int distance, String image1, String address, float priceEvaluation, String cuisineType, String foodType, int id) {
        this.name = name;
        this.image = image;
        this.distance = distance;
        this.image1 = image1;
        this.address = address;
        this.priceEvaluation = priceEvaluation;
        this.cuisineType = cuisineType;
        this.foodType = foodType;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getPriceEvaluation() {
        return priceEvaluation;
    }

    public void setPriceEvaluation(float priceEvaluation) {
        this.priceEvaluation = priceEvaluation;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Override equals 與 hashCode 方法，比較依據為Member中的id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        return id == member.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
