package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.util.List;

public class BrokerBean {


     /**
     * code : 0
     * message : 请求成功.
     * data : {"state":"空闲中","userId":3265,"nickname":"黄小小依依","sex":2,"avatar":"http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB","km":"小于100m","charmValue":85,"age":19,"occupationName":"模特","businessInfo":[{"businessId":1,"businessName":"好乐星KTV(南门店)"}]}
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
         * state : 空闲中
         * userId : 3265
         * nickname : 黄小小依依
         * sex : 2
         * avatar : http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB
         * km : 小于100m
         * charmValue : 85.0
         * age : 19
         * occupationName : 模特
         * businessInfo : [{"businessId":1,"businessName":"好乐星KTV(南门店)"}]
         */

        private String state;
        private int userId;
        private String nickname;
        private int sex;
        private String avatar;
        private String km;
        private double charmValue;
        private int age;
        private String occupationName;
        private String bixinId;
        private List<BusinessInfoBean> businessInfo;

        public String getBixinId() {
            return bixinId;
        }

        public void setBixinId(String bixinId) {
            this.bixinId = bixinId;
        }

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

        public double getCharmValue() {
            return charmValue;
        }

        public void setCharmValue(double charmValue) {
            this.charmValue = charmValue;
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

        public List<BusinessInfoBean> getBusinessInfo() {
            return businessInfo;
        }

        public void setBusinessInfo(List<BusinessInfoBean> businessInfo) {
            this.businessInfo = businessInfo;
        }

        public static class BusinessInfoBean {
            /**
             * "businessId": 20,
             * "businessName": "快乐星量贩KTV(双桥路)",
             * "businessScore": 2,
             * "avatar": "http://store.is.autonavi.com/showpic/karaoke"
             */


            private int businessId;
            private String businessName;
            private String avatar;
            private int businessScore;
            private boolean check;

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

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getBusinessScore() {
                return businessScore;
            }

            public void setBusinessScore(int businessScore) {
                this.businessScore = businessScore;
            }

            public boolean isCheck() {
                return check;
            }

            public void setCheck(boolean check) {
                this.check = check;
            }
        }
    }
}
