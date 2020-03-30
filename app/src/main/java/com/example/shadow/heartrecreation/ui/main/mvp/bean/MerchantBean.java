package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.util.List;

public class MerchantBean {

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

        private int businessId;
        private String businessName;
        private String businessAddress;
        private double businessScore;
        private String avatar;
        private int businessState;
        private String businessTypeName;
        private String businessGdp;
        private String distance;
        private String businessStartHours;
        private String businessEndHours;
        private List<String> photoList;

        public String getBusinessStartHours() {
            return businessStartHours;
        }

        public void setBusinessStartHours(String businessStartHours) {
            this.businessStartHours = businessStartHours;
        }

        public String getBusinessEndHours() {
            return businessEndHours;
        }

        public void setBusinessEndHours(String businessEndHours) {
            this.businessEndHours = businessEndHours;
        }

        public int getBusinessId() {
            return businessId;
        }

        public void setBusinessId(int businessId) {
            this.businessId = businessId;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getBusinessAddress() {
            return businessAddress;
        }

        public void setBusinessAddress(String businessAddress) {
            this.businessAddress = businessAddress;
        }

        public double getBusinessScore() {
            return businessScore;
        }

        public void setBusinessScore(double businessScore) {
            this.businessScore = businessScore;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getBusinessState() {
            return businessState;
        }

        public void setBusinessState(int businessState) {
            this.businessState = businessState;
        }

        public String getBusinessTypeName() {
            return businessTypeName;
        }

        public void setBusinessTypeName(String businessTypeName) {
            this.businessTypeName = businessTypeName;
        }

        public String getBusinessGdp() {
            return businessGdp;
        }

        public void setBusinessGdp(String businessGdp) {
            this.businessGdp = businessGdp;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public List<String> getPhotoList() {
            return photoList;
        }

        public void setPhotoList(List<String> photoList) {
            this.photoList = photoList;
        }
    }
}
