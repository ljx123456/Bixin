package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class DrinkDetailsBean {

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
         * wineInfo : {"businessWineId":1,"businessWineName":"情迷巴西","businessWinePrice":100}
         * wineDetailsInfo : [{"wineNum":"1打","wineName":"百威"},{"wineNum":"2份","wineName":"水果拼盘"},{"wineNum":"2份","wineName":"芳草香草瓜子"}]
         */

        private WineInfoBean wineInfo;
        private List<WineDetailsInfoBean> wineDetailsInfo;

        public WineInfoBean getWineInfo() {
            return wineInfo;
        }

        public void setWineInfo(WineInfoBean wineInfo) {
            this.wineInfo = wineInfo;
        }

        public List<WineDetailsInfoBean> getWineDetailsInfo() {
            return wineDetailsInfo;
        }

        public void setWineDetailsInfo(List<WineDetailsInfoBean> wineDetailsInfo) {
            this.wineDetailsInfo = wineDetailsInfo;
        }

        public static class WineInfoBean {
            /**
             * businessWineId : 1
             * businessWineName : 情迷巴西
             * businessWinePrice : 100
             */

            private int businessWineId;
            private String businessWineName;
            private BigDecimal businessWinePrice=new BigDecimal(0.00);

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
        }

        public static class WineDetailsInfoBean {
            /**
             * wineNum : 1打
             * wineName : 百威
             */

            private String wineNum;
            private String wineName;
            private String businessWineUnit;
            private String businessWineSpecifications;

            public WineDetailsInfoBean(String wineNum, String wineName, String businessWineUnit, String businessWineSpecifications) {
                this.wineNum = wineNum;
                this.wineName = wineName;
                this.businessWineUnit = businessWineUnit;
                this.businessWineSpecifications = businessWineSpecifications;
            }

            public String getBusinessWineUnit() {
                return businessWineUnit;
            }

            public void setBusinessWineUnit(String businessWineUnit) {
                this.businessWineUnit = businessWineUnit;
            }

            public String getBusinessWineSpecifications() {
                return businessWineSpecifications;
            }

            public void setBusinessWineSpecifications(String businessWineSpecifications) {
                this.businessWineSpecifications = businessWineSpecifications;
            }

            public String getWineNum() {
                return wineNum;
            }

            public void setWineNum(String wineNum) {
                this.wineNum = wineNum;
            }

            public String getWineName() {
                return wineName;
            }

            public void setWineName(String wineName) {
                this.wineName = wineName;
            }
        }
    }
}
