package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class AttertionServeBean {

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
         * userId : 3288
         * nickname : 矫情吗；*
         * sex : 1
         * avatar : http://pic1.win4000.com/pic/d/b4/43a100eedc_250_350.jpg
         * km : 11.4km
         * charmValue : 60
         * isOnline : 1
         * isOut : 0
         * isCanInvite : 0
         * age : 35
         * occupationName : 教师
         * businessId : 3
         * businessName : 佳乐迪纯k(彭州店)
         * skillTypeList : {"skillTypeId":1,"skillTypeName":"欢歌纵酒","skillTypeUnit":"场","skillTypeHour":5,"skillTypePriceUp":800}
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
        private int businessId;
        private String businessName;
        private SkillTypeListBean skillTypeList;

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

        public SkillTypeListBean getSkillTypeList() {
            return skillTypeList;
        }

        public void setSkillTypeList(SkillTypeListBean skillTypeList) {
            this.skillTypeList = skillTypeList;
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
            private int skillTypeHour;
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

            public int getSkillTypeHour() {
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
    }
}
