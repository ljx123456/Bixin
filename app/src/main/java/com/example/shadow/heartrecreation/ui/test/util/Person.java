package com.example.shadow.heartrecreation.ui.test.util;

import java.util.ArrayList;

public class Person {
    private int id;
    private String name;
    private int sex;
    private int age;
    private String occ;
    private String price;
    private String avatar;
    private ArrayList<String > images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOcc() {
        return occ;
    }

    public void setOcc(String occ) {
        this.occ = occ;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public Person(int id, String name, int sex, int age, String occ, String price, String avatar, ArrayList<String> images) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.occ = occ;
        this.price = price;
        this.avatar = avatar;
        this.images = images;
    }
}
