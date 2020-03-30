package com.example.shadow.heartrecreation.ui.order.mvp.body;

public class PayAgainBody {

    /**
     * orderNo : O201810260335521454603
     * payType : 1
     */

    private String orderNo;
    private String payType;

    public PayAgainBody(String orderNo, String payType) {
        this.orderNo = orderNo;
        this.payType = payType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
