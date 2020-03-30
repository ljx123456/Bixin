package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class UserFindBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : [{"userCouponId":1,"couponName":"低消抵扣卷","couponMoney":200,"skillName":"欢歌纵酒","sendTime":"2018.09.21-2018.09.30","couponType":0,"couponDescribe":"仅抵扣低消范围的酒水金额","state":1},{"userCouponId":2,"couponName":"酒水卷","couponMoney":200,"skillName":"欢歌纵酒","sendTime":"2018.09.21-2018.10.01","couponType":1,"couponDescribe":"酒水费用直接抵扣"},{"userCouponId":3,"couponName":"酒水卷","couponMoney":300,"skillName":"欢歌纵酒","sendTime":"2018.09.21-2018.09.30","couponType":1,"couponDescribe":"酒水费用直接抵扣"},{"userCouponId":8,"couponName":"达人卷","couponMoney":200,"skillName":"欢歌纵酒","sendTime":"2018.09.21-2018.09.30","couponType":2,"couponDescribe":"达人费用直接抵扣"},{"userCouponId":9,"couponName":"达人卷","couponMoney":400,"skillName":"欢歌纵酒","sendTime":"2018.09.21-2018.09.30","couponType":2,"couponDescribe":"达人费用直接抵扣"}]
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
         * userCouponId : 1
         * couponName : 低消抵扣卷
         * couponMoney : 200
         * skillName : 欢歌纵酒
         * sendTime : 2018.09.21-2018.09.30
         * couponType : 0
         * couponDescribe : 仅抵扣低消范围的酒水金额
         * state : 1
         */

        private int userCouponId;
        private String couponName;
        private BigDecimal couponMoney=new BigDecimal(0.00);
        private String skillName;
        private String sendTime;
        private int couponType;
        private String couponDescribe;
        private int state;
        private double useCondition;
        private boolean chick=false;


        public boolean isChick() {
            return chick;
        }

        public void setChick(boolean chick) {
            this.chick = chick;
        }

        public int getUserCouponId() {
            return userCouponId;
        }

        public void setUserCouponId(int userCouponId) {
            this.userCouponId = userCouponId;
        }

        public String getCouponName() {
            return couponName;
        }

        public void setCouponName(String couponName) {
            this.couponName = couponName;
        }

        public BigDecimal getCouponMoney() {
            return couponMoney;
        }

        public void setCouponMoney(BigDecimal couponMoney) {
            this.couponMoney = couponMoney;
        }

        public String getSkillName() {
            return skillName;
        }

        public void setSkillName(String skillName) {
            this.skillName = skillName;
        }

        public String getSendTime() {
            return sendTime;
        }

        public void setSendTime(String sendTime) {
            this.sendTime = sendTime;
        }

        public int getCouponType() {
            return couponType;
        }

        public void setCouponType(int couponType) {
            this.couponType = couponType;
        }

        public String getCouponDescribe() {
            return couponDescribe;
        }

        public void setCouponDescribe(String couponDescribe) {
            this.couponDescribe = couponDescribe;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public double getUseCondition() {
            return useCondition;
        }

        public void setUseCondition(double useCondition) {
            this.useCondition = useCondition;
        }
    }
}
