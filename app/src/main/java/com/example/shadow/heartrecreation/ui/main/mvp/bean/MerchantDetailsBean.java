package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class MerchantDetailsBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"businessInfo":{"businessId":2,"businessName":"梦乐美纯K量贩KTV","businessAddress":"成都市金牛区五福桥东路9号9幢1单元2,3楼(龙湖北城天街)","businessScore":2,"businessGdp":"200","isFollow":1,"longitude":"104.068536","latitude":"30.711184","videoSetList":[{"url":"https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4d1c5e4db.jpg","type":2},{"url":"https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4d2a058bd.jpg","type":2},{"url":"https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4d392f9ce.jpg","type":2},{"url":"http://he.yinyuetai.com/uploads/videos/common/BEA7016878C525FA4927002AF997DBF6.mp4","type":1}],"servicePrice":188},"orderInfo":[{"boxTypeId":219,"boxTypeName":"小小小包","boxTypePeoples":"12-15","minPrice":12366},{"boxTypeId":220,"boxTypeName":"小小3包","boxTypePeoples":"12-16","minPrice":12366},{"boxTypeId":5,"boxTypeName":"豪包","boxTypePeoples":"12-18","minPrice":1000},{"boxTypeId":6,"boxTypeName":"大包","boxTypePeoples":"8-12","minPrice":1500},{"boxTypeId":7,"boxTypeName":"中包","boxTypePeoples":"6-10","minPrice":1200},{"boxTypeId":8,"boxTypeName":"小包","boxTypePeoples":"4-8","minPrice":1000}],"myOrderInfo":[{"boxTypeId":5,"boxTypeName":"豪包","boxs":[{"businessBoxId":17,"businessBoxName":"J702"},{"businessBoxId":18,"businessBoxName":"R369"},{"businessBoxId":19,"businessBoxName":"G610"},{"businessBoxId":20,"businessBoxName":"F868"},{"businessBoxId":801,"businessBoxName":"L666"}]},{"boxTypeId":6,"boxTypeName":"大包","boxs":[{"businessBoxId":21,"businessBoxName":"L755"},{"businessBoxId":22,"businessBoxName":"E873"},{"businessBoxId":23,"businessBoxName":"S660"},{"businessBoxId":24,"businessBoxName":"G616"}]},{"boxTypeId":7,"boxTypeName":"中包","boxs":[{"businessBoxId":25,"businessBoxName":"K155"},{"businessBoxId":26,"businessBoxName":"N667"},{"businessBoxId":27,"businessBoxName":"O205"},{"businessBoxId":28,"businessBoxName":"C077"}]},{"boxTypeId":8,"boxTypeName":"小包","boxs":[{"businessBoxId":29,"businessBoxName":"V592"},{"businessBoxId":30,"businessBoxName":"L897"},{"businessBoxId":31,"businessBoxName":"D482"},{"businessBoxId":32,"businessBoxName":"R457"},{"businessBoxId":802,"businessBoxName":"k666"},{"businessBoxId":803,"businessBoxName":"f666"}]}],"nearServiceUser":["http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB","http://pic.bixinyule.com/82b3fc76-37f7-495f-9ca5-6f1dc26693ec","http://pic.bixinyule.com/ab7b301b-2dc9-45b2-939c-56313b41bcd5","http://pic1.win4000.com/pic/d/8c/b74f850490_250_350.jpg","http://pic1.win4000.com/pic/6/35/d4eb1549745_250_350.jpg","http://pic1.win4000.com/pic/c/fb/f33c1542513_250_350.jpg","http://pic.bixinyule.com/bx_user_a_default_3.png"]}
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
         * businessInfo : {"businessId":2,"businessName":"梦乐美纯K量贩KTV","businessAddress":"成都市金牛区五福桥东路9号9幢1单元2,3楼(龙湖北城天街)","businessScore":2,"businessGdp":"200","isFollow":1,"longitude":"104.068536","latitude":"30.711184","videoSetList":[{"url":"https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4d1c5e4db.jpg","type":2},{"url":"https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4d2a058bd.jpg","type":2},{"url":"https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4d392f9ce.jpg","type":2},{"url":"http://he.yinyuetai.com/uploads/videos/common/BEA7016878C525FA4927002AF997DBF6.mp4","type":1}],"servicePrice":188}
         * orderInfo : [{"boxTypeId":219,"boxTypeName":"小小小包","boxTypePeoples":"12-15","minPrice":12366},{"boxTypeId":220,"boxTypeName":"小小3包","boxTypePeoples":"12-16","minPrice":12366},{"boxTypeId":5,"boxTypeName":"豪包","boxTypePeoples":"12-18","minPrice":1000},{"boxTypeId":6,"boxTypeName":"大包","boxTypePeoples":"8-12","minPrice":1500},{"boxTypeId":7,"boxTypeName":"中包","boxTypePeoples":"6-10","minPrice":1200},{"boxTypeId":8,"boxTypeName":"小包","boxTypePeoples":"4-8","minPrice":1000}]
         * myOrderInfo : [{"boxTypeId":5,"boxTypeName":"豪包","boxs":[{"businessBoxId":17,"businessBoxName":"J702"},{"businessBoxId":18,"businessBoxName":"R369"},{"businessBoxId":19,"businessBoxName":"G610"},{"businessBoxId":20,"businessBoxName":"F868"},{"businessBoxId":801,"businessBoxName":"L666"}]},{"boxTypeId":6,"boxTypeName":"大包","boxs":[{"businessBoxId":21,"businessBoxName":"L755"},{"businessBoxId":22,"businessBoxName":"E873"},{"businessBoxId":23,"businessBoxName":"S660"},{"businessBoxId":24,"businessBoxName":"G616"}]},{"boxTypeId":7,"boxTypeName":"中包","boxs":[{"businessBoxId":25,"businessBoxName":"K155"},{"businessBoxId":26,"businessBoxName":"N667"},{"businessBoxId":27,"businessBoxName":"O205"},{"businessBoxId":28,"businessBoxName":"C077"}]},{"boxTypeId":8,"boxTypeName":"小包","boxs":[{"businessBoxId":29,"businessBoxName":"V592"},{"businessBoxId":30,"businessBoxName":"L897"},{"businessBoxId":31,"businessBoxName":"D482"},{"businessBoxId":32,"businessBoxName":"R457"},{"businessBoxId":802,"businessBoxName":"k666"},{"businessBoxId":803,"businessBoxName":"f666"}]}]
         * nearServiceUser : ["http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB","http://pic.bixinyule.com/82b3fc76-37f7-495f-9ca5-6f1dc26693ec","http://pic.bixinyule.com/ab7b301b-2dc9-45b2-939c-56313b41bcd5","http://pic1.win4000.com/pic/d/8c/b74f850490_250_350.jpg","http://pic1.win4000.com/pic/6/35/d4eb1549745_250_350.jpg","http://pic1.win4000.com/pic/c/fb/f33c1542513_250_350.jpg","http://pic.bixinyule.com/bx_user_a_default_3.png"]
         */

        private BusinessInfoBean businessInfo;
        private List<OrderInfoBean> orderInfo;
        private List<MyOrderInfoBean> myOrderInfo;
        private List<String> nearServiceUser;

        public BusinessInfoBean getBusinessInfo() {
            return businessInfo;
        }

        public void setBusinessInfo(BusinessInfoBean businessInfo) {
            this.businessInfo = businessInfo;
        }

        public List<OrderInfoBean> getOrderInfo() {
            return orderInfo;
        }

        public void setOrderInfo(List<OrderInfoBean> orderInfo) {
            this.orderInfo = orderInfo;
        }

        public List<MyOrderInfoBean> getMyOrderInfo() {
            return myOrderInfo;
        }

        public void setMyOrderInfo(List<MyOrderInfoBean> myOrderInfo) {
            this.myOrderInfo = myOrderInfo;
        }

        public List<String> getNearServiceUser() {
            return nearServiceUser;
        }

        public void setNearServiceUser(List<String> nearServiceUser) {
            this.nearServiceUser = nearServiceUser;
        }

        public static class BusinessInfoBean {
            /**
             * businessId : 2
             * businessName : 梦乐美纯K量贩KTV
             * businessAddress : 成都市金牛区五福桥东路9号9幢1单元2,3楼(龙湖北城天街)
             * businessScore : 2
             * businessGdp : 200
             * isFollow : 1
             * longitude : 104.068536
             * latitude : 30.711184
             * videoSetList : [{"url":"https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4d1c5e4db.jpg","type":2},{"url":"https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4d2a058bd.jpg","type":2},{"url":"https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4d392f9ce.jpg","type":2},{"url":"http://he.yinyuetai.com/uploads/videos/common/BEA7016878C525FA4927002AF997DBF6.mp4","type":1}]
             * servicePrice : 188
             */

            private int businessId;
            private String businessName;
            private String businessAddress;
            private double businessScore;
            private String businessGdp;
            private int isFollow;
            private String longitude;
            private String latitude;
            private BigDecimal servicePrice=new BigDecimal(0.00);
            private List<VideoSetListBean> videoSetList;
            private String businessStartHours;
            private String businessEndHours;

            public String getBusinessStartHours() {
                return businessStartHours;
            }

            public void setBusinessStartHours(String businessStartHours) {
                this.businessStartHours = businessStartHours;
            }

            public String getBusinessEndHours() {
                return businessEndHours;
            }

            public void setBusinessEndHours(String businessEndHours) {
                this.businessEndHours = businessEndHours;
            }

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

            public String getBusinessAddress() {
                return businessAddress;
            }

            public void setBusinessAddress(String businessAddress) {
                this.businessAddress = businessAddress;
            }

            public double getBusinessScore() {
                return businessScore;
            }

            public void setBusinessScore(double businessScore) {
                this.businessScore = businessScore;
            }

            public String getBusinessGdp() {
                return businessGdp;
            }

            public void setBusinessGdp(String businessGdp) {
                this.businessGdp = businessGdp;
            }

            public int getIsFollow() {
                return isFollow;
            }

            public void setIsFollow(int isFollow) {
                this.isFollow = isFollow;
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

            public List<VideoSetListBean> getVideoSetList() {
                return videoSetList;
            }

            public void setVideoSetList(List<VideoSetListBean> videoSetList) {
                this.videoSetList = videoSetList;
            }

            public static class VideoSetListBean {
                /**
                 * url : https://back.tobosu.com/ke_file/2018-01-27/m_5a6c4d1c5e4db.jpg
                 * type : 2
                 */

                private String url;
                private int type;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }
        }

        public static class OrderInfoBean {
            /**
             * boxTypeId : 219
             * boxTypeName : 小小小包
             * boxTypePeoples : 12-15
             * minPrice : 12366
             */

            private int boxTypeId;
            private String boxTypeName;
            private String boxTypePeoples;
            private BigDecimal minPrice=new BigDecimal(0.00);

            public int getBoxTypeId() {
                return boxTypeId;
            }

            public void setBoxTypeId(int boxTypeId) {
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
        }

        public static class MyOrderInfoBean {
            /**
             * boxTypeId : 5
             * boxTypeName : 豪包
             * boxs : [{"businessBoxId":17,"businessBoxName":"J702"},{"businessBoxId":18,"businessBoxName":"R369"},{"businessBoxId":19,"businessBoxName":"G610"},{"businessBoxId":20,"businessBoxName":"F868"},{"businessBoxId":801,"businessBoxName":"L666"}]
             */

            private int boxTypeId;
            private String boxTypeName;
            private List<BoxsBean> boxs;

            public int getBoxTypeId() {
                return boxTypeId;
            }

            public void setBoxTypeId(int boxTypeId) {
                this.boxTypeId = boxTypeId;
            }

            public String getBoxTypeName() {
                return boxTypeName;
            }

            public void setBoxTypeName(String boxTypeName) {
                this.boxTypeName = boxTypeName;
            }

            public List<BoxsBean> getBoxs() {
                return boxs;
            }

            public void setBoxs(List<BoxsBean> boxs) {
                this.boxs = boxs;
            }

            public static class BoxsBean {
                /**
                 * businessBoxId : 17
                 * businessBoxName : J702
                 */

                private int businessBoxId;
                private String businessBoxName;

                public int getBusinessBoxId() {
                    return businessBoxId;
                }

                public void setBusinessBoxId(int businessBoxId) {
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
