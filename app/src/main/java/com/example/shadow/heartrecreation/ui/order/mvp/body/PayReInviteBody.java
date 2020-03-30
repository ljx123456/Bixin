package com.example.shadow.heartrecreation.ui.order.mvp.body;

public class PayReInviteBody {


    private String orderServiceNo;
    private String serviecUserId;

    public PayReInviteBody(String orderServiceNo, String serviecUserId) {
        this.orderServiceNo = orderServiceNo;
        this.serviecUserId = serviecUserId;
    }

    public String getOrderServiceNo() {
        return orderServiceNo;
    }

    public void setOrderServiceNo(String orderServiceNo) {
        this.orderServiceNo = orderServiceNo;
    }

    public String getServiecUserId() {
        return serviecUserId;
    }

    public void setServiecUserId(String serviecUserId) {
        this.serviecUserId = serviecUserId;
    }
}
