package com.example.shadow.heartrecreation.ui.order.mvp.bean;

import java.util.List;

public class ComplaintDetailsBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"complaintsId":1,"orderServiceNo":"3000201904160857131952091","reason":"疑似提供色情服务或其它违法行为","content":"内容","complaintsState":0,"handleRes":"处理结果","submitTime":"2019-04-17 21:17:47","handleTime":"2019-04-17 21:59:38","endTime":"2019-04-17 21:59:36","photos":["http://t1.27270.com/uploads/tu/201811/232/5f4adf133b.jpg","http://t1.27270.com/uploads/tu/201811/232/5f4adf133b.jpg"]}
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
         * complaintsId : 1
         * orderServiceNo : 3000201904160857131952091
         * reason : 疑似提供色情服务或其它违法行为
         * content : 内容
         * complaintsState : 0
         * handleRes : 处理结果
         * submitTime : 2019-04-17 21:17:47
         * handleTime : 2019-04-17 21:59:38
         * endTime : 2019-04-17 21:59:36
         * photos : ["http://t1.27270.com/uploads/tu/201811/232/5f4adf133b.jpg","http://t1.27270.com/uploads/tu/201811/232/5f4adf133b.jpg"]
         */

        private int complaintsId;
        private String orderServiceNo;
        private String reason;
        private String content;
        private int complaintsState;
        private String handleRes;
        private String submitTime;
        private String handleTime;
        private String endTime;
        private List<String> photos;

        public int getComplaintsId() {
            return complaintsId;
        }

        public void setComplaintsId(int complaintsId) {
            this.complaintsId = complaintsId;
        }

        public String getOrderServiceNo() {
            return orderServiceNo;
        }

        public void setOrderServiceNo(String orderServiceNo) {
            this.orderServiceNo = orderServiceNo;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getComplaintsState() {
            return complaintsState;
        }

        public void setComplaintsState(int complaintsState) {
            this.complaintsState = complaintsState;
        }

        public String getHandleRes() {
            return handleRes;
        }

        public void setHandleRes(String handleRes) {
            this.handleRes = handleRes;
        }

        public String getSubmitTime() {
            return submitTime;
        }

        public void setSubmitTime(String submitTime) {
            this.submitTime = submitTime;
        }

        public String getHandleTime() {
            return handleTime;
        }

        public void setHandleTime(String handleTime) {
            this.handleTime = handleTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public List<String> getPhotos() {
            return photos;
        }

        public void setPhotos(List<String> photos) {
            this.photos = photos;
        }
    }
}
