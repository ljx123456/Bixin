package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.util.List;

public class ExpireRecordBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : [{"expireTime":"2019-03-18 13:57:45","storageTime":"2019-03-01 13:58:10","wineInfo":[{"wineName":"雪花啤酒","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineUnit":"瓶","wineSpecifications":"500ML","wineNum":20},{"wineName":"拉菲","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineUnit":"支","wineSpecifications":"500ML ","wineNum":5}]}]
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
         * expireTime : 2019-03-18 13:57:45
         * storageTime : 2019-03-01 13:58:10
         * wineInfo : [{"wineName":"雪花啤酒","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineUnit":"瓶","wineSpecifications":"500ML","wineNum":20},{"wineName":"拉菲","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineUnit":"支","wineSpecifications":"500ML ","wineNum":5}]
         */

        private String expireTime;
        private String storageTime;
        private boolean isExpanded;

        public boolean isExpanded() {
            return isExpanded;
        }

        public void setExpanded(boolean expanded) {
            isExpanded = expanded;
        }

        private List<WineInfoBean> wineInfo;

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }

        public String getStorageTime() {
            return storageTime;
        }

        public void setStorageTime(String storageTime) {
            this.storageTime = storageTime;
        }

        public List<WineInfoBean> getWineInfo() {
            return wineInfo;
        }

        public void setWineInfo(List<WineInfoBean> wineInfo) {
            this.wineInfo = wineInfo;
        }

        public static class WineInfoBean {
            /**
             * wineName : 雪花啤酒
             * wineAvatar : https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg
             * wineUnit : 瓶
             * wineSpecifications : 500ML
             * wineNum : 20
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
