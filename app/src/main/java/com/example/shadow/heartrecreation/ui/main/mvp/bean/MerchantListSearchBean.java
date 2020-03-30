package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.util.List;

public class MerchantListSearchBean {

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
         * businessId : 4
         * businessName : 糖潮量贩式KTV(金牛万达店)
         * businessAddress : 成都市金牛区一环路北三段1号万达广场3楼（原大歌星KTV）
         * businessScore : 4
         * avatar : http://e.hiphotos.baidu.com/bainuo/crop%3D1%2C0%2C689%2C418%3Bw%3D469%3Bq%3D80/sign=98b0cca5ab6eddc432a8eebb04ea9acd/d1a20cf431adcbefe04d9c46aaaf2edda3cc9f71.jpg
         * businessState : 1
         * distance : 199.4km
         */

        private int businessId;
        private String businessName;
        private String businessAddress;
        private int businessScore;
        private String avatar;
        private int businessState;
        private String distance;

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

        public int getBusinessScore() {
            return businessScore;
        }

        public void setBusinessScore(int businessScore) {
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

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }
    }
}
