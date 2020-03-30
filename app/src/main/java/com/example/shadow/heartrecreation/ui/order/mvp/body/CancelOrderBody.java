package com.example.shadow.heartrecreation.ui.order.mvp.body;

public class CancelOrderBody {

    /**
     * orderNo : 1000201901211411116725850
     */

    private String orderNo;

    public CancelOrderBody(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
