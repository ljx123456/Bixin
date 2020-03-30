package com.example.shadow.heartrecreation.ui.main.mvp.bean;

public class TipsBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"orderTips":false,"wineTips":false,"refundTips":false}
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
         * orderTips : false
         * wineTips : false
         * refundTips : false
         */

        private boolean orderTips;
        private boolean wineTips;
        private boolean refundTips;
        private boolean messageTips;

        public boolean isOrderTips() {
            return orderTips;
        }

        public void setOrderTips(boolean orderTips) {
            this.orderTips = orderTips;
        }

        public boolean isWineTips() {
            return wineTips;
        }

        public void setWineTips(boolean wineTips) {
            this.wineTips = wineTips;
        }

        public boolean isRefundTips() {
            return refundTips;
        }

        public void setRefundTips(boolean refundTips) {
            this.refundTips = refundTips;
        }

        public boolean isMessageTips() {
            return messageTips;
        }

        public void setMessageTips(boolean messageTips) {
            this.messageTips = messageTips;
        }
    }
}
