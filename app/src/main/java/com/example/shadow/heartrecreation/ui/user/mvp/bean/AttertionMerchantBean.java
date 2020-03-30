package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.util.List;

public class AttertionMerchantBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : [{"businessId":25,"businessName":"星光灿烂KTV(青白江店)","businessAddress":"成都市青白江区政府中路93号明玺百货4-5F(雷迪波尔国际影城下边)","businessScore":1,"avatar":"http://e.hiphotos.baidu.com/bainuo/crop%3D0%2C21%2C690%2C418%3Bw%3D470%3Bq%3D79/sign=26abe53c64d9f2d3345e7eaf94dca621/d62a6059252dd42a756bdb76053b5bb5c8eab889.jpg","distance":"228.2km"},{"businessId":45,"businessName":"世纪怡都","businessAddress":"成都市金堂县赵镇金园街333号-343号1-4层（金堂车站对面）","businessScore":1,"avatar":"http://e.hiphotos.baidu.com/bainuo/wh%3D470%2C285/sign=3284bd5c3987e9504242fb6827087f71/f9198618367adab4ce69a9dc88d4b31c8601e4f0.jpg","distance":"220.9km"}]
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
        /**
         * businessId : 25
         * businessName : 星光灿烂KTV(青白江店)
         * businessAddress : 成都市青白江区政府中路93号明玺百货4-5F(雷迪波尔国际影城下边)
         * businessScore : 1.0
         * avatar : http://e.hiphotos.baidu.com/bainuo/crop%3D0%2C21%2C690%2C418%3Bw%3D470%3Bq%3D79/sign=26abe53c64d9f2d3345e7eaf94dca621/d62a6059252dd42a756bdb76053b5bb5c8eab889.jpg
         * distance : 228.2km
         */

        private int businessId;
        private String businessName;
        private String businessAddress;
        private double businessScore;
        private String avatar;
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

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }
    }
}
