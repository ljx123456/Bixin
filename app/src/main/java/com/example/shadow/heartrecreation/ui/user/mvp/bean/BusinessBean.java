package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.util.List;

public class BusinessBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"wineInfo":[{"wineTypeName":"白酒","wines":[{"wineName":"茅台","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineSurplus":1,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"22天","state":1},{"wineName":"茅台","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineSurplus":2,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"11天","state":1},{"wineName":"茅台","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineSurplus":2,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"20天","state":1}]},{"wineTypeName":"啤酒","wines":[{"wineName":"百威啤酒","wineAvatar":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548936354236&di=b21e061a336cbffde881340fd390da9a&imgtype=0&src=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F04%2F25%2Fb4695621345c.jpg","wineSurplus":19,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"7天","state":1},{"wineName":"雪花啤酒","wineAvatar":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineSurplus":15,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"26天","state":1},{"wineName":"百威啤酒","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineSurplus":13,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"8天","state":1},{"wineName":"雪花啤酒","wineAvatar":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineSurplus":10,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"8天","state":1},{"wineName":"百威啤酒","wineAvatar":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548936354236&di=b21e061a336cbffde881340fd390da9a&imgtype=0&src=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F04%2F25%2Fb4695621345c.jpg","wineSurplus":9,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"8天","state":1}]},{"wineTypeName":"洋酒","wines":[{"wineName":"Chivas","wineAvatar":"https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/crop%3D59%2C45%2C867%2C572%3Bc0%3Dbaike92%2C5%2C5%2C92%2C30/sign=56c3299bb6315c6057da31afb084f23f/ac345982b2b7d0a2bac98113c1ef76094b369a38.jpg","wineSurplus":0,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"15天","state":1}]}],"businessInfo":{"businessId":1,"businessName":"好乐星KTV(南门店)","businessAddress":"成都市武侯区人民南路四段53号附1号(近肿瘤医院)","businessScore":3,"businessGdp":"100","longitude":"104.058566","latitude":"30.701084"}}
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
         * wineInfo : [{"wineTypeName":"白酒","wines":[{"wineName":"茅台","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineSurplus":1,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"22天","state":1},{"wineName":"茅台","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineSurplus":2,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"11天","state":1},{"wineName":"茅台","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineSurplus":2,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"20天","state":1}]},{"wineTypeName":"啤酒","wines":[{"wineName":"百威啤酒","wineAvatar":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548936354236&di=b21e061a336cbffde881340fd390da9a&imgtype=0&src=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F04%2F25%2Fb4695621345c.jpg","wineSurplus":19,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"7天","state":1},{"wineName":"雪花啤酒","wineAvatar":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineSurplus":15,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"26天","state":1},{"wineName":"百威啤酒","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineSurplus":13,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"8天","state":1},{"wineName":"雪花啤酒","wineAvatar":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineSurplus":10,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"8天","state":1},{"wineName":"百威啤酒","wineAvatar":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548936354236&di=b21e061a336cbffde881340fd390da9a&imgtype=0&src=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F04%2F25%2Fb4695621345c.jpg","wineSurplus":9,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"8天","state":1}]},{"wineTypeName":"洋酒","wines":[{"wineName":"Chivas","wineAvatar":"https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/crop%3D59%2C45%2C867%2C572%3Bc0%3Dbaike92%2C5%2C5%2C92%2C30/sign=56c3299bb6315c6057da31afb084f23f/ac345982b2b7d0a2bac98113c1ef76094b369a38.jpg","wineSurplus":0,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"15天","state":1}]}]
         * businessInfo : {"businessId":1,"businessName":"好乐星KTV(南门店)","businessAddress":"成都市武侯区人民南路四段53号附1号(近肿瘤医院)","businessScore":3,"businessGdp":"100","longitude":"104.058566","latitude":"30.701084"}
         */

        private BusinessInfoBean businessInfo;
        private List<WineInfoBean> wineInfo;

        public BusinessInfoBean getBusinessInfo() {
            return businessInfo;
        }

        public void setBusinessInfo(BusinessInfoBean businessInfo) {
            this.businessInfo = businessInfo;
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
             * businessScore : 3.0
             * businessGdp : 100
             * longitude : 104.058566
             * latitude : 30.701084
             */

            private int businessId;
            private String businessName;
            private String businessAddress;
            private double businessScore;
            private String businessGdp;
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
             * wineTypeName : 白酒
             * wines : [{"wineName":"茅台","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineSurplus":1,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"22天","state":1},{"wineName":"茅台","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineSurplus":2,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"11天","state":1},{"wineName":"茅台","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineSurplus":2,"wineSpecifications":"500ML","wineUnit":"瓶","surplusTime":"20天","state":1}]
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
                 * wineName : 茅台
                 * wineAvatar : https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg
                 * wineSurplus : 1
                 * wineSpecifications : 500ML
                 * wineUnit : 瓶
                 * surplusTime : 22天
                 * state : 1
                 */

                private String wineName;
                private String wineAvatar;
                private int wineSurplus;
                private String wineSpecifications;
                private String wineUnit;
                private String surplusTime;
                private int state;

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

                public int getWineSurplus() {
                    return wineSurplus;
                }

                public void setWineSurplus(int wineSurplus) {
                    this.wineSurplus = wineSurplus;
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

                public String getSurplusTime() {
                    return surplusTime;
                }

                public void setSurplusTime(String surplusTime) {
                    this.surplusTime = surplusTime;
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
