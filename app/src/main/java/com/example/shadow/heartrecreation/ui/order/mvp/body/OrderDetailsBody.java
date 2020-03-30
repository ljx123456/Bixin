package com.example.shadow.heartrecreation.ui.order.mvp.body;

public class OrderDetailsBody {

    /**
     * token : 42VbLl2tlRBxTnBAcnzZPZMxzF1j4weMwCGAdxB0FLwJbqRJPYhsO7/VJfA1JPhhbenE+D5EaIJaQ+A/pPia9KtgbBMIN5SVQ7b9+H0YOw65z36H+mTcz1x0752cRnVUD1xqiMI76kaBsctpx+jsDxiadLbNFhqf
     * orderNo : O201810260335521454603
     */

    private String token;
    private String orderNo;

    public OrderDetailsBody(String token, String orderNo) {
        this.token = token;
        this.orderNo = orderNo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
