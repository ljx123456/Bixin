package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class RefundBean {

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
         * refundId : 1
         * orderNo : O201810260335521454603
         * refundType : 0
         * refundState : 2
         * refundPrice : 998
         * payPrice : 2500
         * businessName : 好乐星KTV(南门店)
         * avatar : http://e.hiphotos.baidu.com/bainuo/crop%3D0%2C0%2C470%2C285%3Bw%3D470%3Bq%3D79/sign=6d9c0c35def9d72a032b4a5de91a0404/50da81cb39dbb6fd25b68d2c0e24ab18962b37ce.jpg
         * rongToken : siXDhorPgMrJCD5CSSt4Spyg5jbxEw+spmsK1z3sj1oqYDNLqE5klG3DOXx0vTrKZoUe+l0HosxN+dQSNrgONQ==
         * serviceName : ┆任δ乎吸野мαη┆
         * age : 10
         * sex : 2
         * occupation : 律师
         */

        private int refundId;
        private String orderNo;
        private int refundType;
        private int refundState;
        private BigDecimal refundPrice=new BigDecimal(0.00);
        private BigDecimal payPrice=new BigDecimal(0.00);
        private String businessName;
        private String avatar;
        private String rongToken;
        private String serviceName;
        private int age;
        private int sex;
        private String occupation;
        private String businessPhone;
        private String platformPhone;

        public String getPlatformPhone() {
            return platformPhone;
        }

        public void setPlatformPhone(String platformPhone) {
            this.platformPhone = platformPhone;
        }

        public String getBusinessPhone() {
            return businessPhone;
        }

        public void setBusinessPhone(String businessPhone) {
            this.businessPhone = businessPhone;
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

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getRongToken() {
            return rongToken;
        }

        public void setRongToken(String rongToken) {
            this.rongToken = rongToken;
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

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }
    }
}
