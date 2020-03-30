package com.example.shadow.heartrecreation.ui.user.mvp.body;

public class BusinessBody {


    /**
     * token : xZBtYkVRV03GVBsvBr3WR3qPx+JJ73xtHrt3EDWGyyEJbqRJPYhsO11jwjVnESZlP4WHhK59Ai3ej44Z9mQLpiMOEDt6MpcOxS+UKPBTEGs54iffrfhot0txab8KLwjLvXm89EhPTiH1UOrYBiJtbwhYDDnfL+HkAZB17vHSCNM=
     * businessId : 1
     */

    private String token;
    private int businessId;

    public BusinessBody(String token, int businessId) {
        this.token = token;
        this.businessId = businessId;
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
}
