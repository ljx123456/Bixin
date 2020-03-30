package com.example.shadow.heartrecreation.ui.main.mvp.body;

public class FollowChangeBody {

    private String token;
    private String id;

    public FollowChangeBody(String token, String id) {
        this.token = token;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
