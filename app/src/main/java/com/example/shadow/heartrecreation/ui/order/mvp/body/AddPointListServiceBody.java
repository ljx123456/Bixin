package com.example.shadow.heartrecreation.ui.order.mvp.body;

public class AddPointListServiceBody {

    private String serviceUserId;
    private String orderNo;

    public AddPointListServiceBody(String serviceUserId, String orderNo) {
        this.serviceUserId = serviceUserId;
        this.orderNo = orderNo;
    }

    public String getServiceUserId() {
        return serviceUserId;
    }

    public void setServiceUserId(String serviceUserId) {
        this.serviceUserId = serviceUserId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
