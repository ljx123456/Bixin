package com.example.shadow.heartrecreation.ui.order.mvp.body;

public class OrderListBody {


    private String token;
    private String orderState;
    private int pageIndex;
    private int pageSize;

    public OrderListBody(String token, String orderState, int pageIndex, int pageSize) {
        this.token = token;
        this.orderState = orderState;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
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
