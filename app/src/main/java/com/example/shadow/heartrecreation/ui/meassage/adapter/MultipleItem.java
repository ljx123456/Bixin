package com.example.shadow.heartrecreation.ui.meassage.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.shadow.heartrecreation.ui.meassage.mvp.bean.NotificationBean;

public class MultipleItem implements MultiItemEntity {
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    private int itemType;
    private NotificationBean.DataBean infoModel;

    public MultipleItem(int itemType, NotificationBean.DataBean infoModel) {
        this.itemType = itemType;
        this.infoModel = infoModel;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public NotificationBean.DataBean getInfoModel() {
        return infoModel;
    }

    public void setInfoModel(NotificationBean.DataBean infoModel) {
        this.infoModel = infoModel;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    class infoModel {
        private String text;
        private String num;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }
    }
}
