package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class CouponsBean {

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
        /**
         * businessName : 好乐星KTV(南门店)
         * couponId : 1
         * couponName : 酒水券
         * spendMoney : 5000.0
         * couponMoney : 400.0
         * state : 1
         * sendTime : 2018.09.21-2018.09.30
         * isReceived : false
         * couponType : 0
         * useObject : 0
         */

        private String businessName;
        private int couponId;
        private String couponName;
        private BigDecimal spendMoney=new BigDecimal(0.00);
        private BigDecimal couponMoney=new BigDecimal(0.00);
        private int state;
        private String sendTime;
        private boolean isReceived;
        private int couponType;
        private int useObject;

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public int getCouponId() {
            return couponId;
        }

        public void setCouponId(int couponId) {
            this.couponId = couponId;
        }

        public String getCouponName() {
            return couponName;
        }

        public void setCouponName(String couponName) {
            this.couponName = couponName;
        }

        public BigDecimal getSpendMoney() {
            return spendMoney;
        }

        public void setSpendMoney(BigDecimal spendMoney) {
            this.spendMoney = spendMoney;
        }

        public BigDecimal getCouponMoney() {
            return couponMoney;
        }

        public void setCouponMoney(BigDecimal couponMoney) {
            this.couponMoney = couponMoney;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getSendTime() {
            return sendTime;
        }

        public void setSendTime(String sendTime) {
            this.sendTime = sendTime;
        }

        public boolean isIsReceived() {
            return isReceived;
        }

        public void setIsReceived(boolean isReceived) {
            this.isReceived = isReceived;
        }

        public int getCouponType() {
            return couponType;
        }

        public void setCouponType(int couponType) {
            this.couponType = couponType;
        }

        public int getUseObject() {
            return useObject;
        }

        public void setUseObject(int useObject) {
            this.useObject = useObject;
        }
    }
}
