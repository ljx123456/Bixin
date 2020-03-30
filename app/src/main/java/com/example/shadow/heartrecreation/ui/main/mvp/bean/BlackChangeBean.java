package com.example.shadow.heartrecreation.ui.main.mvp.bean;

public class BlackChangeBean {

    private String token;
    private int id;

    public BlackChangeBean(String token, int id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
