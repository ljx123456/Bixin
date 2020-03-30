package com.example.shadow.heartrecreation.ui.order.mvp.body;

import java.util.List;

public class AddWineBody {


    /**
     * orderNo : O201810260335521454603
     * wines : [{"wineId":"1","num":"3"}]
     * payType : 1
     * addWineType : 0
     */

    private String orderNo;
    private String payType;
    private String addWineType;
    private List<WinesBean> wines;

    public AddWineBody(String orderNo, String payType, String addWineType, List<WinesBean> wines) {
        this.orderNo = orderNo;
        this.payType = payType;
        this.addWineType = addWineType;
        this.wines = wines;
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

    public String getAddWineType() {
        return addWineType;
    }

    public void setAddWineType(String addWineType) {
        this.addWineType = addWineType;
    }

    public List<WinesBean> getWines() {
        return wines;
    }

    public void setWines(List<WinesBean> wines) {
        this.wines = wines;
    }

    public static class WinesBean {
        /**
         * wineId : 1
         * num : 3
         */

        private String wineId;
        private String num;

        public String getWineId() {
            return wineId;
        }

        public void setWineId(String wineId) {
            this.wineId = wineId;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public WinesBean(String wineId, String num) {
            this.wineId = wineId;
            this.num = num;
        }
    }
}
