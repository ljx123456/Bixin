package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.util.List;

public class TakeRecordListBean {


    /**
     * code : 0
     * message : 请求成功.
     * data : [{"userTakeWineId":56,"businessName":"好乐星KTV(南门店)","createTime":"2019-03-16 10:14:30"},{"userTakeWineId":8,"businessName":"好乐星KTV(南门店)","createTime":"2019-02-15 15:26:04"}]
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
         * userTakeWineId : 56
         * businessName : 好乐星KTV(南门店)
         * createTime : 2019-03-16 10:14:30
         */

        private int userTakeWineId;
        private String businessName;
        private String createTime;
        private int userStorageWineId;
        private int userExpireWineId;
        private String expireTime;

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }

        public int getUserExpireWineId() {
            return userExpireWineId;
        }

        public void setUserExpireWineId(int userExpireWineId) {
            this.userExpireWineId = userExpireWineId;
        }

        public int getUserStorageWineId() {
            return userStorageWineId;
        }

        public void setUserStorageWineId(int userStorageWineId) {
            this.userStorageWineId = userStorageWineId;
        }

        public int getUserTakeWineId() {
            return userTakeWineId;
        }

        public void setUserTakeWineId(int userTakeWineId) {
            this.userTakeWineId = userTakeWineId;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}
