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
//    private List<Member> memberList;

    //建立餐廳清單(測試用)
//    private List<Member> getMemberList() {
//        memberList = new ArrayList<>();
//        memberList.add(new Member("Lady M", R.drawable.s1, "15km", R.drawable.m1, "台北市大安區光復南路240巷26號", 5, "Desserts", "Munchies"));
//        memberList.add(new Member("吉星", R.drawable.s2, "12km", R.drawable.m2, "台北市南京東路一段92號2樓", 3, "Chinese", "Lunch"));
//        memberList.add(new Member("教父牛排", R.drawable.s3, "16km", R.drawable.m3, "台北市中山區樂群三路58號", 5, "American", "Dinner"));
//        memberList.add(new Member("大腕燒烤", R.drawable.s4, "14.2km", R.drawable.m4, "台北市大安區敦化南路一段177巷22號", 4, "American", "Dinner"));
//        memberList.add(new Member("鮨野村", R.drawable.s5, "16.6km", R.drawable.m5, "台北市大安區仁愛路四段300巷19弄4號", 4, "Japanese", "Dinner"));
//        memberList.add(new Member("RAW", R.drawable.s6, "10.6km", R.drawable.m6, "台北市中山區樂群三路301號", 5, "French", "Dinner"));
//        memberList.add(new Member("My灶", R.drawable.s7, "12.3km", R.drawable.m7, "台北市中山區松江路100巷9-1號", 3, "Chinese", "Lunch"));
//        memberList.add(new Member("阜杭豆漿", R.drawable.s8, "12.6km", R.drawable.m8, "台北市中正區忠孝東路一段108號", 1, "Chinese", "Breakfast"));
//        memberList.add(new Member("雙連圓仔湯", R.drawable.s9, "10.4km", R.drawable.m9, "台北市大同區民生西路136號", 1, "Desserts", "Munchies"));
//        memberList.add(new Member("思慕昔", R.drawable.s10, "13.1km", R.drawable.m10, "台北市大安區永康街15號", 2, "Desserts", "Munchies"));
//
//        return memberList;
//    }

    public Member() {
    }

    public Member(String name, int image1, String address) {
        this.name = name;
        this.image1 = image1;
        this.address = address;
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
