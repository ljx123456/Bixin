package com.example.shadow.heartrecreation.ui.order.mvp.bean;

import android.util.Log;

import java.math.BigDecimal;
import java.util.List;

public class OrderListBean {

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
         * orderState : 0
         * orderNo : O201811161650801966046
         * address : 成都市武侯区人民南路四段53号附1号(近肿瘤医院)
         * boxName : A888
         * boxTypeName : 大包
         * orderTime : 1993-08-21 00:00:00
         * startTime : 1993-08-21 00:00:00
         * endTime : 1993-08-21 01:00:00
         * orderCountPrice : 13240
         * description : 暂无包间
         */

        private String orderState;
        private String orderNo;
        private String address;
        private String boxName;
        private String boxTypeName;
        private String orderTime;
        private String startTime;
        private String endTime;
        private String businessPhone;
        private BigDecimal orderCountPrice=new BigDecimal(0.00);
        private String description;
        private Long waitPaymentTime;
        private String businessName;
        private String platformPhone;
        private String createTime;
        private String reserveTime;

        public String getReserveTime() {
            return reserveTime;
        }

        public void setReserveTime(String reserveTime) {
            this.reserveTime = reserveTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getPlatformPhone() {
            return platformPhone;
        }

        public void setPlatformPhone(String platformPhone) {
            this.platformPhone = platformPhone;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getBusinessPhone() {
            return businessPhone;
        }

        public void setBusinessPhone(String businessPhone) {
            this.businessPhone = businessPhone;
        }

        public Long getWaitPaymentTime() {
            return waitPaymentTime;
        }

        public void setWaitPaymentTime(Long waitPaymentTime) {
            this.waitPaymentTime = waitPaymentTime;
        }

        public String getOrderState() {
            return orderState;
        }

        public void setOrderState(String orderState) {
            this.orderState = orderState;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBoxName() {
            return boxName;
        }

        public void setBoxName(String boxName) {
            this.boxName = boxName;
        }

        public String getBoxTypeName() {
            return boxTypeName;
        }

        public void setBoxTypeName(String boxTypeName) {
            this.boxTypeName = boxTypeName;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public BigDecimal getOrderCountPrice() {
            return orderCountPrice;
        }

        public void setOrderCountPrice(BigDecimal orderCountPrice) {
            this.orderCountPrice = orderCountPrice;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
