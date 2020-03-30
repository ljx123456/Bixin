package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.util.List;

public class RecordDetailsOneBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"wineInfo":[{"wineTypeName":"洋酒","wineTypeStorageTime":"20天","wines":[{"wineName":"Chivas","wineAvatar":"https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/crop%3D59%2C45%2C867%2C572%3Bc0%3Dbaike92%2C5%2C5%2C92%2C30/sign=56c3299bb6315c6057da31afb084f23f/ac345982b2b7d0a2bac98113c1ef76094b369a38.jpg","wineNum":1,"wineSpecifications":"500ML","wineUnit":"瓶"}]}],"businessInfo":{"businessId":5,"businessName":"wego纯kKTV(锦华万达店)","businessAddress":"成都市锦江区锦华路116号吉丰大厦1-3F","longitude":"104.096585","latitude":"30.620128"},"createTime":"2019-03-15 20:34:52"}
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
         * wineInfo : [{"wineTypeName":"洋酒","wineTypeStorageTime":"20天","wines":[{"wineName":"Chivas","wineAvatar":"https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/crop%3D59%2C45%2C867%2C572%3Bc0%3Dbaike92%2C5%2C5%2C92%2C30/sign=56c3299bb6315c6057da31afb084f23f/ac345982b2b7d0a2bac98113c1ef76094b369a38.jpg","wineNum":1,"wineSpecifications":"500ML","wineUnit":"瓶"}]}]
         * businessInfo : {"businessId":5,"businessName":"wego纯kKTV(锦华万达店)","businessAddress":"成都市锦江区锦华路116号吉丰大厦1-3F","longitude":"104.096585","latitude":"30.620128"}
         * createTime : 2019-03-15 20:34:52
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
             * businessId : 5
             * businessName : wego纯kKTV(锦华万达店)
             * businessAddress : 成都市锦江区锦华路116号吉丰大厦1-3F
             * longitude : 104.096585
             * latitude : 30.620128
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
             * wineTypeName : 洋酒
             * wineTypeStorageTime : 20天
             * wines : [{"wineName":"Chivas","wineAvatar":"https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/crop%3D59%2C45%2C867%2C572%3Bc0%3Dbaike92%2C5%2C5%2C92%2C30/sign=56c3299bb6315c6057da31afb084f23f/ac345982b2b7d0a2bac98113c1ef76094b369a38.jpg","wineNum":1,"wineSpecifications":"500ML","wineUnit":"瓶"}]
             */

            private String wineTypeName;
            private String wineTypeStorageTime;
            private List<WinesBean> wines;

            public String getWineTypeName() {
                return wineTypeName;
            }

            public void setWineTypeName(String wineTypeName) {
                this.wineTypeName = wineTypeName;
            }

            public String getWineTypeStorageTime() {
                return wineTypeStorageTime;
            }

            public void setWineTypeStorageTime(String wineTypeStorageTime) {
                this.wineTypeStorageTime = wineTypeStorageTime;
            }

            public List<WinesBean> getWines() {
                return wines;
            }

            public void setWines(List<WinesBean> wines) {
                this.wines = wines;
            }

            public static class WinesBean {
                /**
                 * wineName : Chivas
                 * wineAvatar : https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/crop%3D59%2C45%2C867%2C572%3Bc0%3Dbaike92%2C5%2C5%2C92%2C30/sign=56c3299bb6315c6057da31afb084f23f/ac345982b2b7d0a2bac98113c1ef76094b369a38.jpg
                 * wineNum : 1
                 * wineSpecifications : 500ML
                 * wineUnit : 瓶
                 */

                private String wineName;
                private String wineAvatar;
                private int wineNum;
                private String wineSpecifications;
                private String wineUnit;

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

                public int getWineNum() {
                    return wineNum;
                }

                public void setWineNum(int wineNum) {
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
            }
        }
    }
}
