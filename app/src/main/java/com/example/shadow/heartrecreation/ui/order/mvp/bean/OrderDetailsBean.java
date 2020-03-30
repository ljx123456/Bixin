package com.example.shadow.heartrecreation.ui.order.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class OrderDetailsBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"orderState":1,"orderNo":"O201810260335521454603","businessId":1,"businessName":"好乐星KTV(南门店)","address":"成都市金牛区沙湾路1号汇龙湾广场1楼（一环路口）","longitude":"104.06","latitude":"30.67","businessImg":"http://t1.27270.com/uploads/tu/201811/213/98eb656674.jpg","boxTypeName":"豪包","boxName":"k666","businessPhone":"02865062777","startTime":"1993-08-21 00:00:00","endTime":"2018-12-21 18:29:20","orderTakingNum":3,"serviceCountPrice":2400,"wineCountPrice":42880,"couponPrice":1400,"activityDeductionPrice":"1200","orderCountPrice":43880,"boxServiceMoney":800,"waitPaymentTime":3567,"refundState":"1","pointListService":{"age":"35","nickname":"九月茉莉","sex":1,"avatar":"http://t1.27270.com/uploads/tu/201811/213/98eb656674.jpg","occupation":"教师"},"serviceUsers":[{"orderServiceNo":"S201812200718140149423","serviceUserId":3266,"age":"10","nickname":"┆任δ乎吸野мαη┆","sex":2,"avatar":"http://t1.27270.com/uploads/tu/201811/232/5f4adf133b.jpg","occupation":"律师","receiveTime":"2018-12-21 16:23:05","arriveTime":"2018-12-21 16:23:37","serviceStartTime":"1993-08-21 00:00:00","serviceEndTime":"1993-08-21 00:00:00","estimateArriveTime":"2018-12-21-20:00:00","longitude":"104.06675666570663","latitude":"30.65027282452079","price":800,"serviceState":2,"rongToken":"siXDhorPgMrJCD5CSSt4Spyg5jbxEw+spmsK1z3sj1oqYDNLqE5klG3DOXx0vTrKZoUe+l0HosxN+dQSNrgONQ==","waitPayServiceTime":300,"serviceStartCountdown":600,"isStationing":"1","isLate":"1","refundState":"1","complaintsId":1,"complaintsState":0}],"orderWine":{"firstWine":{"wines":[{"wineId":31,"num":100,"wineTypeName":"酒水套餐","wineTypeId":7,"wineName":"迷情巴西","wineImage":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineUnit":"套","wineSpecifications":"500ML","isWineSet":1,"wineCountPrice":66600}],"gift":{"orderGifId":2,"businessGiftId":1,"wines":[{"num":5,"wineName":"茅台","wineImage":"http://pic-cdn.35pic.com/58pic/19/04/39/56731f4ba7466_1024.jpg","wineUnit":"瓶","wineSpecifications":"500ML","isWineSet":0}]}},"appendWines":[{"createTime":"2019-03-12","wines":[{"wineId":31,"num":100,"wineTypeName":"酒水套餐","wineTypeId":7,"wineName":"迷情巴西","wineImage":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineUnit":"套","wineSpecifications":"500ML","isWineSet":1,"wineCountPrice":66600}],"gift":{"orderGifId":1,"businessGiftId":2,"wines":[{"num":5,"wineName":"茅台","wineImage":"http://pic-cdn.35pic.com/58pic/19/04/39/56731f4ba7466_1024.jpg","wineUnit":"瓶","wineSpecifications":"500ML","isWineSet":0}]}}]},"referencesUser":{"serviceUserId":"3265","age":"10","nickname":"了那寂静的伤","sex":2,"avatar":"http://t2.hddhhn.com/uploads/tu/201810/9999/762cc174c6.jpg","occupation":"教师"}}
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
         * orderState : 1
         * orderNo : O201810260335521454603
         * businessId : 1
         * businessName : 好乐星KTV(南门店)
         * address : 成都市金牛区沙湾路1号汇龙湾广场1楼（一环路口）
         * longitude : 104.06
         * latitude : 30.67
         * businessImg : http://t1.27270.com/uploads/tu/201811/213/98eb656674.jpg
         * boxTypeName : 豪包
         * boxName : k666
         * businessPhone : 02865062777
         * startTime : 1993-08-21 00:00:00
         * endTime : 2018-12-21 18:29:20
         * orderTakingNum : 3
         * serviceCountPrice : 2400
         * wineCountPrice : 42880
         * couponPrice : 1400
         * activityDeductionPrice : 1200
         * orderCountPrice : 43880
         * boxServiceMoney : 800
         * waitPaymentTime : 3567
         * refundState : 1
         * pointListService : {"age":"35","nickname":"九月茉莉","sex":1,"avatar":"http://t1.27270.com/uploads/tu/201811/213/98eb656674.jpg","occupation":"教师"}
         * serviceUsers : [{"orderServiceNo":"S201812200718140149423","serviceUserId":3266,"age":"10","nickname":"┆任δ乎吸野мαη┆","sex":2,"avatar":"http://t1.27270.com/uploads/tu/201811/232/5f4adf133b.jpg","occupation":"律师","receiveTime":"2018-12-21 16:23:05","arriveTime":"2018-12-21 16:23:37","serviceStartTime":"1993-08-21 00:00:00","serviceEndTime":"1993-08-21 00:00:00","estimateArriveTime":"2018-12-21-20:00:00","longitude":"104.06675666570663","latitude":"30.65027282452079","price":800,"serviceState":2,"rongToken":"siXDhorPgMrJCD5CSSt4Spyg5jbxEw+spmsK1z3sj1oqYDNLqE5klG3DOXx0vTrKZoUe+l0HosxN+dQSNrgONQ==","waitPayServiceTime":300,"serviceStartCountdown":600,"isStationing":"1","isLate":"1","refundState":"1","complaintsId":1,"complaintsState":0}]
         * orderWine : {"firstWine":{"wines":[{"wineId":31,"num":100,"wineTypeName":"酒水套餐","wineTypeId":7,"wineName":"迷情巴西","wineImage":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineUnit":"套","wineSpecifications":"500ML","isWineSet":1,"wineCountPrice":66600}],"gift":{"orderGifId":2,"businessGiftId":1,"wines":[{"num":5,"wineName":"茅台","wineImage":"http://pic-cdn.35pic.com/58pic/19/04/39/56731f4ba7466_1024.jpg","wineUnit":"瓶","wineSpecifications":"500ML","isWineSet":0}]}},"appendWines":[{"createTime":"2019-03-12","wines":[{"wineId":31,"num":100,"wineTypeName":"酒水套餐","wineTypeId":7,"wineName":"迷情巴西","wineImage":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineUnit":"套","wineSpecifications":"500ML","isWineSet":1,"wineCountPrice":66600}],"gift":{"orderGifId":1,"businessGiftId":2,"wines":[{"num":5,"wineName":"茅台","wineImage":"http://pic-cdn.35pic.com/58pic/19/04/39/56731f4ba7466_1024.jpg","wineUnit":"瓶","wineSpecifications":"500ML","isWineSet":0}]}}]}
         * referencesUser : {"serviceUserId":"3265","age":"10","nickname":"了那寂静的伤","sex":2,"avatar":"http://t2.hddhhn.com/uploads/tu/201810/9999/762cc174c6.jpg","occupation":"教师"}
         */

        private int orderState;
        private String orderNo;
        private int businessId;
        private String businessName;
        private String address;
        private String longitude;
        private String latitude;
        private String businessImg;
        private String boxTypeName;
        private String boxName;
        private String boxTypeId;
        private String boxId;
        private String businessPhone;
        private String startTime;
        private String endTime;
        private String createTime;
        private String reserveTime;
        private int orderTakingNum;
        private int serviceCountNum;
        private BigDecimal boxFreePrice=new BigDecimal("0.00");
        private BigDecimal serviceCountPrice=new BigDecimal("0.00");
        private BigDecimal wineCountPrice=new BigDecimal("0.00");
        private BigDecimal couponPrice=new BigDecimal("0.00");
        private BigDecimal activityDeductionPrice=new BigDecimal("0.00");
        private BigDecimal orderCountPrice=new BigDecimal("0.00");
        private BigDecimal boxServiceMoney=new BigDecimal("0.00");
        private BigDecimal nowBoxServiceMoney=new BigDecimal("0.00");
        private int waitPaymentTime;
        private String refundState;
        private String platformPhone;
        private String hasMaster;
        private int hasWaitServiceAccept;
        private PointListServiceBean pointListService;
        private OrderWineBean orderWine;
        private ReferencesUserBean referencesUser;
        private List<ServiceUsersBean> serviceUsers;
        private List<AllServiceUsersBean> allServiceUsers;
        private String usedServiceCoupon;

        public String getReserveTime() {
            return reserveTime;
        }

        public void setReserveTime(String reserveTime) {
            this.reserveTime = reserveTime;
        }

        public int getServiceCountNum() {
            return serviceCountNum;
        }

        public void setServiceCountNum(int serviceCountNum) {
            this.serviceCountNum = serviceCountNum;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUsedServiceCoupon() {
            return usedServiceCoupon;
        }

        public void setUsedServiceCoupon(String usedServiceCoupon) {
            this.usedServiceCoupon = usedServiceCoupon;
        }

        public BigDecimal getNowBoxServiceMoney() {
            return nowBoxServiceMoney;
        }

        public void setNowBoxServiceMoney(BigDecimal nowBoxServiceMoney) {
            this.nowBoxServiceMoney = nowBoxServiceMoney;
        }

        public int getHasWaitServiceAccept() {
            return hasWaitServiceAccept;
        }

        public void setHasWaitServiceAccept(int hasWaitServiceAccept) {
            this.hasWaitServiceAccept = hasWaitServiceAccept;
        }

        public String getBoxTypeId() {
            return boxTypeId;
        }

        public void setBoxTypeId(String boxTypeId) {
            this.boxTypeId = boxTypeId;
        }

        public String getBoxId() {
            return boxId;
        }

        public void setBoxId(String boxId) {
            this.boxId = boxId;
        }

        public BigDecimal getBoxFreePrice() {
            return boxFreePrice;
        }

        public void setBoxFreePrice(BigDecimal boxFreePrice) {
            this.boxFreePrice = boxFreePrice;
        }

        public List<AllServiceUsersBean> getAllServiceUsers() {
            return allServiceUsers;
        }

        public void setAllServiceUsers(List<AllServiceUsersBean> allServiceUsers) {
            this.allServiceUsers = allServiceUsers;
        }

        public String getHasMaster() {
            return hasMaster;
        }

        public void setHasMaster(String hasMaster) {
            this.hasMaster = hasMaster;
        }

        public String getPlatformPhone() {
            return platformPhone;
        }

        public void setPlatformPhone(String platformPhone) {
            this.platformPhone = platformPhone;
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

        public String getBusinessPhone() {
            return businessPhone;
        }

        public void setBusinessPhone(String businessPhone) {
            this.businessPhone = businessPhone;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getOrderTakingNum() {
            return orderTakingNum;
        }

        public void setOrderTakingNum(int orderTakingNum) {
            this.orderTakingNum = orderTakingNum;
        }

        public BigDecimal getServiceCountPrice() {
            return serviceCountPrice;
        }

        public void setServiceCountPrice(BigDecimal serviceCountPrice) {
            this.serviceCountPrice = serviceCountPrice;
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

        public int getWaitPaymentTime() {
            return waitPaymentTime;
        }

        public void setWaitPaymentTime(int waitPaymentTime) {
            this.waitPaymentTime = waitPaymentTime;
        }

        public String getRefundState() {
            return refundState;
        }

        public void setRefundState(String refundState) {
            this.refundState = refundState;
        }

        public PointListServiceBean getPointListService() {
            return pointListService;
        }

        public void setPointListService(PointListServiceBean pointListService) {
            this.pointListService = pointListService;
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

        public static class PointListServiceBean {
            /**
             * age : 35
             * nickname : 九月茉莉
             * sex : 1
             * avatar : http://t1.27270.com/uploads/tu/201811/213/98eb656674.jpg
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

        public static class OrderWineBean {
            /**
             * firstWine : {"wines":[{"wineId":31,"num":100,"wineTypeName":"酒水套餐","wineTypeId":7,"wineName":"迷情巴西","wineImage":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineUnit":"套","wineSpecifications":"500ML","isWineSet":1,"wineCountPrice":66600}],"gift":{"orderGifId":2,"businessGiftId":1,"wines":[{"num":5,"wineName":"茅台","wineImage":"http://pic-cdn.35pic.com/58pic/19/04/39/56731f4ba7466_1024.jpg","wineUnit":"瓶","wineSpecifications":"500ML","isWineSet":0}]}}
             * appendWines : [{"createTime":"2019-03-12","wines":[{"wineId":31,"num":100,"wineTypeName":"酒水套餐","wineTypeId":7,"wineName":"迷情巴西","wineImage":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineUnit":"套","wineSpecifications":"500ML","isWineSet":1,"wineCountPrice":66600}],"gift":{"orderGifId":1,"businessGiftId":2,"wines":[{"num":5,"wineName":"茅台","wineImage":"http://pic-cdn.35pic.com/58pic/19/04/39/56731f4ba7466_1024.jpg","wineUnit":"瓶","wineSpecifications":"500ML","isWineSet":0}]}}]
             */

            private FirstWineBean firstWine;
            private List<AppendWinesBean> appendWines;

            public FirstWineBean getFirstWine() {
                return firstWine;
            }

            public void setFirstWine(FirstWineBean firstWine) {
                this.firstWine = firstWine;
            }

            public List<AppendWinesBean> getAppendWines() {
                return appendWines;
            }

            public void setAppendWines(List<AppendWinesBean> appendWines) {
                this.appendWines = appendWines;
            }

            public static class FirstWineBean {
                /**
                 * wines : [{"wineId":31,"num":100,"wineTypeName":"酒水套餐","wineTypeId":7,"wineName":"迷情巴西","wineImage":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineUnit":"套","wineSpecifications":"500ML","isWineSet":1,"wineCountPrice":66600}]
                 * gift : {"orderGifId":2,"businessGiftId":1,"wines":[{"num":5,"wineName":"茅台","wineImage":"http://pic-cdn.35pic.com/58pic/19/04/39/56731f4ba7466_1024.jpg","wineUnit":"瓶","wineSpecifications":"500ML","isWineSet":0}]}
                 */

                private GiftBean gift;
                private List<WinesBeanX> wines;

                public GiftBean getGift() {
                    return gift;
                }

                public void setGift(GiftBean gift) {
                    this.gift = gift;
                }

                public List<WinesBeanX> getWines() {
                    return wines;
                }

                public void setWines(List<WinesBeanX> wines) {
                    this.wines = wines;
                }

                public static class GiftBean {
                    /**
                     * orderGifId : 2
                     * businessGiftId : 1
                     * wines : [{"num":5,"wineName":"茅台","wineImage":"http://pic-cdn.35pic.com/58pic/19/04/39/56731f4ba7466_1024.jpg","wineUnit":"瓶","wineSpecifications":"500ML","isWineSet":0}]
                     */

                    private int orderGifId;
                    private int businessGiftId;
                    private List<WinesBean> wines;

                    public int getOrderGifId() {
                        return orderGifId;
                    }

                    public void setOrderGifId(int orderGifId) {
                        this.orderGifId = orderGifId;
                    }

                    public int getBusinessGiftId() {
                        return businessGiftId;
                    }

                    public void setBusinessGiftId(int businessGiftId) {
                        this.businessGiftId = businessGiftId;
                    }

                    public List<WinesBean> getWines() {
                        return wines;
                    }

                    public void setWines(List<WinesBean> wines) {
                        this.wines = wines;
                    }

                    public static class WinesBean {
                        /**
                         * num : 5
                         * wineName : 茅台
                         * wineImage : http://pic-cdn.35pic.com/58pic/19/04/39/56731f4ba7466_1024.jpg
                         * wineUnit : 瓶
                         * wineSpecifications : 500ML
                         * isWineSet : 0
                         */

                        private int num;
                        private String wineName;
                        private String wineImage;
                        private String wineUnit;
                        private String wineSpecifications;
                        private int isWineSet;

                        public int getNum() {
                            return num;
                        }

                        public void setNum(int num) {
                            this.num = num;
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

                        public String getWineUnit() {
                            return wineUnit;
                        }

                        public void setWineUnit(String wineUnit) {
                            this.wineUnit = wineUnit;
                        }

                        public String getWineSpecifications() {
                            return wineSpecifications;
                        }

                        public void setWineSpecifications(String wineSpecifications) {
                            this.wineSpecifications = wineSpecifications;
                        }

                        public int getIsWineSet() {
                            return isWineSet;
                        }

                        public void setIsWineSet(int isWineSet) {
                            this.isWineSet = isWineSet;
                        }
                    }
                }

                public static class WinesBeanX {
                    /**
                     * wineId : 31
                     * num : 100
                     * wineTypeName : 酒水套餐
                     * wineTypeId : 7
                     * wineName : 迷情巴西
                     * wineImage : https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg
                     * wineUnit : 套
                     * wineSpecifications : 500ML
                     * isWineSet : 1
                     * wineCountPrice : 66600
                     */

                    private int wineId;
                    private int num;
                    private String wineTypeName;
                    private int wineTypeId;
                    private String wineName;
                    private String wineImage;
                    private String wineUnit;
                    private String wineSpecifications;
                    private int isWineSet;
                    private BigDecimal wineCountPrice=new BigDecimal("0.00");

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

                    public String getWineUnit() {
                        return wineUnit;
                    }

                    public void setWineUnit(String wineUnit) {
                        this.wineUnit = wineUnit;
                    }

                    public String getWineSpecifications() {
                        return wineSpecifications;
                    }

                    public void setWineSpecifications(String wineSpecifications) {
                        this.wineSpecifications = wineSpecifications;
                    }

                    public int getIsWineSet() {
                        return isWineSet;
                    }

                    public void setIsWineSet(int isWineSet) {
                        this.isWineSet = isWineSet;
                    }

                    public BigDecimal getWineCountPrice() {
                        return wineCountPrice;
                    }

                    public void setWineCountPrice(BigDecimal wineCountPrice) {
                        this.wineCountPrice = wineCountPrice;
                    }
                }
            }

            public static class AppendWinesBean {
                /**
                 * createTime : 2019-03-12
                 * wines : [{"wineId":31,"num":100,"wineTypeName":"酒水套餐","wineTypeId":7,"wineName":"迷情巴西","wineImage":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineUnit":"套","wineSpecifications":"500ML","isWineSet":1,"wineCountPrice":66600}]
                 * gift : {"orderGifId":1,"businessGiftId":2,"wines":[{"num":5,"wineName":"茅台","wineImage":"http://pic-cdn.35pic.com/58pic/19/04/39/56731f4ba7466_1024.jpg","wineUnit":"瓶","wineSpecifications":"500ML","isWineSet":0}]}
                 */

                private String createTime;
                private GiftBeanX gift;
                private List<WinesBeanXXX> wines;

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public GiftBeanX getGift() {
                    return gift;
                }

                public void setGift(GiftBeanX gift) {
                    this.gift = gift;
                }

                public List<WinesBeanXXX> getWines() {
                    return wines;
                }

                public void setWines(List<WinesBeanXXX> wines) {
                    this.wines = wines;
                }

                public static class GiftBeanX {
                    /**
                     * orderGifId : 1
                     * businessGiftId : 2
                     * wines : [{"num":5,"wineName":"茅台","wineImage":"http://pic-cdn.35pic.com/58pic/19/04/39/56731f4ba7466_1024.jpg","wineUnit":"瓶","wineSpecifications":"500ML","isWineSet":0}]
                     */

                    private int orderGifId;
                    private int businessGiftId;
                    private List<WinesBeanXX> wines;

                    public int getOrderGifId() {
                        return orderGifId;
                    }

                    public void setOrderGifId(int orderGifId) {
                        this.orderGifId = orderGifId;
                    }

                    public int getBusinessGiftId() {
                        return businessGiftId;
                    }

                    public void setBusinessGiftId(int businessGiftId) {
                        this.businessGiftId = businessGiftId;
                    }

                    public List<WinesBeanXX> getWines() {
                        return wines;
                    }

                    public void setWines(List<WinesBeanXX> wines) {
                        this.wines = wines;
                    }

                    public static class WinesBeanXX {
                        /**
                         * num : 5
                         * wineName : 茅台
                         * wineImage : http://pic-cdn.35pic.com/58pic/19/04/39/56731f4ba7466_1024.jpg
                         * wineUnit : 瓶
                         * wineSpecifications : 500ML
                         * isWineSet : 0
                         */

                        private int num;
                        private String wineName;
                        private String wineImage;
                        private String wineUnit;
                        private String wineSpecifications;
                        private int isWineSet;

                        public int getNum() {
                            return num;
                        }

                        public void setNum(int num) {
                            this.num = num;
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

                        public String getWineUnit() {
                            return wineUnit;
                        }

                        public void setWineUnit(String wineUnit) {
                            this.wineUnit = wineUnit;
                        }

                        public String getWineSpecifications() {
                            return wineSpecifications;
                        }

                        public void setWineSpecifications(String wineSpecifications) {
                            this.wineSpecifications = wineSpecifications;
                        }

                        public int getIsWineSet() {
                            return isWineSet;
                        }

                        public void setIsWineSet(int isWineSet) {
                            this.isWineSet = isWineSet;
                        }
                    }
                }

                public static class WinesBeanXXX {
                    /**
                     * wineId : 31
                     * num : 100
                     * wineTypeName : 酒水套餐
                     * wineTypeId : 7
                     * wineName : 迷情巴西
                     * wineImage : https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg
                     * wineUnit : 套
                     * wineSpecifications : 500ML
                     * isWineSet : 1
                     * wineCountPrice : 66600
                     */

                    private int wineId;
                    private int num;
                    private String wineTypeName;
                    private int wineTypeId;
                    private String wineName;
                    private String wineImage;
                    private String wineUnit;
                    private String wineSpecifications;
                    private int isWineSet;
                    private BigDecimal wineCountPrice=new BigDecimal("0.00");

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

                    public String getWineUnit() {
                        return wineUnit;
                    }

                    public void setWineUnit(String wineUnit) {
                        this.wineUnit = wineUnit;
                    }

                    public String getWineSpecifications() {
                        return wineSpecifications;
                    }

                    public void setWineSpecifications(String wineSpecifications) {
                        this.wineSpecifications = wineSpecifications;
                    }

                    public int getIsWineSet() {
                        return isWineSet;
                    }

                    public void setIsWineSet(int isWineSet) {
                        this.isWineSet = isWineSet;
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
             * serviceUserId : 3265
             * age : 10
             * nickname : 了那寂静的伤
             * sex : 2
             * avatar : http://t2.hddhhn.com/uploads/tu/201810/9999/762cc174c6.jpg
             * occupation : 教师
             */

            private String serviceUserId;
            private String age;
            private String nickname;
            private int sex;
            private String avatar;
            private String occupation;

            public String getServiceUserId() {
                return serviceUserId;
            }

            public void setServiceUserId(String serviceUserId) {
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
        }

        public static class ServiceUsersBean {
            /**
             * orderServiceNo : S201812200718140149423
             * serviceUserId : 3266
             * age : 10
             * nickname : ┆任δ乎吸野мαη┆
             * sex : 2
             * avatar : http://t1.27270.com/uploads/tu/201811/232/5f4adf133b.jpg
             * occupation : 律师
             * receiveTime : 2018-12-21 16:23:05
             * arriveTime : 2018-12-21 16:23:37
             * serviceStartTime : 1993-08-21 00:00:00
             * serviceEndTime : 1993-08-21 00:00:00
             * estimateArriveTime : 2018-12-21-20:00:00
             * longitude : 104.06675666570663
             * latitude : 30.65027282452079
             * price : 800
             * serviceState : 2
             * rongToken : siXDhorPgMrJCD5CSSt4Spyg5jbxEw+spmsK1z3sj1oqYDNLqE5klG3DOXx0vTrKZoUe+l0HosxN+dQSNrgONQ==
             * waitPayServiceTime : 300
             * serviceStartCountdown : 600
             * isStationing : 1
             * isLate : 1
             * refundState : 1
             * complaintsId : 1
             * complaintsState : 0
             */

            private String orderServiceNo;
            private int serviceUserId;
            private String age;
            private String nickname;
            private int sex;
            private String avatar;
            private String occupation;
            private String receiveTime;
            private String arriveTime;
            private String serviceStartTime;
            private String serviceEndTime;
            private String estimateArriveTime;
            private String longitude;
            private String latitude;
            private BigDecimal price;
            private int serviceState;
            private String rongToken;
            private Long waitPayServiceTime;
            private Long serviceStartCountdown;
            private String isStationing;
            private String isLate;
            private String refundState;
            private int complaintsId;
            private String complaintsState;
            private boolean isType;
            private Long serviceCanRefuseTime;

            public Long getServiceCanRefuseTime() {
                return serviceCanRefuseTime;
            }

            public void setServiceCanRefuseTime(Long serviceCanRefuseTime) {
                this.serviceCanRefuseTime = serviceCanRefuseTime;
            }

            public ServiceUsersBean() {
            }

            public ServiceUsersBean(int serviceUserId, String age, String nickname, int sex, String avatar, String occupation, boolean isType) {
                this.serviceUserId = serviceUserId;
                this.age = age;
                this.nickname = nickname;
                this.sex = sex;
                this.avatar = avatar;
                this.occupation = occupation;
                this.isType = isType;
            }

            public ServiceUsersBean(int serviceUserId, String age, String nickname, int sex, String avatar, String occupation, int serviceState, boolean isType,String isStationing) {
                this.serviceUserId = serviceUserId;
                this.age = age;
                this.nickname = nickname;
                this.sex = sex;
                this.avatar = avatar;
                this.occupation = occupation;
                this.serviceState = serviceState;
                this.isType = isType;
                this.isStationing=isStationing;
            }

            public boolean isType() {
                return isType;
            }

            public void setType(boolean type) {
                isType = type;
            }

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

            public String getReceiveTime() {
                return receiveTime;
            }

            public void setReceiveTime(String receiveTime) {
                this.receiveTime = receiveTime;
            }

            public String getArriveTime() {
                return arriveTime;
            }

            public void setArriveTime(String arriveTime) {
                this.arriveTime = arriveTime;
            }

            public String getServiceStartTime() {
                return serviceStartTime;
            }

            public void setServiceStartTime(String serviceStartTime) {
                this.serviceStartTime = serviceStartTime;
            }

            public String getServiceEndTime() {
                return serviceEndTime;
            }

            public void setServiceEndTime(String serviceEndTime) {
                this.serviceEndTime = serviceEndTime;
            }

            public String getEstimateArriveTime() {
                return estimateArriveTime;
            }

            public void setEstimateArriveTime(String estimateArriveTime) {
                this.estimateArriveTime = estimateArriveTime;
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

            public Long getWaitPayServiceTime() {
                return waitPayServiceTime;
            }

            public void setWaitPayServiceTime(Long waitPayServiceTime) {
                this.waitPayServiceTime = waitPayServiceTime;
            }

            public Long getServiceStartCountdown() {
                return serviceStartCountdown;
            }

            public void setServiceStartCountdown(Long serviceStartCountdown) {
                this.serviceStartCountdown = serviceStartCountdown;
            }

            public String getIsStationing() {
                return isStationing;
            }

            public void setIsStationing(String isStationing) {
                this.isStationing = isStationing;
            }

            public String getIsLate() {
                return isLate;
            }

            public void setIsLate(String isLate) {
                this.isLate = isLate;
            }

            public String getRefundState() {
                return refundState;
            }

            public void setRefundState(String refundState) {
                this.refundState = refundState;
            }

            public int getComplaintsId() {
                return complaintsId;
            }

            public void setComplaintsId(int complaintsId) {
                this.complaintsId = complaintsId;
            }

            public String getComplaintsState() {
                return complaintsState;
            }

            public void setComplaintsState(String complaintsState) {
                this.complaintsState = complaintsState;
            }
        }

        public static class AllServiceUsersBean{
            /**
             * serviceUserId : 3288
             * age : 36
             * nickname : 芫
             * sex : 2
             * avatar : http://pic1.win4000.com/pic/b/62/aaa31505336_250_350.jpg
             * occupation : 自由职业
             * price : 800
             */

            private int serviceUserId;
            private String age;
            private String nickname;
            private int sex;
            private String avatar;
            private String occupation;
            private double price;

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

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }


        }
    }
}
