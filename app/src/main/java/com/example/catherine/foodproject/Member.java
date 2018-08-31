package com.example.catherine.foodproject;

import android.app.Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Member extends Application implements Serializable {
    private String name;
    private int image;
    private String distance;
    private int image1;
    private String address;
    private double priceEvaluation;//RatingBar數量
    private String cuisineType;
    private String foodType;


    public Member() {
    }

    public Member(String name, int Image, String distance, int image1, String address, double priceEvaluation, String cuisineType, String foodType){
        super();
        this.name = name;
        this.image = Image;
        this.image1 = image1;
        this.distance = distance;
        this.address = address;
        this.priceEvaluation = priceEvaluation;
        this.cuisineType = cuisineType;
        this.foodType = foodType;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        image = image;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPriceEvaluation() {
        return priceEvaluation;
    }

    public void setPriceEvaluation(double priceEvaluation) {
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


}
