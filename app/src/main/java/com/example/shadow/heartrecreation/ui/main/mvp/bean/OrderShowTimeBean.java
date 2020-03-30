package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.util.List;

public class OrderShowTimeBean {

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<String> orderTime;

        public List<String> getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(List<String> orderTime) {
            this.orderTime = orderTime;
        }
    }
}
