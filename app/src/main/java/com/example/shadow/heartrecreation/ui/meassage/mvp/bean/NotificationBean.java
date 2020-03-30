package com.example.shadow.heartrecreation.ui.meassage.mvp.bean;

import java.util.List;

public class NotificationBean {

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
         * type : 0
         * orderNo : 订单号
         * createTime : 2019-02-20 18:08:05
         * serviceState : 0
         * avatar : 服务人员头像
         * nickname : 昵称
         * description : 商家确认超时
         * storageState : 0
         * businessName : 商家名称
         * verificationCode : 4096
         * businessPhone : 商家电话
         * refundType : 0
         * refundId : 52
         * refundPrice : 88.8
         * couponState : 1
         * orderState : 0
         */

        private int type;
        private String id;
        private String orderNo;
        private String createTime;
        private int serviceState;
        private String avatar;
        private String nickname;
        private String description;
        private int storageState;
        private String businessName;
        private String verificationCode;
        private String businessPhone;
        private int refundType;
        private int refundId;
        private double refundPrice;
        private int couponState;
        private int orderState;
        private String complaintsId;
        private String boxName;
        private String orderCode;
        private int isRead;
        private String reportId;
        private String feedbackId;
        private String messageId;
        private String content;
        private int messageType;

        public String getMessageId() {
            return messageId;
        }

        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getMessageType() {
            return messageType;
        }

        public void setMessageType(int messageType) {
            this.messageType = messageType;
        }

        public String getReportId() {
            return reportId;
        }

        public void setReportId(String reportId) {
            this.reportId = reportId;
        }

        public String getFeedbackId() {
            return feedbackId;
        }

        public void setFeedbackId(String feedbackId) {
            this.feedbackId = feedbackId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getIsRead() {
            return isRead;
        }

        public void setIsRead(int isRead) {
            this.isRead = isRead;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public String getBoxName() {
            return boxName;
        }

        public void setBoxName(String boxName) {
            this.boxName = boxName;
        }

        public String getComplaintsId() {
            return complaintsId;
        }

        public void setComplaintsId(String complaintsId) {
            this.complaintsId = complaintsId;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getServiceState() {
            return serviceState;
        }

        public void setServiceState(int serviceState) {
            this.serviceState = serviceState;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getStorageState() {
            return storageState;
        }

        public void setStorageState(int storageState) {
            this.storageState = storageState;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getVerificationCode() {
            return verificationCode;
        }

        public void setVerificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
        }

        public String getBusinessPhone() {
            return businessPhone;
        }

        public void setBusinessPhone(String businessPhone) {
            this.businessPhone = businessPhone;
        }

        public int getRefundType() {
            return refundType;
        }

        public void setRefundType(int refundType) {
            this.refundType = refundType;
        }

        public int getRefundId() {
            return refundId;
        }

        public void setRefundId(int refundId) {
            this.refundId = refundId;
        }

        public double getRefundPrice() {
            return refundPrice;
        }

        public void setRefundPrice(double refundPrice) {
            this.refundPrice = refundPrice;
        }

        public int getCouponState() {
            return couponState;
        }

        public void setCouponState(int couponState) {
            this.couponState = couponState;
        }

        public int getOrderState() {
            return orderState;
        }

        public void setOrderState(int orderState) {
            this.orderState = orderState;
        }
    }
}
