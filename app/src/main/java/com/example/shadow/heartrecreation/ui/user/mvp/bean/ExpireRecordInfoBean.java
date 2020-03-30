package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.util.List;

public class ExpireRecordInfoBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"wineInfo":[{"wineName":"拉菲","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineUnit":"支","wineSpecifications":"500ML ","wineNum":5},{"wineName":"雪花啤酒","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineUnit":"瓶","wineSpecifications":"500ML","wineNum":20}],"businessInfo":{"businessId":1,"businessName":"好乐星KTV(南门店)","businessAddress":"成都市武侯区人民南路四段53号附1号(近肿瘤医院)","longitude":"104.058566","latitude":"30.701084"},"storageTime":"2019-03-01 13:58:10","expireTime":"2019-03-18 13:57:45"}
     */

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
         * wineInfo : [{"wineName":"拉菲","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineUnit":"支","wineSpecifications":"500ML ","wineNum":5},{"wineName":"雪花啤酒","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineUnit":"瓶","wineSpecifications":"500ML","wineNum":20}]
         * businessInfo : {"businessId":1,"businessName":"好乐星KTV(南门店)","businessAddress":"成都市武侯区人民南路四段53号附1号(近肿瘤医院)","longitude":"104.058566","latitude":"30.701084"}
         * storageTime : 2019-03-01 13:58:10
         * expireTime : 2019-03-18 13:57:45
         */

        private BusinessInfoBean businessInfo;
        private String storageTime;
        private String expireTime;
        private List<WineInfoBean> wineInfo;

        public BusinessInfoBean getBusinessInfo() {
            return businessInfo;
        }

        public void setBusinessInfo(BusinessInfoBean businessInfo) {
            this.businessInfo = businessInfo;
        }

        public String getStorageTime() {
            return storageTime;
        }

        public void setStorageTime(String storageTime) {
            this.storageTime = storageTime;
        }

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }

        public List<WineInfoBean> getWineInfo() {
            return wineInfo;
        }

        public void setWineInfo(List<WineInfoBean> wineInfo) {
            this.wineInfo = wineInfo;
        }

        public static class BusinessInfoBean {
            /**
             * businessId : 1
             * businessName : 好乐星KTV(南门店)
             * businessAddress : 成都市武侯区人民南路四段53号附1号(近肿瘤医院)
             * longitude : 104.058566
             * latitude : 30.701084
             */

            private int businessId;
            private String businessName;
            private String businessAddress;
            private String longitude;
            private String latitude;
            private String avatar;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
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

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }
        }

        public static class WineInfoBean {
            /**
             * wineName : 拉菲
             * wineAvatar : https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg
             * wineUnit : 支
             * wineSpecifications : 500ML
             * wineNum : 5
             */

            private String wineName;
            private String wineAvatar;
            private String wineUnit;
            private String wineSpecifications;
            private int wineNum;

            public String getWineName() {
                return wineName;
            }

            public void setWineName(String wineName) {
                this.wineName = wineName;
            }

            public String getWineAvatar() {
                return wineAvatar;
            }

            public void setWineAvatar(String wineAvatar) {
                this.wineAvatar = wineAvatar;
            }

            public String getWineUnit() {
                return wineUnit;
            }

            public void setWineUnit(String wineUnit) {
                this.wineUnit = wineUnit;
            }

            public String getWineSpecifications() {
                return wineSpecifications;
            }

            public void setWineSpecifications(String wineSpecifications) {
                this.wineSpecifications = wineSpecifications;
            }

            public int getWineNum() {
                return wineNum;
            }

            public void setWineNum(int wineNum) {
                this.wineNum = wineNum;
            }
        }
    }
}
