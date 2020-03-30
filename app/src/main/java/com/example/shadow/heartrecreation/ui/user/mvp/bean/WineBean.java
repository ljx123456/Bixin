package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.util.List;

public class WineBean {


    /**
     * code : 0
     * message : 请求成功.
     * data : [{"businessId":1,"businessName":"好乐迪量贩KTV(沙湾店)","isWineSurplus":"有酒水即将过期"},{"businessId":2,"businessName":"银柜音乐休闲会所"}]
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
         * businessId : 1
         * businessName : 好乐迪量贩KTV(沙湾店)
         * isWineSurplus : 有酒水即将过期
         */

        private int businessId;
        private String businessName;
        private String isWineSurplus;

        public int getBusinessId() {
            return businessId;
        }

        public void setBusinessId(int businessId) {
            this.businessId = businessId;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getIsWineSurplus() {
            return isWineSurplus;
        }

        public void setIsWineSurplus(String isWineSurplus) {
            this.isWineSurplus = isWineSurplus;
        }
    }
}
