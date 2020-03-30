package com.example.shadow.heartrecreation.ui.main.mvp.body;

public class UserFindBody {

    private String type;
    private String token;
    private double useCondition;

    public UserFindBody(String type, String token, double useCondition) {
        this.type = type;
        this.token = token;
        this.useCondition = useCondition;
    }

    public double getUseCondition() {
        return useCondition;
    }

    public void setUseCondition(double useCondition) {
        this.useCondition = useCondition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
