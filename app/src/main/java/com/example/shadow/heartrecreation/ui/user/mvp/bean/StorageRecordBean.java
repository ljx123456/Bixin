package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.util.List;

public class StorageRecordBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : [{"createTime":"2019-03-12 19:29:48","wineInfo":[{"wineTypeName":"啤酒","wineTypeStorageTime":"16天","wines":[{"wineName":"百威啤酒","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineNum":15,"wineSpecifications":"500ML","wineUnit":"瓶"},{"wineName":"雪花啤酒","wineAvatar":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineNum":30,"wineSpecifications":"500ML","wineUnit":"瓶"}]}]},{"createTime":"2019-03-12 19:19:48","wineInfo":[{"wineTypeName":"啤酒","wineTypeStorageTime":"16天","wines":[{"wineName":"百威啤酒","wineAvatar":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548936354236&di=b21e061a336cbffde881340fd390da9a&imgtype=0&src=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F04%2F25%2Fb4695621345c.jpg","wineNum":15,"wineSpecifications":"500ML","wineUnit":"瓶"}]},{"wineTypeName":"白酒","wineTypeStorageTime":"28天","wines":[{"wineName":"茅台","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineNum":2,"wineSpecifications":"500ML","wineUnit":"瓶"}]}]},{"createTime":"2019-03-12 11:29:48","wineInfo":[{"wineTypeName":"啤酒","wineTypeStorageTime":"17天","wines":[{"wineName":"雪花啤酒","wineAvatar":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineNum":10,"wineSpecifications":"500ML","wineUnit":"瓶"},{"wineName":"百威啤酒","wineAvatar":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548936354236&di=b21e061a336cbffde881340fd390da9a&imgtype=0&src=http%3A%2F%2Fpic2.cxtuku.com%2F00%2F04%2F25%2Fb4695621345c.jpg","wineNum":15,"wineSpecifications":"500ML","wineUnit":"瓶"}]},{"wineTypeName":"洋酒","wineTypeStorageTime":"19天","wines":[{"wineName":"Chivas","wineAvatar":"https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/crop%3D59%2C45%2C867%2C572%3Bc0%3Dbaike92%2C5%2C5%2C92%2C30/sign=56c3299bb6315c6057da31afb084f23f/ac345982b2b7d0a2bac98113c1ef76094b369a38.jpg","wineNum":1,"wineSpecifications":"500ML","wineUnit":"瓶"}]}]}]
     */

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
         * createTime : 2019-03-12 19:29:48
         * wineInfo : [{"wineTypeName":"啤酒","wineTypeStorageTime":"16天","wines":[{"wineName":"百威啤酒","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineNum":15,"wineSpecifications":"500ML","wineUnit":"瓶"},{"wineName":"雪花啤酒","wineAvatar":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineNum":30,"wineSpecifications":"500ML","wineUnit":"瓶"}]}]
         */

        private String createTime;
        private List<WineInfoBean> wineInfo;
        private boolean isExpanded = false;

        public boolean isExpanded() {
            return isExpanded;
        }

        public void setExpanded(boolean expanded) {
            isExpanded = expanded;
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

        public static class WineInfoBean {
            /**
             * wineTypeName : 啤酒
             * wineTypeStorageTime : 16天
             * wines : [{"wineName":"百威啤酒","wineAvatar":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg","wineNum":15,"wineSpecifications":"500ML","wineUnit":"瓶"},{"wineName":"雪花啤酒","wineAvatar":"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1548926224&di=f103e9bfb686c9425752444a7de3c64e&src=http://pic28.photophoto.cn/20130806/0017030703118697_b.jpg","wineNum":30,"wineSpecifications":"500ML","wineUnit":"瓶"}]
             */

            private String wineTypeName;
            private String wineTypeStorageTime="";
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
                 * wineName : 百威啤酒
                 * wineAvatar : https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=91e018bf506034a83defb0d3aa7a2231/960a304e251f95cad90d0308c5177f3e66095297.jpg
                 * wineNum : 15
                 * wineSpecifications : 500ML
                 * wineUnit : 瓶
                 */

                private String wineName;
                private String wineAvatar;
                private int wineNum;
                private String wineSpecifications;
                private String wineUnit;
                private String wineSurplusTime = "";

                public String getWineSurplusTime() {
                    return wineSurplusTime;
                }

                public void setWineSurplusTime(String wineSurplusTime) {
                    this.wineSurplusTime = wineSurplusTime;
                }

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
