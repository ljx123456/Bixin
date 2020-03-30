package com.example.shadow.heartrecreation.ui.main.mvp.body;

public class ServeListSearchBody {

    private String token;
    private String name;
    private String businessId;
    private int skillTypeId;
    private int pageIndex;
    private int pageSize;

    public ServeListSearchBody(String token, String name, String businessId, int skillTypeId, int pageIndex, int pageSize) {
        this.token = token;
        this.name = name;
        this.businessId = businessId;
        this.skillTypeId = skillTypeId;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public int getSkillTypeId() {
        return skillTypeId;
    }

    public void setSkillTypeId(int skillTypeId) {
        this.skillTypeId = skillTypeId;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
