package com.example.shadow.heartrecreation.ui.user.mvp.body;

public class ExpireRecordBody {

    private String token;
    private int businessId;
    private int pageSize;
    private int pageIndex;

    public ExpireRecordBody(String token, int businessId, int pageSize, int pageIndex) {
        this.token = token;
        this.businessId = businessId;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
