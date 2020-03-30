package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class ServeListBean {


    /**
     * code : 0
     * message : 请求成功.
     * data : [{"userId":3265,"nickname":"黄小小依依","sex":2,"avatar":"http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB","charmValue":100,"isOnline":1,"isOut":0,"isCanInvite":0,"age":19,"occupationName":"健身教练","businessInfo":[{"businessId":1,"businessName":"好乐星KTV(南门店)","businessScore":3,"avatar":"http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB"},{"businessId":2,"businessName":"梦乐美纯K量贩KTV","businessScore":2,"avatar":"http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB"}],"skillPrice":800,"videoSetList":[{"url":"http://pic.bixinyule.com/lvas4jEaJUegUIHpSqGC_DHsw-Ya","type":2},{"url":"http://pic.bixinyule.com/FirulP0CzZkZtAXaXRSUIoyFByaZ","type":2}],"isInOrder":0}]
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
         * userId : 3265
         * nickname : 黄小小依依
         * sex : 2
         * avatar : http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB
         * charmValue : 100.0
         * isOnline : 1
         * isOut : 0
         * isCanInvite : 0
         * age : 19
         * occupationName : 健身教练
         * businessInfo : [{"businessId":1,"businessName":"好乐星KTV(南门店)","businessScore":3,"avatar":"http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB"},{"businessId":2,"businessName":"梦乐美纯K量贩KTV","businessScore":2,"avatar":"http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB"}]
         * skillPrice : 800.0
         * videoSetList : [{"url":"http://pic.bixinyule.com/lvas4jEaJUegUIHpSqGC_DHsw-Ya","type":2},{"url":"http://pic.bixinyule.com/FirulP0CzZkZtAXaXRSUIoyFByaZ","type":2}]
         * isInOrder : 0
         */

        private int userId;
        private String nickname;
        private int sex;
        private String avatar;
        private double charmValue;
        private int isOnline;
        private int isOut;
        private int isCanInvite;
        private int age;
        private String occupationName;
        private BigDecimal skillPrice=new BigDecimal(0.00);
        private int isInOrder;
        private String km;
        private boolean isType;
        private List<BusinessInfoBean> businessInfo;
        private List<VideoSetListBean> videoSetList;

        public boolean isType() {
            return isType;
        }

        public void setType(boolean type) {
            isType = type;
        }

        public String getKm() {
            return km;
        }

        public void setKm(String km) {
            this.km = km;
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

        public double getCharmValue() {
            return charmValue;
        }

        public void setCharmValue(double charmValue) {
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

        public int getIsCanInvite() {
            return isCanInvite;
        }

        public void setIsCanInvite(int isCanInvite) {
            this.isCanInvite = isCanInvite;
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

        public int getIsInOrder() {
            return isInOrder;
        }

        public void setIsInOrder(int isInOrder) {
            this.isInOrder = isInOrder;
        }

        public List<BusinessInfoBean> getBusinessInfo() {
            return businessInfo;
        }

        public void setBusinessInfo(List<BusinessInfoBean> businessInfo) {
            this.businessInfo = businessInfo;
        }

        public List<VideoSetListBean> getVideoSetList() {
            return videoSetList;
        }

        public void setVideoSetList(List<VideoSetListBean> videoSetList) {
            this.videoSetList = videoSetList;
        }

        public static class BusinessInfoBean {
            /**
             * businessId : 1
             * businessName : 好乐星KTV(南门店)
             * businessScore : 3.0
             * avatar : http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB
             */

            private int businessId;
            private String businessName;
            private double businessScore;
            private String avatar;
            private boolean isCheck;

            public boolean isCheck() {
                return isCheck;
            }

            public void setCheck(boolean check) {
                isCheck = check;
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
        }

        public static class VideoSetListBean {
            /**
             * url : http://pic.bixinyule.com/lvas4jEaJUegUIHpSqGC_DHsw-Ya
             * type : 2.0
             */

            private String url;
            private double type;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public double getType() {
                return type;
            }

            public void setType(double type) {
                this.type = type;
            }
        }
    }
}
