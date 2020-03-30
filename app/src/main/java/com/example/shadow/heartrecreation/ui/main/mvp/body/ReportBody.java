package com.example.shadow.heartrecreation.ui.main.mvp.body;

public class ReportBody {

    /**
     * token : {{token}}
     * serviceUserId : 3266
     * content : 我晕
     */

    private String token;
    private int serviceUserId;
    private String content;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getServiceUserId() {
        return serviceUserId;
    }

    public void setServiceUserId(int serviceUserId) {
        this.serviceUserId = serviceUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ReportBody(String token, int serviceUserId, String content) {
        this.token = token;
        this.serviceUserId = serviceUserId;
        this.content = content;
    }
}
