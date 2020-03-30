package com.example.shadow.heartrecreation.ui.order.mvp.body;

public class PayServiceBody {

    /**
     * orderServiceNo : S201810260335521454603
     * userCouponId : 4
     * payType : 1
     */

    private String orderServiceNo;
    private String userCouponId;
    private String payType;

    public PayServiceBody(String orderServiceNo, String userCouponId, String payType) {
        this.orderServiceNo = orderServiceNo;
        this.userCouponId = userCouponId;
        this.payType = payType;
    }

    public String getOrderServiceNo() {
        return orderServiceNo;
    }

    public void setOrderServiceNo(String orderServiceNo) {
        this.orderServiceNo = orderServiceNo;
    }

    public String getUserCouponId() {
        return userCouponId;
    }

    public void setUserCouponId(String userCouponId) {
        this.userCouponId = userCouponId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
