package com.example.shadow.heartrecreation.ui.user.mvp.body;

public class FeedbackAddBody {

    private String content;
    private String token;

    public FeedbackAddBody(String content, String token) {
        this.content = content;
        this.token = token;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
