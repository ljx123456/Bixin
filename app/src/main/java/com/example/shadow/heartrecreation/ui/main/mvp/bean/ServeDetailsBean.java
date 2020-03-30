package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class ServeDetailsBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"state":"空闲中","userId":3376,"nickname":"卜居森林","sex":1,"avatar":"http://pic1.win4000.com/pic/1/fb/ca747d38ee_250_350.jpg","km":"4.8km","charmValue":100,"isOnline":1,"isOut":1,"isCanInvite":1,"age":40,"occupationName":"教师","rongToken":"nbeI2PwSxQHml0/mh8wHdJyg5jbxEw+spmsK1z3sj1oqYDNLqE5klGvpRvdWfJwNTtnJOii9AnZN+dQSNrgONQ==","businessInfo":[{"businessId":30,"businessName":"星光灿烂KTV(红光店)","businessScore":1,"avatar":"http://pic1.win4000.com/pic/1/fb/ca747d38ee_250_350.jpg"}],"needTime":"48分钟","skillTypeList":{"skillTypeId":1,"skillTypeName":"欢歌纵酒","skillTypeUnit":"场","skillTypeHour":5,"skillTypePriceUp":800},"tagSet":"美丽,大方","birthdayAndConstellation":"1978-07-16(巨蟹座)","fans":10000,"focus":0,"isFans":2,"isInBlacklist":1,"videoSetList":[{"url":"http://pic1.win4000.com/pic/1/fb/dc1af35094.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/ea6a99b20d.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/570b63cf4e.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/94e5bc0598.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/5c7195a0b5.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/a12490f39b.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/ca747d38ee.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/64a21bdff7.jpg","type":2}],"evaluateTagSetList":[{"name":"可人","num":18}]}
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
         * userId : 3376
         * nickname : 卜居森林
         * sex : 1
         * avatar : http://pic1.win4000.com/pic/1/fb/ca747d38ee_250_350.jpg
         * km : 4.8km
         * charmValue : 100
         * isOnline : 1
         * isOut : 1
         * isCanInvite : 1
         * age : 40
         * occupationName : 教师
         * rongToken : nbeI2PwSxQHml0/mh8wHdJyg5jbxEw+spmsK1z3sj1oqYDNLqE5klGvpRvdWfJwNTtnJOii9AnZN+dQSNrgONQ==
         * businessInfo : [{"businessId":30,"businessName":"星光灿烂KTV(红光店)","businessScore":1,"avatar":"http://pic1.win4000.com/pic/1/fb/ca747d38ee_250_350.jpg"}]
         * needTime : 48分钟
         * skillTypeList : {"skillTypeId":1,"skillTypeName":"欢歌纵酒","skillTypeUnit":"场","skillTypeHour":5,"skillTypePriceUp":800}
         * tagSet : 美丽,大方
         * birthdayAndConstellation : 1978-07-16(巨蟹座)
         * fans : 10000
         * focus : 0
         * isFans : 2
         * isInBlacklist : 1
         * videoSetList : [{"url":"http://pic1.win4000.com/pic/1/fb/dc1af35094.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/ea6a99b20d.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/570b63cf4e.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/94e5bc0598.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/5c7195a0b5.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/a12490f39b.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/ca747d38ee.jpg","type":2},{"url":"http://pic1.win4000.com/pic/1/fb/64a21bdff7.jpg","type":2}]
         * evaluateTagSetList : [{"name":"可人","num":18}]
         */

        private String state;
        private int userId;
        private String nickname;
        private int sex;
        private String avatar;
        private String km;
        private int charmValue;
        private int isOnline;
        private int isOut;
        private int isCanInvite;
        private int age;
        private String occupationName;
        private String rongToken;
        private String needTime;
        private SkillTypeListBean skillTypeList;
        private String tagSet;
        private String birthdayAndConstellation;
        private int fans;
        private int focus;
        private int isFans;
        private int isInBlacklist;
        private int isInOrder;

        private List<BusinessInfoBean> businessInfo;
        private List<VideoSetListBean> videoSetList;
        private List<EvaluateTagSetListBean> evaluateTagSetList;


        public int getIsInOrder() {
            return isInOrder;
        }

        public void setIsInOrder(int isInOrder) {
            this.isInOrder = isInOrder;
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

        public String getRongToken() {
            return rongToken;
        }

        public void setRongToken(String rongToken) {
            this.rongToken = rongToken;
        }

        public String getNeedTime() {
            return needTime;
        }

        public void setNeedTime(String needTime) {
            this.needTime = needTime;
        }

        public SkillTypeListBean getSkillTypeList() {
            return skillTypeList;
        }

        public void setSkillTypeList(SkillTypeListBean skillTypeList) {
            this.skillTypeList = skillTypeList;
        }

        public String getTagSet() {
            return tagSet;
        }

        public void setTagSet(String tagSet) {
            this.tagSet = tagSet;
        }

        public String getBirthdayAndConstellation() {
            return birthdayAndConstellation;
        }

        public void setBirthdayAndConstellation(String birthdayAndConstellation) {
            this.birthdayAndConstellation = birthdayAndConstellation;
        }

        public int getFans() {
            return fans;
        }

        public void setFans(int fans) {
            this.fans = fans;
        }

        public int getFocus() {
            return focus;
        }

        public void setFocus(int focus) {
            this.focus = focus;
        }

        public int getIsFans() {
            return isFans;
        }

        public void setIsFans(int isFans) {
            this.isFans = isFans;
        }

        public int getIsInBlacklist() {
            return isInBlacklist;
        }

        public void setIsInBlacklist(int isInBlacklist) {
            this.isInBlacklist = isInBlacklist;
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

        public List<EvaluateTagSetListBean> getEvaluateTagSetList() {
            return evaluateTagSetList;
        }

        public void setEvaluateTagSetList(List<EvaluateTagSetListBean> evaluateTagSetList) {
            this.evaluateTagSetList = evaluateTagSetList;
        }

        public static class SkillTypeListBean {
            /**
             * skillTypeId : 1
             * skillTypeName : 欢歌纵酒
             * skillTypeUnit : 场
             * skillTypeHour : 5
             * skillTypePriceUp : 800
             */

            private int skillTypeId;
            private String skillTypeName;
            private String skillTypeUnit;
            private float skillTypeHour;
            private BigDecimal skillTypePriceUp=new BigDecimal(0.00);

            public int getSkillTypeId() {
                return skillTypeId;
            }

            public void setSkillTypeId(int skillTypeId) {
                this.skillTypeId = skillTypeId;
            }

            public String getSkillTypeName() {
                return skillTypeName;
            }

            public void setSkillTypeName(String skillTypeName) {
                this.skillTypeName = skillTypeName;
            }

            public String getSkillTypeUnit() {
                return skillTypeUnit;
            }

            public void setSkillTypeUnit(String skillTypeUnit) {
                this.skillTypeUnit = skillTypeUnit;
            }

            public float getSkillTypeHour() {
                return skillTypeHour;
            }

            public void setSkillTypeHour(int skillTypeHour) {
                this.skillTypeHour = skillTypeHour;
            }

            public BigDecimal getSkillTypePriceUp() {
                return skillTypePriceUp;
            }

            public void setSkillTypePriceUp(BigDecimal skillTypePriceUp) {
                this.skillTypePriceUp = skillTypePriceUp;
            }
        }

        public static class BusinessInfoBean {
            /**
             * businessId : 30
             * businessName : 星光灿烂KTV(红光店)
             * businessScore : 1
             * avatar : http://pic1.win4000.com/pic/1/fb/ca747d38ee_250_350.jpg
             */

            private int businessId;
            private String businessName;
            private int businessScore;
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

        public static class VideoSetListBean {
            /**
             * url : http://pic1.win4000.com/pic/1/fb/dc1af35094.jpg
             * type : 2
             */

            private String url;
            private int type;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class EvaluateTagSetListBean {
            /**
             * name : 可人
             * num : 18
             */

            private String name;
            private int num;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }
    }
}
