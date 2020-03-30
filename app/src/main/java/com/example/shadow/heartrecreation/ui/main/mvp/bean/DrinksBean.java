package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class DrinksBean {

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
         * wineTypes : {"wineTypeId":1,"wineTypeName":"酒水套餐","wines":[{"businessWineId":1,"businessWineName":"迷情巴西","businessWinePrice":2888,"businessWineImg":"http://e.hiphotos.baidu.com/bainuo/crop=0,21,690,418;w=470;q=80/sign=4776265fb5de9c82b22aa3cf51b1ac38/d53f8794a4c27d1e0735f9a21dd5ad6eddc43841.jpg","businessWineUnit":"1套","businessWineDetails":"红酒+小吃+可乐","state":1}]}
         */

        private WineTypesBean wineTypes;

        public WineTypesBean getWineTypes() {
            return wineTypes;
        }

        public void setWineTypes(WineTypesBean wineTypes) {
            this.wineTypes = wineTypes;
        }

        public static class WineTypesBean {
            /**
             * wineTypeId : 1
             * wineTypeName : 酒水套餐
             * wines : [{"businessWineId":1,"businessWineName":"迷情巴西","businessWinePrice":2888,"businessWineImg":"http://e.hiphotos.baidu.com/bainuo/crop=0,21,690,418;w=470;q=80/sign=4776265fb5de9c82b22aa3cf51b1ac38/d53f8794a4c27d1e0735f9a21dd5ad6eddc43841.jpg","businessWineUnit":"1套","businessWineDetails":"红酒+小吃+可乐","state":1}]
             */

            private int wineTypeId;
            private String wineTypeName;
            private int isDetails;
            private List<WinesBean> wines;

            public int getIsDetails() {
                return isDetails;
            }

            public void setIsDetails(int isDetails) {
                this.isDetails = isDetails;
            }

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

            public List<WinesBean> getWines() {
                return wines;
            }

            public void setWines(List<WinesBean> wines) {
                this.wines = wines;
            }

            public static class WinesBean {
                /**
                 * businessWineId : 1
                 * businessWineName : 迷情巴西
                 * businessWinePrice : 2888.0
                 * businessWineImg : http://e.hiphotos.baidu.com/bainuo/crop=0,21,690,418;w=470;q=80/sign=4776265fb5de9c82b22aa3cf51b1ac38/d53f8794a4c27d1e0735f9a21dd5ad6eddc43841.jpg
                 * businessWineUnit : 1套
                 * businessWineDetails : 红酒+小吃+可乐
                 * state : 1
                 */

                private int businessWineId;
                private String businessWineName;
                private BigDecimal businessWinePrice=new BigDecimal(0.00);
                private String businessWineImg;
                private String businessWineUnit;
                private String businessWineDetails;
                private String businessWineSpecifications;
                private int drinksNum = 0;
                private int state;

                public String getBusinessWineSpecifications() {
                    return businessWineSpecifications;
                }

                public void setBusinessWineSpecifications(String businessWineSpecifications) {
                    this.businessWineSpecifications = businessWineSpecifications;
                }

                public int getDrinksNum() {
                    return drinksNum;
                }

                public void setDrinksNum(int drinksNum) {
                    this.drinksNum = drinksNum;
                }

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

                public int getState() {
                    return state;
                }

                public void setState(int state) {
                    this.state = state;
                }
            }
        }
    }
}
