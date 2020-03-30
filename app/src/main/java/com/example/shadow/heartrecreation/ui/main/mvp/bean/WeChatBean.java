package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import com.google.gson.annotations.SerializedName;

public class WeChatBean {


    /**
     * code : 0
     * message : 请求成功.
     * data : {"package":"Sign=WXPay","orderId":"2000201901210714139872240","appid":"wx4d89639ebf5bc12a","sign":"026214AF6BB969A567186E3FF9DF5896","partnerid":"1483845292","prepayid":"wx21160714540478bb3c0d1dc62452034127","noncestr":"n1a2vb5w8l5owa90wlon9ru87yk0fpjm","timestamp":"1548058034"}
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
         * package : Sign=WXPay
         * orderId : 2000201901210714139872240
         * appid : wx4d89639ebf5bc12a
         * sign : 026214AF6BB969A567186E3FF9DF5896
         * partnerid : 1483845292
         * prepayid : wx21160714540478bb3c0d1dc62452034127
         * noncestr : n1a2vb5w8l5owa90wlon9ru87yk0fpjm
         * timestamp : 1548058034
         */

        @SerializedName("package")
        private String packageX;
        private String orderId;
        private String appid;
        private String sign;
        private String partnerid;
        private String prepayid;
        private String noncestr;
        private String timestamp;
        private String orderNo;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }
}
