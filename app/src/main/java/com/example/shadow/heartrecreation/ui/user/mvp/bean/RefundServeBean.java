package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.math.BigDecimal;

public class RefundServeBean {

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
        /**
         * refundId : 1
         * orderNo : O201810260335521454603
         * createUserId : 1
         * refundType : 1
         * refundState : 2
         * orderServiceNo : O201810260335521454603
         * refundPrice : 998
         * payPrice : 2500
         * startTime : 2018-11-15 20:15:35
         * handleTime : 2018-11-15 20:15:37
         * endTime : 2018-11-15 20:15:41
         * rongToken : siXDhorPgMrJCD5CSSt4Spyg5jbxEw+spmsK1z3sj1oqYDNLqE5klG3DOXx0vTrKZoUe+l0HosxN+dQSNrgONQ==
         * occupation : 律师
         * serviceName : 张三
         * age : 18
         * sex : 2
         * orderStartTime : 2018-11-15 20:15:35
         * avatar : http://pic.bixinyule.com/Fs-41lSOFZHL21eaJGCrZnr8D3M0
         * businessName : 丰巢KTV
         * boxTypeName : 豪华包房
         * boxName : a007
         */

        private int refundId;
        private String orderNo;
        private int createUserId;
        private int refundType;
        private int refundState;
        private String orderServiceNo;
        private BigDecimal refundPrice=new BigDecimal(0.00);
        private BigDecimal payPrice=new BigDecimal(0.00);
        private String startTime;
        private String handleTime;
        private String endTime;
        private String rongToken;
        private String occupation;
        private String serviceName;
        private int age;
        private int sex;
        private String orderStartTime;
        private String avatar;
        private String businessName;
        private String boxTypeName;
        private String boxName;
        private String platformPhone;
        private BigDecimal serviceCouponPrice=new BigDecimal(0.00);
        private String createTime;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public BigDecimal getServiceCouponPrice() {
            return serviceCouponPrice;
        }

        public void setServiceCouponPrice(BigDecimal serviceCouponPrice) {
            this.serviceCouponPrice = serviceCouponPrice;
        }

        public String getPlatformPhone() {
            return platformPhone;
        }

        public void setPlatformPhone(String platformPhone) {
            this.platformPhone = platformPhone;
        }

        public int getRefundId() {
            return refundId;
        }

        public void setRefundId(int refundId) {
            this.refundId = refundId;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public int getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(int createUserId) {
            this.createUserId = createUserId;
        }

        public int getRefundType() {
            return refundType;
        }

        public void setRefundType(int refundType) {
            this.refundType = refundType;
        }

        public int getRefundState() {
            return refundState;
        }

        public void setRefundState(int refundState) {
            this.refundState = refundState;
        }

        public String getOrderServiceNo() {
            return orderServiceNo;
        }

        public void setOrderServiceNo(String orderServiceNo) {
            this.orderServiceNo = orderServiceNo;
        }

        public BigDecimal getRefundPrice() {
            return refundPrice;
        }

        public void setRefundPrice(BigDecimal refundPrice) {
            this.refundPrice = refundPrice;
        }

        public BigDecimal getPayPrice() {
            return payPrice;
        }

        public void setPayPrice(BigDecimal payPrice) {
            this.payPrice = payPrice;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getHandleTime() {
            return handleTime;
        }

        public void setHandleTime(String handleTime) {
            this.handleTime = handleTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getRongToken() {
            return rongToken;
        }

        public void setRongToken(String rongToken) {
            this.rongToken = rongToken;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getOrderStartTime() {
            return orderStartTime;
        }

        public void setOrderStartTime(String orderStartTime) {
            this.orderStartTime = orderStartTime;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getBoxTypeName() {
            return boxTypeName;
        }

        public void setBoxTypeName(String boxTypeName) {
            this.boxTypeName = boxTypeName;
        }

        public String getBoxName() {
            return boxName;
        }

        public void setBoxName(String boxName) {
            this.boxName = boxName;
        }
    }
}
