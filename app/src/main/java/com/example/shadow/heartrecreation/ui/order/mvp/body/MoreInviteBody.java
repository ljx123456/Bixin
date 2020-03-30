package com.example.shadow.heartrecreation.ui.order.mvp.body;

import java.util.List;

public class MoreInviteBody {

    private String orderNo;
    private String serviceUserNum;
    private List<ServiceUsersBean> serviceUsers;

    public MoreInviteBody(String orderNo, String serviceUserNum, List<ServiceUsersBean> serviceUsers) {
        this.orderNo = orderNo;
        this.serviceUserNum = serviceUserNum;
        this.serviceUsers = serviceUsers;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getServiceUserNum() {
        return serviceUserNum;
    }

    public void setServiceUserNum(String serviceUserNum) {
        this.serviceUserNum = serviceUserNum;
    }

    public List<ServiceUsersBean> getServiceUsers() {
        return serviceUsers;
    }

    public void setServiceUsers(List<ServiceUsersBean> serviceUsers) {
        this.serviceUsers = serviceUsers;
    }

    public static class ServiceUsersBean {
        /**
         * serviceUserId : 3272
         * skillNum : 1
         */

        private String serviceUserId;
        private String skillNum;

        public ServiceUsersBean(String serviceUserId, String skillNum) {
            this.serviceUserId = serviceUserId;
            this.skillNum = skillNum;
        }

        public String getServiceUserId() {
            return serviceUserId;
        }

        public void setServiceUserId(String serviceUserId) {
            this.serviceUserId = serviceUserId;
        }

        public String getSkillNum() {
            return skillNum;
        }

        public void setSkillNum(String skillNum) {
            this.skillNum = skillNum;
        }
    }
}
