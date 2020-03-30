package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class RefundMerchantBean {

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
         * refundId : 46
         * orderNo : 1000201902145317265284515
         * createUserId : 3632
         * refundType : 0
         * refundState : 2
         * refundPrice : 8093
         * payPrice : 8093
         * startTime : 2019-02-14 11:22:13
         * handleTime : 2019-02-14 11:22:13
         * endTime : 2019-02-14 11:22:14
         * orderDetail : {"orderState":5,"orderNo":"1000201902145317265284515","businessName":"锦华KTV","address":"成都市双流县天府大道南延线325号（远大都市风景荷兰水街三号楼）","longitude":"104.070915","latitude":"30.527183","businessPhone":"02881501111","businessImg":"http://e.hiphotos.baidu.com/nuomi/pic/item/359b033b5bb5c9eaae1ea5bfdc39b6003bf3b3f9.jpg","boxTypeName":"大包","boxName":"","startTime":"2019-02-15 00:00:00","serviceUserCountNum":10,"orderTakingNum":7,"wineCountPrice":56651,"couponPrice":0,"activityDeductionPrice":0,"orderCountPrice":56651,"boxServiceMoney":0,"serviceUsers":[{"orderServiceNo":"3000201902145317287024596","serviceUserId":3376,"age":"40","nickname":"卜居森林","sex":1,"avatar":"http://t2.hddhhn.com/uploads/tu/201808/9999/463bcc3349.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"nbeI2PwSxQHml0/mh8wHdJyg5jbxEw+spmsK1z3sj1oqYDNLqE5klGvpRvdWfJwNTtnJOii9AnZN+dQSNrgONQ=="},{"orderServiceNo":"3000201902145317289033805","serviceUserId":3379,"age":"19","nickname":"ＩＱ也丆快樂","sex":1,"avatar":"http://t2.hddhhn.com/uploads/tu/201809/9999/7f8210826f.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"5nZexx2/S/I1olrE3nTLjnLZxu92eHTua3fx4mvouGkC4ElSHs+R8zanNw0OAx77v2TdafQzp5qBXG5LX04GBw=="},{"orderServiceNo":"3000201902145317289671992","serviceUserId":3377,"age":"9","nickname":"关键我是女爷 @","sex":1,"avatar":"http://t2.hddhhn.com/uploads/tu/201809/9999/3bbc236da5.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"9KxMnb2EzrPXaBJwrEGBNTTGc5QD0vNbc19NRlM1oXadmTrT6kVOhqecPgbSrfDNMgQM/Wle5kmt239TmjRYhg=="},{"orderServiceNo":"3000201902145317290076471","serviceUserId":3381,"age":"30","nickname":"光頭尼姑","sex":2,"avatar":"http://t2.hddhhn.com/uploads/tu/201809/9999/32898d9974.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"7FDekx54Y74C7Q7ppYL2cnLZxu92eHTua3fx4mvouGkC4ElSHs+R88+qng2VVcNI5yrFoI4PfC+BXG5LX04GBw=="},{"orderServiceNo":"3000201902145317291876279","serviceUserId":3382,"age":"32","nickname":"森屿麋鹿","sex":1,"avatar":"http://t2.hddhhn.com/uploads/tu/201803/9999/cbeec2f42f.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"NJyMRjUhITuLLJqiXp2lmnLZxu92eHTua3fx4mvouGkC4ElSHs+R80yGe+VmjFuUQdP4P+iw3S6BXG5LX04GBw=="},{"orderServiceNo":"3000201902145317292057700","serviceUserId":3383,"age":"29","nickname":"一只萌兽╯▽╰","sex":1,"avatar":"http://t2.hddhhn.com/uploads/tu/201809/9999/eec1063119.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"/ybH7UiSjYi+7p/YaaIPzJyg5jbxEw+spmsK1z3sj1oqYDNLqE5klBqfVjW7Oxcr760RrQlMq8BN+dQSNrgONQ=="},{"orderServiceNo":"3000201902145317293419096","serviceUserId":3385,"age":"16","nickname":"此籹子╭ァ狠乖","sex":1,"avatar":"http://t2.hddhhn.com/uploads/tu/201809/9999/7edbfc1a59.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"GTSvWLxqiYIQ/g1Usg1RZ5yg5jbxEw+spmsK1z3sj1oqYDNLqE5klDnYfPj/G01mlCf4lMvEq8hN+dQSNrgONQ=="}],"orderWine":{"firstWine":{"wines":[{"wineId":901,"num":3,"wineTypeName":"酒水套餐","wineTypeId":181,"wineName":"情迷巴西","wineImage":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548686654258&di=23523b6be3bdaa3256351f7e58a23361&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fbainuo%2Fwh%3D470%2C285%2Fsign%3D8628a35205e939015657853a4cdc78d5%2Fa8ec8a13632762d00df2bfcda4ec08fa503dc6f0.jpg","wineCountPrice":2523.84},{"wineId":902,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"茅台","wineImage":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineCountPrice":844},{"wineId":903,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"五粮液","wineImage":"https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=5c569456a944ad343ab28fd5b1cb6791/1ad5ad6eddc451da4cbe3a50befd5266d11632c4.jpg","wineCountPrice":936},{"wineId":904,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"剑南春","wineImage":"https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike72%2C5%2C5%2C72%2C24/sign=51626027291f95cab2f89ae4a87e145b/6f061d950a7b0208bd9c5ab86ed9f2d3572cc816.jpg","wineCountPrice":302},{"wineId":905,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"泸州老窖特曲","wineImage":"https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike72%2C5%2C5%2C72%2C24/sign=78574fd8a9014c080d3620f76b12696d/4ec2d5628535e5dd766267ae76c6a7efce1b6271.jpg","wineCountPrice":208},{"wineId":906,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"西凤酒","wineImage":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=8e953c3d032442a7ba03f5f7b02ac62e/1b4c510fd9f9d72a709d16a3d82a2834359bbb96.jpg","wineCountPrice":438},{"wineId":907,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"汾酒","wineImage":"https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/crop%3D0%2C161%2C800%2C528%3Bc0%3Dbaike92%2C5%2C5%2C92%2C30/sign=39f7fb278b0a19d8df4cde450ecaaeba/95eef01f3a292df515b60e83b7315c6034a8732b.jpg","wineCountPrice":737},{"wineId":908,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"古井贡酒","wineImage":"https://gss3.bdstatic.com/7Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=553d29c7eb50352aa56c2d5a322a9097/37d12f2eb9389b50200cc6228735e5dde6116eca.jpg","wineCountPrice":945},{"wineId":909,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"董酒","wineImage":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=60ef5413dc2a283457ab3e593adca28f/adaf2edda3cc7cd98da670d73101213fb80e9130.jpg","wineCountPrice":815}]},"appendWines":[]},"referencesUser":{"age":"35","nickname":"做个容嬷嬷一样毒的女人∝","sex":2,"avatar":"http://pic1.win4000.com/pic/3/a6/d618029419_250_350.jpg","occupation":"教师"}}
         */

        private int refundId;
        private String orderNo;
        private int createUserId;
        private int refundType;
        private int refundState;
        private BigDecimal refundPrice=new BigDecimal(0.00);
        private BigDecimal payPrice=new BigDecimal(0.00);
        private String startTime;
        private String handleTime;
        private String endTime;
        private OrderDetailBean orderDetail;
        private String platformPhone;

        public String getPlatformPhone() {
            return platformPhone;
        }

        public void setPlatformPhone(String platformPhone) {
            this.platformPhone = platformPhone;
        }

        public int getRefundId() {
            return refundId;
        }

        public void setRefundId(int refundId) {
            this.refundId = refundId;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public int getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(int createUserId) {
            this.createUserId = createUserId;
        }

        public int getRefundType() {
            return refundType;
        }

        public void setRefundType(int refundType) {
            this.refundType = refundType;
        }

        public int getRefundState() {
            return refundState;
        }

        public void setRefundState(int refundState) {
            this.refundState = refundState;
        }

        public BigDecimal getRefundPrice() {
            return refundPrice;
        }

        public void setRefundPrice(BigDecimal refundPrice) {
            this.refundPrice = refundPrice;
        }

        public BigDecimal getPayPrice() {
            return payPrice;
        }

        public void setPayPrice(BigDecimal payPrice) {
            this.payPrice = payPrice;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
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

        public OrderDetailBean getOrderDetail() {
            return orderDetail;
        }

        public void setOrderDetail(OrderDetailBean orderDetail) {
            this.orderDetail = orderDetail;
        }

        public static class OrderDetailBean {
            /**
             * orderState : 5
             * orderNo : 1000201902145317265284515
             * businessName : 锦华KTV
             * address : 成都市双流县天府大道南延线325号（远大都市风景荷兰水街三号楼）
             * longitude : 104.070915
             * latitude : 30.527183
             * businessPhone : 02881501111
             * businessImg : http://e.hiphotos.baidu.com/nuomi/pic/item/359b033b5bb5c9eaae1ea5bfdc39b6003bf3b3f9.jpg
             * boxTypeName : 大包
             * boxName :
             * startTime : 2019-02-15 00:00:00
             * serviceUserCountNum : 10
             * orderTakingNum : 7
             * wineCountPrice : 56651
             * couponPrice : 0
             * activityDeductionPrice : 0
             * orderCountPrice : 56651
             * boxServiceMoney : 0
             * serviceUsers : [{"orderServiceNo":"3000201902145317287024596","serviceUserId":3376,"age":"40","nickname":"卜居森林","sex":1,"avatar":"http://t2.hddhhn.com/uploads/tu/201808/9999/463bcc3349.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"nbeI2PwSxQHml0/mh8wHdJyg5jbxEw+spmsK1z3sj1oqYDNLqE5klGvpRvdWfJwNTtnJOii9AnZN+dQSNrgONQ=="},{"orderServiceNo":"3000201902145317289033805","serviceUserId":3379,"age":"19","nickname":"ＩＱ也丆快樂","sex":1,"avatar":"http://t2.hddhhn.com/uploads/tu/201809/9999/7f8210826f.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"5nZexx2/S/I1olrE3nTLjnLZxu92eHTua3fx4mvouGkC4ElSHs+R8zanNw0OAx77v2TdafQzp5qBXG5LX04GBw=="},{"orderServiceNo":"3000201902145317289671992","serviceUserId":3377,"age":"9","nickname":"关键我是女爷 @","sex":1,"avatar":"http://t2.hddhhn.com/uploads/tu/201809/9999/3bbc236da5.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"9KxMnb2EzrPXaBJwrEGBNTTGc5QD0vNbc19NRlM1oXadmTrT6kVOhqecPgbSrfDNMgQM/Wle5kmt239TmjRYhg=="},{"orderServiceNo":"3000201902145317290076471","serviceUserId":3381,"age":"30","nickname":"光頭尼姑","sex":2,"avatar":"http://t2.hddhhn.com/uploads/tu/201809/9999/32898d9974.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"7FDekx54Y74C7Q7ppYL2cnLZxu92eHTua3fx4mvouGkC4ElSHs+R88+qng2VVcNI5yrFoI4PfC+BXG5LX04GBw=="},{"orderServiceNo":"3000201902145317291876279","serviceUserId":3382,"age":"32","nickname":"森屿麋鹿","sex":1,"avatar":"http://t2.hddhhn.com/uploads/tu/201803/9999/cbeec2f42f.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"NJyMRjUhITuLLJqiXp2lmnLZxu92eHTua3fx4mvouGkC4ElSHs+R80yGe+VmjFuUQdP4P+iw3S6BXG5LX04GBw=="},{"orderServiceNo":"3000201902145317292057700","serviceUserId":3383,"age":"29","nickname":"一只萌兽╯▽╰","sex":1,"avatar":"http://t2.hddhhn.com/uploads/tu/201809/9999/eec1063119.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"/ybH7UiSjYi+7p/YaaIPzJyg5jbxEw+spmsK1z3sj1oqYDNLqE5klBqfVjW7Oxcr760RrQlMq8BN+dQSNrgONQ=="},{"orderServiceNo":"3000201902145317293419096","serviceUserId":3385,"age":"16","nickname":"此籹子╭ァ狠乖","sex":1,"avatar":"http://t2.hddhhn.com/uploads/tu/201809/9999/7edbfc1a59.jpg","occupation":"教师","serviceStartTime":"2019-02-15 00:00:00","price":800,"serviceState":0,"rongToken":"GTSvWLxqiYIQ/g1Usg1RZ5yg5jbxEw+spmsK1z3sj1oqYDNLqE5klDnYfPj/G01mlCf4lMvEq8hN+dQSNrgONQ=="}]
             * orderWine : {"firstWine":{"wines":[{"wineId":901,"num":3,"wineTypeName":"酒水套餐","wineTypeId":181,"wineName":"情迷巴西","wineImage":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548686654258&di=23523b6be3bdaa3256351f7e58a23361&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fbainuo%2Fwh%3D470%2C285%2Fsign%3D8628a35205e939015657853a4cdc78d5%2Fa8ec8a13632762d00df2bfcda4ec08fa503dc6f0.jpg","wineCountPrice":2523.84},{"wineId":902,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"茅台","wineImage":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineCountPrice":844},{"wineId":903,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"五粮液","wineImage":"https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=5c569456a944ad343ab28fd5b1cb6791/1ad5ad6eddc451da4cbe3a50befd5266d11632c4.jpg","wineCountPrice":936},{"wineId":904,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"剑南春","wineImage":"https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike72%2C5%2C5%2C72%2C24/sign=51626027291f95cab2f89ae4a87e145b/6f061d950a7b0208bd9c5ab86ed9f2d3572cc816.jpg","wineCountPrice":302},{"wineId":905,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"泸州老窖特曲","wineImage":"https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike72%2C5%2C5%2C72%2C24/sign=78574fd8a9014c080d3620f76b12696d/4ec2d5628535e5dd766267ae76c6a7efce1b6271.jpg","wineCountPrice":208},{"wineId":906,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"西凤酒","wineImage":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=8e953c3d032442a7ba03f5f7b02ac62e/1b4c510fd9f9d72a709d16a3d82a2834359bbb96.jpg","wineCountPrice":438},{"wineId":907,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"汾酒","wineImage":"https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/crop%3D0%2C161%2C800%2C528%3Bc0%3Dbaike92%2C5%2C5%2C92%2C30/sign=39f7fb278b0a19d8df4cde450ecaaeba/95eef01f3a292df515b60e83b7315c6034a8732b.jpg","wineCountPrice":737},{"wineId":908,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"古井贡酒","wineImage":"https://gss3.bdstatic.com/7Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=553d29c7eb50352aa56c2d5a322a9097/37d12f2eb9389b50200cc6228735e5dde6116eca.jpg","wineCountPrice":945},{"wineId":909,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"董酒","wineImage":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=60ef5413dc2a283457ab3e593adca28f/adaf2edda3cc7cd98da670d73101213fb80e9130.jpg","wineCountPrice":815}]},"appendWines":[]}
             * referencesUser : {"age":"35","nickname":"做个容嬷嬷一样毒的女人∝","sex":2,"avatar":"http://pic1.win4000.com/pic/3/a6/d618029419_250_350.jpg","occupation":"教师"}
             */

            private int orderState;
            private String orderNo;
            private String businessName;
            private String address;
            private String longitude;
            private String latitude;
            private String businessPhone;
            private String businessImg;
            private String boxTypeName;
            private String boxName;
            private String startTime;
            private int serviceUserCountNum;
            private int orderTakingNum;
            private BigDecimal wineCountPrice=new BigDecimal(0.00);
            private BigDecimal couponPrice=new BigDecimal(0.00);
            private BigDecimal activityDeductionPrice=new BigDecimal(0.00);
            private BigDecimal orderCountPrice=new BigDecimal(0.00);
            private BigDecimal boxServiceMoney=new BigDecimal(0.00);
            private OrderWineBean orderWine;
            private ReferencesUserBean referencesUser;
            private List<ServiceUsersBean> serviceUsers;
            private String createTime;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getOrderState() {
                return orderState;
            }

            public void setOrderState(int orderState) {
                this.orderState = orderState;
            }

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }

            public String getBusinessName() {
                return businessName;
            }

            public void setBusinessName(String businessName) {
                this.businessName = businessName;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
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

            public String getBusinessPhone() {
                return businessPhone;
            }

            public void setBusinessPhone(String businessPhone) {
                this.businessPhone = businessPhone;
            }

            public String getBusinessImg() {
                return businessImg;
            }

            public void setBusinessImg(String businessImg) {
                this.businessImg = businessImg;
            }

            public String getBoxTypeName() {
                return boxTypeName;
            }

            public void setBoxTypeName(String boxTypeName) {
                this.boxTypeName = boxTypeName;
            }

            public String getBoxName() {
                return boxName;
            }

            public void setBoxName(String boxName) {
                this.boxName = boxName;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public int getServiceUserCountNum() {
                return serviceUserCountNum;
            }

            public void setServiceUserCountNum(int serviceUserCountNum) {
                this.serviceUserCountNum = serviceUserCountNum;
            }

            public int getOrderTakingNum() {
                return orderTakingNum;
            }

            public void setOrderTakingNum(int orderTakingNum) {
                this.orderTakingNum = orderTakingNum;
            }

            public BigDecimal getWineCountPrice() {
                return wineCountPrice;
            }

            public void setWineCountPrice(BigDecimal wineCountPrice) {
                this.wineCountPrice = wineCountPrice;
            }

            public BigDecimal getCouponPrice() {
                return couponPrice;
            }

            public void setCouponPrice(BigDecimal couponPrice) {
                this.couponPrice = couponPrice;
            }

            public BigDecimal getActivityDeductionPrice() {
                return activityDeductionPrice;
            }

            public void setActivityDeductionPrice(BigDecimal activityDeductionPrice) {
                this.activityDeductionPrice = activityDeductionPrice;
            }

            public BigDecimal getOrderCountPrice() {
                return orderCountPrice;
            }

            public void setOrderCountPrice(BigDecimal orderCountPrice) {
                this.orderCountPrice = orderCountPrice;
            }

            public BigDecimal getBoxServiceMoney() {
                return boxServiceMoney;
            }

            public void setBoxServiceMoney(BigDecimal boxServiceMoney) {
                this.boxServiceMoney = boxServiceMoney;
            }

            public OrderWineBean getOrderWine() {
                return orderWine;
            }

            public void setOrderWine(OrderWineBean orderWine) {
                this.orderWine = orderWine;
            }

            public ReferencesUserBean getReferencesUser() {
                return referencesUser;
            }

            public void setReferencesUser(ReferencesUserBean referencesUser) {
                this.referencesUser = referencesUser;
            }

            public List<ServiceUsersBean> getServiceUsers() {
                return serviceUsers;
            }

            public void setServiceUsers(List<ServiceUsersBean> serviceUsers) {
                this.serviceUsers = serviceUsers;
            }

            public static class OrderWineBean {
                /**
                 * firstWine : {"wines":[{"wineId":901,"num":3,"wineTypeName":"酒水套餐","wineTypeId":181,"wineName":"情迷巴西","wineImage":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548686654258&di=23523b6be3bdaa3256351f7e58a23361&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fbainuo%2Fwh%3D470%2C285%2Fsign%3D8628a35205e939015657853a4cdc78d5%2Fa8ec8a13632762d00df2bfcda4ec08fa503dc6f0.jpg","wineCountPrice":2523.84},{"wineId":902,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"茅台","wineImage":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineCountPrice":844},{"wineId":903,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"五粮液","wineImage":"https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=5c569456a944ad343ab28fd5b1cb6791/1ad5ad6eddc451da4cbe3a50befd5266d11632c4.jpg","wineCountPrice":936},{"wineId":904,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"剑南春","wineImage":"https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike72%2C5%2C5%2C72%2C24/sign=51626027291f95cab2f89ae4a87e145b/6f061d950a7b0208bd9c5ab86ed9f2d3572cc816.jpg","wineCountPrice":302},{"wineId":905,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"泸州老窖特曲","wineImage":"https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike72%2C5%2C5%2C72%2C24/sign=78574fd8a9014c080d3620f76b12696d/4ec2d5628535e5dd766267ae76c6a7efce1b6271.jpg","wineCountPrice":208},{"wineId":906,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"西凤酒","wineImage":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=8e953c3d032442a7ba03f5f7b02ac62e/1b4c510fd9f9d72a709d16a3d82a2834359bbb96.jpg","wineCountPrice":438},{"wineId":907,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"汾酒","wineImage":"https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/crop%3D0%2C161%2C800%2C528%3Bc0%3Dbaike92%2C5%2C5%2C92%2C30/sign=39f7fb278b0a19d8df4cde450ecaaeba/95eef01f3a292df515b60e83b7315c6034a8732b.jpg","wineCountPrice":737},{"wineId":908,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"古井贡酒","wineImage":"https://gss3.bdstatic.com/7Po3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike180%2C5%2C5%2C180%2C60/sign=553d29c7eb50352aa56c2d5a322a9097/37d12f2eb9389b50200cc6228735e5dde6116eca.jpg","wineCountPrice":945},{"wineId":909,"num":1,"wineTypeName":"白酒","wineTypeId":182,"wineName":"董酒","wineImage":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=60ef5413dc2a283457ab3e593adca28f/adaf2edda3cc7cd98da670d73101213fb80e9130.jpg","wineCountPrice":815}]}
                 * appendWines : []
                 */

                private FirstWineBean firstWine;
                private List<?> appendWines;

                public FirstWineBean getFirstWine() {
                    return firstWine;
                }

                public void setFirstWine(FirstWineBean firstWine) {
                    this.firstWine = firstWine;
                }

                public List<?> getAppendWines() {
                    return appendWines;
                }

                public void setAppendWines(List<?> appendWines) {
                    this.appendWines = appendWines;
                }

                public static class FirstWineBean {
                    private List<WinesBean> wines;

                    public List<WinesBean> getWines() {
                        return wines;
                    }

                    public void setWines(List<WinesBean> wines) {
                        this.wines = wines;
                    }

                    public static class WinesBean {
                        /**
                         * wineId : 901
                         * num : 3
                         * wineTypeName : 酒水套餐
                         * wineTypeId : 181
                         * wineName : 情迷巴西
                         * wineImage : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548686654258&di=23523b6be3bdaa3256351f7e58a23361&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fbainuo%2Fwh%3D470%2C285%2Fsign%3D8628a35205e939015657853a4cdc78d5%2Fa8ec8a13632762d00df2bfcda4ec08fa503dc6f0.jpg
                         * wineCountPrice : 2523.84
                         */

                        private int wineId;
                        private int num;
                        private String wineTypeName;
                        private int wineTypeId;
                        private String wineName;
                        private String wineImage;
                        private BigDecimal wineCountPrice=new BigDecimal(0.00);

                        public int getWineId() {
                            return wineId;
                        }

                        public void setWineId(int wineId) {
                            this.wineId = wineId;
                        }

                        public int getNum() {
                            return num;
                        }

                        public void setNum(int num) {
                            this.num = num;
                        }

                        public String getWineTypeName() {
                            return wineTypeName;
                        }

                        public void setWineTypeName(String wineTypeName) {
                            this.wineTypeName = wineTypeName;
                        }

                        public int getWineTypeId() {
                            return wineTypeId;
                        }

                        public void setWineTypeId(int wineTypeId) {
                            this.wineTypeId = wineTypeId;
                        }

                        public String getWineName() {
                            return wineName;
                        }

                        public void setWineName(String wineName) {
                            this.wineName = wineName;
                        }

                        public String getWineImage() {
                            return wineImage;
                        }

                        public void setWineImage(String wineImage) {
                            this.wineImage = wineImage;
                        }

                        public BigDecimal getWineCountPrice() {
                            return wineCountPrice;
                        }

                        public void setWineCountPrice(BigDecimal wineCountPrice) {
                            this.wineCountPrice = wineCountPrice;
                        }
                    }
                }
            }

            public static class ReferencesUserBean {
                /**
                 * age : 35
                 * nickname : 做个容嬷嬷一样毒的女人∝
                 * sex : 2
                 * avatar : http://pic1.win4000.com/pic/3/a6/d618029419_250_350.jpg
                 * occupation : 教师
                 */

                private String age;
                private String nickname;
                private int sex;
                private String avatar;
                private String occupation;

                public String getAge() {
                    return age;
                }

                public void setAge(String age) {
                    this.age = age;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getOccupation() {
                    return occupation;
                }

                public void setOccupation(String occupation) {
                    this.occupation = occupation;
                }
            }

            public static class ServiceUsersBean {
                /**
                 * orderServiceNo : 3000201902145317287024596
                 * serviceUserId : 3376
                 * age : 40
                 * nickname : 卜居森林
                 * sex : 1
                 * avatar : http://t2.hddhhn.com/uploads/tu/201808/9999/463bcc3349.jpg
                 * occupation : 教师
                 * serviceStartTime : 2019-02-15 00:00:00
                 * price : 800
                 * serviceState : 0
                 * rongToken : nbeI2PwSxQHml0/mh8wHdJyg5jbxEw+spmsK1z3sj1oqYDNLqE5klGvpRvdWfJwNTtnJOii9AnZN+dQSNrgONQ==
                 */

                private String orderServiceNo;
                private int serviceUserId;
                private String age;
                private String nickname;
                private int sex;
                private String avatar;
                private String occupation;
                private String serviceStartTime;
                private BigDecimal price=new BigDecimal(0.00);
                private int serviceState;
                private String rongToken;

                public String getOrderServiceNo() {
                    return orderServiceNo;
                }

                public void setOrderServiceNo(String orderServiceNo) {
                    this.orderServiceNo = orderServiceNo;
                }

                public int getServiceUserId() {
                    return serviceUserId;
                }

                public void setServiceUserId(int serviceUserId) {
                    this.serviceUserId = serviceUserId;
                }

                public String getAge() {
                    return age;
                }

                public void setAge(String age) {
                    this.age = age;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getOccupation() {
                    return occupation;
                }

                public void setOccupation(String occupation) {
                    this.occupation = occupation;
                }

                public String getServiceStartTime() {
                    return serviceStartTime;
                }

                public void setServiceStartTime(String serviceStartTime) {
                    this.serviceStartTime = serviceStartTime;
                }

                public BigDecimal getPrice() {
                    return price;
                }

                public void setPrice(BigDecimal price) {
                    this.price = price;
                }

                public int getServiceState() {
                    return serviceState;
                }

                public void setServiceState(int serviceState) {
                    this.serviceState = serviceState;
                }

                public String getRongToken() {
                    return rongToken;
                }

                public void setRongToken(String rongToken) {
                    this.rongToken = rongToken;
                }
            }
        }
    }
}
