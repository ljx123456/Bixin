package com.example.shadow.heartrecreation.utils.http;

import java.util.List;

public class ErrorDrinks {

    /**
     * code : -3030
     * message : 有商品已下架
     * data : [{"wines":[964]}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private List<Integer> wines;

        public List<Integer> getWines() {
            return wines;
        }

        public void setWines(List<Integer> wines) {
            this.wines = wines;
        }
    }
}
