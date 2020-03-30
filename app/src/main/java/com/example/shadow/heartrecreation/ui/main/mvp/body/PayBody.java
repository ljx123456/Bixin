package com.example.shadow.heartrecreation.ui.main.mvp.body;

import com.example.shadow.heartrecreation.ui.main.dialog.CouponsDialog;

import java.util.List;

public class PayBody {
    private List<CouponsDialog.serverData> serviceUsers;
    private String orderSkillType;
    private String businessId;
    private String boxTypeId;
    private String boxId;
    private String reserveStartTime;
    private List<CouponsDialog.drinkData> wines;
    private String referencesUserId;
    private String userCouponId;
    private String payType;
    private String serviceUserNum;
    private String orderBoxType;

    public List<CouponsDialog.serverData> getServiceUsers() {
        return serviceUsers;
    }

    public void setServiceUsers(List<CouponsDialog.serverData> serviceUsers) {
        this.serviceUsers = serviceUsers;
    }

    public String getOrderSkillType() {
        return orderSkillType;
    }

    public void setOrderSkillType(String orderSkillType) {
        this.orderSkillType = orderSkillType;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBoxTypeId() {
        return boxTypeId;
    }

    public void setBoxTypeId(String boxTypeId) {
        this.boxTypeId = boxTypeId;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public String getReserveStartTime() {
        return reserveStartTime;
    }

    public void setReserveStartTime(String reserveStartTime) {
        this.reserveStartTime = reserveStartTime;
    }

    public List<CouponsDialog.drinkData> getWines() {
        return wines;
    }

    public void setWines(List<CouponsDialog.drinkData> wines) {
        this.wines = wines;
    }

    public String getReferencesUserId() {
        return referencesUserId;
    }

    public void setReferencesUserId(String referencesUserId) {
        this.referencesUserId = referencesUserId;
    }

    public String getUserCouponId() {
        return userCouponId;
    }

    public void setUserCouponId(String userCouponId) {
        this.userCouponId = userCouponId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getServiceUserNum() {
        return serviceUserNum;
    }

    public void setServiceUserNum(String serviceUserNum) {
        this.serviceUserNum = serviceUserNum;
    }

    public String getOrderBoxType() {
        return orderBoxType;
    }

    public void setOrderBoxType(String orderBoxType) {
        this.orderBoxType = orderBoxType;
    }
}
