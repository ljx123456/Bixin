package com.example.shadow.heartrecreation.ui.order.mvp.bean;

import java.util.List;

public class ReasonBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : [{"reasonId":1,"describe":"疑似提供色情服务或其它违法行为"},{"reasonId":2,"describe":"达人态度不好"},{"reasonId":3,"describe":"不是本人"},{"reasonId":4,"describe":"其他"}]
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
         * reasonId : 1
         * describe : 疑似提供色情服务或其它违法行为
         */

        private int reasonId;
        private String describe;
        private boolean isFlag=false;

        public boolean isFlag() {
            return isFlag;
        }

        public void setFlag(boolean flag) {
            isFlag = flag;
        }

        public int getReasonId() {
            return reasonId;
        }

        public void setReasonId(int reasonId) {
            this.reasonId = reasonId;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }
    }
}
