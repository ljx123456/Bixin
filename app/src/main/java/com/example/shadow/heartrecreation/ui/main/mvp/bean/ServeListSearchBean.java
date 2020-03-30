package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class ServeListSearchBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : [{"state":"空闲中","userId":3266,"bixinId":1379252,"nickname":"雅琪小小","sex":2,"avatar":"http://pic.bixinyule.com/Fs-41lSOFZHL21eaJGCrZnr8D3M0","km":"7.9km","charmValue":100,"isOnline":1,"isOut":1,"age":8,"occupationName":"自由职业","businessInfo":[{"businessId":24,"businessName":"咪哒","businessScore":4,"avatar":"http://store.is.autonavi.com/showpic/0d20cc690fc8408c3b51160b18a63e36"}],"skillPrice":800}]
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
         * state : 空闲中
         * userId : 3266
         * bixinId : 1379252
         * nickname : 雅琪小小
         * sex : 2
         * avatar : http://pic.bixinyule.com/Fs-41lSOFZHL21eaJGCrZnr8D3M0
         * km : 7.9km
         * charmValue : 100
         * isOnline : 1
         * isOut : 1
         * age : 8
         * occupationName : 自由职业
         * businessInfo : [{"businessId":24,"businessName":"咪哒","businessScore":4,"avatar":"http://store.is.autonavi.com/showpic/0d20cc690fc8408c3b51160b18a63e36"}]
         * skillPrice : 800
         */

        private String state;
        private int userId;
        private int bixinId;
        private String nickname;
        private int sex;
        private String avatar;
        private String km;
        private int charmValue;
        private int isOnline;
        private int isOut;
        private int age;
        private String occupationName;
        private BigDecimal skillPrice=new BigDecimal(0.00);
        private List<BusinessInfoBean> businessInfo;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getBixinId() {
            return bixinId;
        }

        public void setBixinId(int bixinId) {
            this.bixinId = bixinId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getKm() {
            return km;
        }

        public void setKm(String km) {
            this.km = km;
        }

        public int getCharmValue() {
            return charmValue;
        }

        public void setCharmValue(int charmValue) {
            this.charmValue = charmValue;
        }

        public int getIsOnline() {
            return isOnline;
        }

        public void setIsOnline(int isOnline) {
            this.isOnline = isOnline;
        }

        public int getIsOut() {
            return isOut;
        }

        public void setIsOut(int isOut) {
            this.isOut = isOut;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getOccupationName() {
            return occupationName;
        }

        public void setOccupationName(String occupationName) {
            this.occupationName = occupationName;
        }

        public BigDecimal getSkillPrice() {
            return skillPrice;
        }

        public void setSkillPrice(BigDecimal skillPrice) {
            this.skillPrice = skillPrice;
        }

        public List<BusinessInfoBean> getBusinessInfo() {
            return businessInfo;
        }

        public void setBusinessInfo(List<BusinessInfoBean> businessInfo) {
            this.businessInfo = businessInfo;
        }

        public static class BusinessInfoBean {
            /**
             * businessId : 24
             * businessName : 咪哒
             * businessScore : 4
             * avatar : http://store.is.autonavi.com/showpic/0d20cc690fc8408c3b51160b18a63e36
             */

            private int businessId;
            private String businessName;
            private int businessScore;
            private String avatar;

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
        }
    }
}
