package com.example.shadow.heartrecreation.ui.main.mvp.body;

public class MerchantDetailsBody {

    private String businessId;
    private String token;

    public MerchantDetailsBody(String businessId, String token) {
        this.businessId = businessId;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MerchantDetailsBody(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}
