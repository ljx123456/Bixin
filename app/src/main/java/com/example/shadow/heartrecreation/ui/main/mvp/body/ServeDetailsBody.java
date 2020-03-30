package com.example.shadow.heartrecreation.ui.main.mvp.body;

public class ServeDetailsBody {

    private String token;
    private int serviceUserId;
    private String businessId;
    private int skillTypeId;

    public ServeDetailsBody(String token, int serviceUserId, String businessId, int skillTypeId) {
        this.token = token;
        this.serviceUserId = serviceUserId;
        this.businessId = businessId;
        this.skillTypeId = skillTypeId;
    }

    public int getSkillTypeId() {
        return skillTypeId;
    }

    public void setSkillTypeId(int skillTypeId) {
        this.skillTypeId = skillTypeId;
    }

    public ServeDetailsBody(String token, int serviceUserId, String businessId) {
        this.token = token;
        this.serviceUserId = serviceUserId;
        this.businessId = businessId;
    }

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

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}
