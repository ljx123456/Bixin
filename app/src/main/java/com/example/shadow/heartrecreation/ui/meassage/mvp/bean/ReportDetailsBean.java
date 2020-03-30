package com.example.shadow.heartrecreation.ui.meassage.mvp.bean;

public class ReportDetailsBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"reportContent":"test","handleRes":"你的错","createTime":"2019-07-30 19:16:52","updateTime":"2019-07-30 19:20:05","serviceUserName":"ゝTracy ."}
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
         * reportContent : test
         * handleRes : 你的错
         * createTime : 2019-07-30 19:16:52
         * updateTime : 2019-07-30 19:20:05
         * serviceUserName : ゝTracy .
         */

        private String reportContent;
        private String handleRes;
        private String createTime;
        private String updateTime;
        private String serviceUserName;

        public String getReportContent() {
            return reportContent;
        }

        public void setReportContent(String reportContent) {
            this.reportContent = reportContent;
        }

        public String getHandleRes() {
            return handleRes;
        }

        public void setHandleRes(String handleRes) {
            this.handleRes = handleRes;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getServiceUserName() {
            return serviceUserName;
        }

        public void setServiceUserName(String serviceUserName) {
            this.serviceUserName = serviceUserName;
        }
    }
}
