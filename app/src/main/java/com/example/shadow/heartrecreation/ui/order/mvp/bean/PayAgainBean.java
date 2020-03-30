package com.example.shadow.heartrecreation.ui.order.mvp.bean;

import com.google.gson.annotations.SerializedName;

public class PayAgainBean {

    private int code;
    private String message;
    private DataBean data;
    /**
     * data : {"orderId":"2000201902143246588795165","payInfo":"alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2018032602449914&biz_content=%7B%22body%22%3A%22%E6%AF%94%E5%BF%83%E5%A8%B1%E4%B9%90%22%2C%22out_trade_no%22%3A%222000201902143246588795165%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%AF%94%E5%BF%83%E5%A8%B1%E4%B9%90%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A%220.01%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F22i778d481.51mypc.cn%2Fpay%2FaliPayCallBack&sign=bES0GvstoivUhd0CXmONN%2F%2FStWVOX72yE32eN4G5TVFavBSTyr7kno3kaCgvsVIcDkk%2BxOChnr85zSt%2F8iLBjcCK1V2lh0%2Fr8zzC9M3PEq0GIwZ%2BVuCG3AZNhesHt2V2G12qFTLtXJj4NX9UAirwnLF4pHpsGkwiHGf%2Bs9unFnMnCH6rSOcFI%2FQjBUwzw3gV4cUQsynWeApAQkaHqnckWNtzHkEl3mNdWNsIWRCKUbXrfg0SfTiCFjgPKyCGzsB7iN5b8U8gASUA7uFmFzPDtrV4pHrEUcmmKtst0uH8jX486iQ20lijhaCfkXnozxcm2e89oQ6%2FoTtLy79vZf2aNw%3D%3D&sign_type=RSA2&timestamp=2019-02-20+17%3A48%3A18&version=1.0"}
     */

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
         * orderId : 2000201902143246588795165
         * appid : wx4d89639ebf5bc12a
         * sign : 35C12B9540DA9D2E1F28E5485B50FBED
         * partnerid : 1483845292
         * prepayid : wx20174838259851e90b6403fe1628617812
         * noncestr : 8xtpjqhocwo8zecw23acsiw4tkx27vql
         * timestamp : 1550656118
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
        private String payInfo;

        public String getPayInfo() {
            return payInfo;
        }

        public void setPayInfo(String payInfo) {
            this.payInfo = payInfo;
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
