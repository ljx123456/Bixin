package com.example.shadow.heartrecreation.ui.order.mvp.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderServicesBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : [{"listId":883,"serviceUserNum":10,"orderTakingNum":0,"serviceUsers":[{"orderServiceNo":"3000201903070830908474974","serviceUserId":3278,"skillTypeId":1,"age":"36","nickname":"小啊九","sex":1,"avatar":"http://pic.bixinyule.com/FpjDvMDy26M2cEV1VbiITL43-vJW","occupation":"教师","serviceStartTime":"2019-03-07 20:00:00","price":800,"serviceState":8,"rongToken":"ygU/ESgY2CD+U29EOpOmnjTGc5QD0vNbc19NRlM1oXadmTrT6kVOhu1Ai2icixBOMgQM/Wle5kmt239TmjRYhg=="},{"orderServiceNo":"3000201903070830909912728","serviceUserId":3422,"skillTypeId":1,"age":"20","nickname":"甜诱～少女喵Y","sex":1,"avatar":"http://pic1.win4000.com/pic/d/db/fea6657630_250_350.jpg","occupation":"教师","serviceStartTime":"2019-03-07 20:00:00","price":800,"serviceState":8,"rongToken":"g9T7GcSpHKz6FL8Y0XZXFJyg5jbxEw+spmsK1z3sj1oqYDNLqE5klPTW620x8IMT0UbfSwP17LNN+dQSNrgONQ=="}]}]
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

    public static class DataBean  {
        /**
         * listId : 883
         * serviceUserNum : 10
         * orderTakingNum : 0
         * serviceUsers : [{"orderServiceNo":"3000201903070830908474974","serviceUserId":3278,"skillTypeId":1,"age":"36","nickname":"小啊九","sex":1,"avatar":"http://pic.bixinyule.com/FpjDvMDy26M2cEV1VbiITL43-vJW","occupation":"教师","serviceStartTime":"2019-03-07 20:00:00","price":800,"serviceState":8,"rongToken":"ygU/ESgY2CD+U29EOpOmnjTGc5QD0vNbc19NRlM1oXadmTrT6kVOhu1Ai2icixBOMgQM/Wle5kmt239TmjRYhg=="},{"orderServiceNo":"3000201903070830909912728","serviceUserId":3422,"skillTypeId":1,"age":"20","nickname":"甜诱～少女喵Y","sex":1,"avatar":"http://pic1.win4000.com/pic/d/db/fea6657630_250_350.jpg","occupation":"教师","serviceStartTime":"2019-03-07 20:00:00","price":800,"serviceState":8,"rongToken":"g9T7GcSpHKz6FL8Y0XZXFJyg5jbxEw+spmsK1z3sj1oqYDNLqE5klPTW620x8IMT0UbfSwP17LNN+dQSNrgONQ=="}]
         */

        private int listId;
        private int serviceUserNum;
        private int orderTakingNum;
        private List<ServiceUsersBean> serviceUsers;

        public int getListId() {
            return listId;
        }

        public void setListId(int listId) {
            this.listId = listId;
        }

        public int getServiceUserNum() {
            return serviceUserNum;
        }

        public void setServiceUserNum(int serviceUserNum) {
            this.serviceUserNum = serviceUserNum;
        }

        public int getOrderTakingNum() {
            return orderTakingNum;
        }

        public void setOrderTakingNum(int orderTakingNum) {
            this.orderTakingNum = orderTakingNum;
        }

        public List<ServiceUsersBean> getServiceUsers() {
            return serviceUsers;
        }

        public void setServiceUsers(List<ServiceUsersBean> serviceUsers) {
            this.serviceUsers = serviceUsers;
        }


        public static class ServiceUsersBean {
            /**
             * orderServiceNo : 3000201903070830908474974
             * serviceUserId : 3278
             * skillTypeId : 1
             * age : 36
             * nickname : 小啊九
             * sex : 1
             * avatar : http://pic.bixinyule.com/FpjDvMDy26M2cEV1VbiITL43-vJW
             * occupation : 教师
             * serviceStartTime : 2019-03-07 20:00:00
             * price : 800.0
             * serviceState : 8
             * rongToken : ygU/ESgY2CD+U29EOpOmnjTGc5QD0vNbc19NRlM1oXadmTrT6kVOhu1Ai2icixBOMgQM/Wle5kmt239TmjRYhg==
             */

            private String orderServiceNo;
            private int serviceUserId;
            private int skillTypeId;
            private String age;
            private String nickname;
            private int sex;
            private String avatar;
            private String occupation;
            private String serviceStartTime;
            private BigDecimal price=new BigDecimal(0.00);
            private int serviceState;
            private String rongToken;
            private String description;
            private int waitPayServiceTime;

            public int getWaitPayServiceTime() {
                return waitPayServiceTime;
            }

            public void setWaitPayServiceTime(int waitPayServiceTime) {
                this.waitPayServiceTime = waitPayServiceTime;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getOrderServiceNo() {
                return orderServiceNo;
            }

            public void setOrderServiceNo(String orderServiceNo) {
                this.orderServiceNo = orderServiceNo;
            }

            public int getServiceUserId() {
                return serviceUserId;
            }

            public void setServiceUserId(int serviceUserId) {
                this.serviceUserId = serviceUserId;
            }

            public int getSkillTypeId() {
                return skillTypeId;
            }

            public void setSkillTypeId(int skillTypeId) {
                this.skillTypeId = skillTypeId;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
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

            public String getOccupation() {
                return occupation;
            }

            public void setOccupation(String occupation) {
                this.occupation = occupation;
            }

            public String getServiceStartTime() {
                return serviceStartTime;
            }

            public void setServiceStartTime(String serviceStartTime) {
                this.serviceStartTime = serviceStartTime;
            }

            public BigDecimal getPrice() {
                return price;
            }

            public void setPrice(BigDecimal price) {
                this.price = price;
            }

            public int getServiceState() {
                return serviceState;
            }

            public void setServiceState(int serviceState) {
                this.serviceState = serviceState;
            }

            public String getRongToken() {
                return rongToken;
            }

            public void setRongToken(String rongToken) {
                this.rongToken = rongToken;
            }

        }
    }
}
