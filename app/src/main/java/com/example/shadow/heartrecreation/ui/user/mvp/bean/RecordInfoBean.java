package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.util.List;

public class RecordInfoBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"wineInfo":[{"wineTypeName":"啤酒","wines":[{"wineName":"百威啤酒","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineNum":"1","wineSpecifications":"500ML","wineUnit":"瓶","wineSurplusTime":"10天"}]}],"businessInfo":{"businessId":1,"businessName":"好乐星KTV(南门店)","businessAddress":"成都市武侯区人民南路四段53号附1号(近肿瘤医院)","longitude":"104.058566","latitude":"30.701084"},"createTime":"2019-03-16 10:14:30"}
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
         * wineInfo : [{"wineTypeName":"啤酒","wines":[{"wineName":"百威啤酒","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineNum":"1","wineSpecifications":"500ML","wineUnit":"瓶","wineSurplusTime":"10天"}]}]
         * businessInfo : {"businessId":1,"businessName":"好乐星KTV(南门店)","businessAddress":"成都市武侯区人民南路四段53号附1号(近肿瘤医院)","longitude":"104.058566","latitude":"30.701084"}
         * createTime : 2019-03-16 10:14:30
         */

        private BusinessInfoBean businessInfo;
        private String createTime;
        private List<WineInfoBean> wineInfo;

        public BusinessInfoBean getBusinessInfo() {
            return businessInfo;
        }

        public void setBusinessInfo(BusinessInfoBean businessInfo) {
            this.businessInfo = businessInfo;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public List<WineInfoBean> getWineInfo() {
            return wineInfo;
        }

        public void setWineInfo(List<WineInfoBean> wineInfo) {
            this.wineInfo = wineInfo;
        }

        public static class BusinessInfoBean {
            /**
             * businessId : 1
             * businessName : 好乐星KTV(南门店)
             * businessAddress : 成都市武侯区人民南路四段53号附1号(近肿瘤医院)
             * longitude : 104.058566
             * latitude : 30.701084
             */

            private int businessId;
            private String businessName;
            private String businessAddress;
            private String longitude;
            private String latitude;
            private String avatar;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
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
        }

        public static class WineInfoBean {
            /**
             * wineTypeName : 啤酒
             * wines : [{"wineName":"百威啤酒","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineNum":"1","wineSpecifications":"500ML","wineUnit":"瓶","wineSurplusTime":"10天"}]
             */

            private String wineTypeName;
            private List<WinesBean> wines;

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
                 * wineName : 百威啤酒
                 * wineAvatar : https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg
                 * wineNum : 1
                 * wineSpecifications : 500ML
                 * wineUnit : 瓶
                 * wineSurplusTime : 10天
                 */

                private String wineName;
                private String wineAvatar;
                private String wineNum;
                private String wineSpecifications;
                private String wineUnit;
                private String wineSurplusTime;

                public String getWineName() {
                    return wineName;
                }

                public void setWineName(String wineName) {
                    this.wineName = wineName;
                }

                public String getWineAvatar() {
                    return wineAvatar;
                }

                public void setWineAvatar(String wineAvatar) {
                    this.wineAvatar = wineAvatar;
                }

                public String getWineNum() {
                    return wineNum;
                }

                public void setWineNum(String wineNum) {
                    this.wineNum = wineNum;
                }

                public String getWineSpecifications() {
                    return wineSpecifications;
                }

                public void setWineSpecifications(String wineSpecifications) {
                    this.wineSpecifications = wineSpecifications;
                }

                public String getWineUnit() {
                    return wineUnit;
                }

                public void setWineUnit(String wineUnit) {
                    this.wineUnit = wineUnit;
                }

                public String getWineSurplusTime() {
                    return wineSurplusTime;
                }

                public void setWineSurplusTime(String wineSurplusTime) {
                    this.wineSurplusTime = wineSurplusTime;
                }
            }
        }
    }
}
