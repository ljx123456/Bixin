package com.example.shadow.heartrecreation.ui.order.mvp.body;

public class PayServiceAgainBody {

    /**
     * orderServiceNo : S201810260335521454603
     * payType : 1
     */

    private String orderServiceNo;
    private String payType;

    public String getOrderServiceNo() {
        return orderServiceNo;
    }

    public void setOrderServiceNo(String orderServiceNo) {
        this.orderServiceNo = orderServiceNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public PayServiceAgainBody(String orderServiceNo, String payType) {
        this.orderServiceNo = orderServiceNo;
        this.payType = payType;
    }
}
