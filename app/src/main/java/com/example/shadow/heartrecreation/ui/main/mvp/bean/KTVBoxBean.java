package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class KTVBoxBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"businessInfo":{"businessName":"美乐迪KTV(二环路东三段)","businessAddress":"二环路东三段11号附109号","avatar":"https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4f0a67861.jpg","longitude":"104.113985","latitude":"30.660263","servicePrice":123.23,"businessId":1},"myOrderInfo":[{"boxTypeId":261,"boxTypeName":"11","boxTypePeoples":"10-20","minPrice":1555.2,"boxs":[{"businessBoxId":15354,"businessBoxName":"741"},{"businessBoxId":15355,"businessBoxName":"745"}]},{"boxTypeId":1,"boxTypeName":"包间1","boxTypePeoples":"10-20","minPrice":1555,"boxs":[{"businessBoxId":1,"businessBoxName":"N097"},{"businessBoxId":2,"businessBoxName":"U642"},{"businessBoxId":3,"businessBoxName":"Y377"},{"businessBoxId":4,"businessBoxName":"F980"}]},{"boxTypeId":3,"boxTypeName":"中包","boxTypePeoples":"10-20","minPrice":1555,"boxs":[]},{"boxTypeId":4,"boxTypeName":"小包","boxTypePeoples":"10-20","minPrice":1555,"boxs":[]},{"boxTypeId":2,"boxTypeName":"大包","boxTypePeoples":"10-20","minPrice":1555,"boxs":[]}]}
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
         * businessInfo : {"businessName":"美乐迪KTV(二环路东三段)","businessAddress":"二环路东三段11号附109号","avatar":"https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4f0a67861.jpg","longitude":"104.113985","latitude":"30.660263","servicePrice":123.23,"businessId":1}
         * myOrderInfo : [{"boxTypeId":261,"boxTypeName":"11","boxTypePeoples":"10-20","minPrice":1555.2,"boxs":[{"businessBoxId":15354,"businessBoxName":"741"},{"businessBoxId":15355,"businessBoxName":"745"}]},{"boxTypeId":1,"boxTypeName":"包间1","boxTypePeoples":"10-20","minPrice":1555,"boxs":[{"businessBoxId":1,"businessBoxName":"N097"},{"businessBoxId":2,"businessBoxName":"U642"},{"businessBoxId":3,"businessBoxName":"Y377"},{"businessBoxId":4,"businessBoxName":"F980"}]},{"boxTypeId":3,"boxTypeName":"中包","boxTypePeoples":"10-20","minPrice":1555,"boxs":[]},{"boxTypeId":4,"boxTypeName":"小包","boxTypePeoples":"10-20","minPrice":1555,"boxs":[]},{"boxTypeId":2,"boxTypeName":"大包","boxTypePeoples":"10-20","minPrice":1555,"boxs":[]}]
         */

        private BusinessInfoBean businessInfo;
        private List<MyOrderInfoBean> myOrderInfo;

        public BusinessInfoBean getBusinessInfo() {
            return businessInfo;
        }

        public void setBusinessInfo(BusinessInfoBean businessInfo) {
            this.businessInfo = businessInfo;
        }

        public List<MyOrderInfoBean> getMyOrderInfo() {
            return myOrderInfo;
        }

        public void setMyOrderInfo(List<MyOrderInfoBean> myOrderInfo) {
            this.myOrderInfo = myOrderInfo;
        }

        public static class BusinessInfoBean {
            /**
             * businessName : 美乐迪KTV(二环路东三段)
             * businessAddress : 二环路东三段11号附109号
             * avatar : https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4f0a67861.jpg
             * longitude : 104.113985
             * latitude : 30.660263
             * servicePrice : 123.23
             * businessId : 1
             */

            private String businessName;
            private String businessAddress;
            private String avatar;
            private String longitude;
            private String latitude;
            private BigDecimal servicePrice=new BigDecimal(0.00);
            private String businessId;

            public String getBusinessName() {
                return businessName;
            }

            public void setBusinessName(String businessName) {
                this.businessName = businessName;
            }

            public String getBusinessAddress() {
                return businessAddress;
            }

            public void setBusinessAddress(String businessAddress) {
                this.businessAddress = businessAddress;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public BigDecimal getServicePrice() {
                return servicePrice;
            }

            public void setServicePrice(BigDecimal servicePrice) {
                this.servicePrice = servicePrice;
            }

            public String getBusinessId() {
                return businessId;
            }

            public void setBusinessId(String businessId) {
                this.businessId = businessId;
            }
        }

        public static class MyOrderInfoBean {
            /**
             * boxTypeId : 261
             * boxTypeName : 11
             * boxTypePeoples : 10-20
             * minPrice : 1555.2
             * boxs : [{"businessBoxId":15354,"businessBoxName":"741"},{"businessBoxId":15355,"businessBoxName":"745"}]
             */

            private String boxTypeId;
            private String boxTypeName;
            private String boxTypePeoples;
            private BigDecimal minPrice=new BigDecimal(0.00);
            private List<BoxsBean> boxs;

            public String getBoxTypeId() {
                return boxTypeId;
            }

            public void setBoxTypeId(String boxTypeId) {
                this.boxTypeId = boxTypeId;
            }

            public String getBoxTypeName() {
                return boxTypeName;
            }

            public void setBoxTypeName(String boxTypeName) {
                this.boxTypeName = boxTypeName;
            }

            public String getBoxTypePeoples() {
                return boxTypePeoples;
            }

            public void setBoxTypePeoples(String boxTypePeoples) {
                this.boxTypePeoples = boxTypePeoples;
            }

            public BigDecimal getMinPrice() {
                return minPrice;
            }

            public void setMinPrice(BigDecimal minPrice) {
                this.minPrice = minPrice;
            }

            public List<BoxsBean> getBoxs() {
                return boxs;
            }

            public void setBoxs(List<BoxsBean> boxs) {
                this.boxs = boxs;
            }

            public static class BoxsBean {
                /**
                 * businessBoxId : 15354
                 * businessBoxName : 741
                 */

                private String businessBoxId;
                private String businessBoxName;

                public String getBusinessBoxId() {
                    return businessBoxId;
                }

                public void setBusinessBoxId(String businessBoxId) {
                    this.businessBoxId = businessBoxId;
                }

                public String getBusinessBoxName() {
                    return businessBoxName;
                }

                public void setBusinessBoxName(String businessBoxName) {
                    this.businessBoxName = businessBoxName;
                }
            }
        }
    }
}
