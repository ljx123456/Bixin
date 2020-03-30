package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class WineCodeBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"orderNo":"R19031800001111A","businessName":"蜂巢ktv","boxTypeName":"豪包","boxName":"kkk","wineTypes":[{"wineTypeId":13,"wineTypeName":"酒水套餐","isDetails":1,"wines":[{"businessWineId":51,"businessWineName":"情迷巴西","businessWinePrice":1888,"businessWineImg":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548686654258&di=23523b6be3bdaa3256351f7e58a23361&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fbainuo%2Fwh%3D470%2C285%2Fsign%3D8628a35205e939015657853a4cdc78d5%2Fa8ec8a13632762d00df2bfcda4ec08fa503dc6f0.jpg","businessWineUnit":"套","businessWineDetails":"茅台,百威啤酒,Martell","wineNum":"3"}]},{"wineTypeId":14,"wineTypeName":"白酒","isDetails":0,"wines":[{"businessWineId":52,"businessWineName":"茅台","businessWinePrice":888,"businessWineImg":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","businessWineUnit":"瓶","businessWineSpecifications":"500ML","wineNum":"2"}]}]}
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
         * orderNo : R19031800001111A
         * businessName : 蜂巢ktv
         * boxTypeName : 豪包
         * boxName : kkk
         * wineTypes : [{"wineTypeId":13,"wineTypeName":"酒水套餐","isDetails":1,"wines":[{"businessWineId":51,"businessWineName":"情迷巴西","businessWinePrice":1888,"businessWineImg":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548686654258&di=23523b6be3bdaa3256351f7e58a23361&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fbainuo%2Fwh%3D470%2C285%2Fsign%3D8628a35205e939015657853a4cdc78d5%2Fa8ec8a13632762d00df2bfcda4ec08fa503dc6f0.jpg","businessWineUnit":"套","businessWineDetails":"茅台,百威啤酒,Martell","wineNum":"3"}]},{"wineTypeId":14,"wineTypeName":"白酒","isDetails":0,"wines":[{"businessWineId":52,"businessWineName":"茅台","businessWinePrice":888,"businessWineImg":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","businessWineUnit":"瓶","businessWineSpecifications":"500ML","wineNum":"2"}]}]
         */

        private String orderNo;
        private String businessName;
        private String boxTypeName;
        private String boxName;
        private String businessId;
        private List<WineTypesBean> wineTypes;

        public String getBusinessId() {
            return businessId;
        }

        public void setBusinessId(String businessId) {
            this.businessId = businessId;
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

        public List<WineTypesBean> getWineTypes() {
            return wineTypes;
        }

        public void setWineTypes(List<WineTypesBean> wineTypes) {
            this.wineTypes = wineTypes;
        }

        public static class WineTypesBean {
            /**
             * wineTypeId : 13
             * wineTypeName : 酒水套餐
             * isDetails : 1
             * wines : [{"businessWineId":51,"businessWineName":"情迷巴西","businessWinePrice":1888,"businessWineImg":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548686654258&di=23523b6be3bdaa3256351f7e58a23361&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fbainuo%2Fwh%3D470%2C285%2Fsign%3D8628a35205e939015657853a4cdc78d5%2Fa8ec8a13632762d00df2bfcda4ec08fa503dc6f0.jpg","businessWineUnit":"套","businessWineDetails":"茅台,百威啤酒,Martell","wineNum":"3"}]
             */

            private int wineTypeId;
            private String wineTypeName;
            private int isDetails;
            private List<WinesBean> wines;

            public int getWineTypeId() {
                return wineTypeId;
            }

            public void setWineTypeId(int wineTypeId) {
                this.wineTypeId = wineTypeId;
            }

            public String getWineTypeName() {
                return wineTypeName;
            }

            public void setWineTypeName(String wineTypeName) {
                this.wineTypeName = wineTypeName;
            }

            public int getIsDetails() {
                return isDetails;
            }

            public void setIsDetails(int isDetails) {
                this.isDetails = isDetails;
            }

            public List<WinesBean> getWines() {
                return wines;
            }

            public void setWines(List<WinesBean> wines) {
                this.wines = wines;
            }

            public static class WinesBean {
                /**
                 * businessWineId : 51
                 * businessWineName : 情迷巴西
                 * businessWinePrice : 1888
                 * businessWineImg : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548686654258&di=23523b6be3bdaa3256351f7e58a23361&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fbainuo%2Fwh%3D470%2C285%2Fsign%3D8628a35205e939015657853a4cdc78d5%2Fa8ec8a13632762d00df2bfcda4ec08fa503dc6f0.jpg
                 * businessWineUnit : 套
                 * businessWineDetails : 茅台,百威啤酒,Martell
                 * wineNum : 3
                 */

                private int businessWineId;
                private String businessWineName;
                private BigDecimal businessWinePrice=new BigDecimal(0.00);
                private String businessWineImg;
                private String businessWineUnit;
                private String businessWineDetails;
                private String wineNum;

                public int getBusinessWineId() {
                    return businessWineId;
                }

                public void setBusinessWineId(int businessWineId) {
                    this.businessWineId = businessWineId;
                }

                public String getBusinessWineName() {
                    return businessWineName;
                }

                public void setBusinessWineName(String businessWineName) {
                    this.businessWineName = businessWineName;
                }

                public BigDecimal getBusinessWinePrice() {
                    return businessWinePrice;
                }

                public void setBusinessWinePrice(BigDecimal businessWinePrice) {
                    this.businessWinePrice = businessWinePrice;
                }

                public String getBusinessWineImg() {
                    return businessWineImg;
                }

                public void setBusinessWineImg(String businessWineImg) {
                    this.businessWineImg = businessWineImg;
                }

                public String getBusinessWineUnit() {
                    return businessWineUnit;
                }

                public void setBusinessWineUnit(String businessWineUnit) {
                    this.businessWineUnit = businessWineUnit;
                }

                public String getBusinessWineDetails() {
                    return businessWineDetails;
                }

                public void setBusinessWineDetails(String businessWineDetails) {
                    this.businessWineDetails = businessWineDetails;
                }

                public String getWineNum() {
                    return wineNum;
                }

                public void setWineNum(String wineNum) {
                    this.wineNum = wineNum;
                }
            }
        }
    }
}
