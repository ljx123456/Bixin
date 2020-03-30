package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.util.List;

public class MainBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"recommend":[{"id":5,"image":"http://pic.bixinyule.com/banner_05@2x.png","name":"海量福利，尽在比心","url":"http://app.bixinyule.com/user/banner/recommend"}],"show":[{"typeId":1,"typeDescride":"故事，从这里发声","typePhoto":"https://s2.ax1x.com/2019/03/19/AuJZ9J.png","showPhoto":"http://tupian.qqjay.com/u/2016/0607/13_17557_5.jpg","showName":"纵享欢唱","state":1},{"typeId":2,"typeDescride":"畅游万水，同你感触海底斑斓","typePhoto":"https://lanhu.oss-cn-beijing.aliyuncs.com/SketchSlicePng3f5c4fc09636cbc253b4de335e156778","showPhoto":"http://tupian.qqjay.com/u/2016/0607/13_17557_5.jpg","showName":"深海潜游","state":0},{"typeId":3,"typeDescride":"踏遍千山，同你笑看世间烂漫","typePhoto":"https://lanhu.oss-cn-beijing.aliyuncs.com/SketchSlicePngb1709a420e77b91832e1a1fc6aa4b69f","showPhoto":"http://pic1.win4000.com/cover/2019-03-06/20190306133408_48304_250_300.jpg","showName":"户外登山","state":0}]}
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
        private List<RecommendBean> recommend;
        private List<ShowBean> show;

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

        public List<ShowBean> getShow() {
            return show;
        }

        public void setShow(List<ShowBean> show) {
            this.show = show;
        }

        public static class RecommendBean {
            /**
             * id : 5
             * image : http://pic.bixinyule.com/banner_05@2x.png
             * name : 海量福利，尽在比心
             * url : http://app.bixinyule.com/user/banner/recommend
             */

            private int id;
            private String image;
            private String name;
            private String url;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ShowBean {
            /**
             * typeId : 1
             * typeDescride : 故事，从这里发声
             * typePhoto : https://s2.ax1x.com/2019/03/19/AuJZ9J.png
             * showPhoto : http://tupian.qqjay.com/u/2016/0607/13_17557_5.jpg
             * showName : 纵享欢唱
             * state : 1
             */

            private int typeId;
            private String typeDescride;
            private String typePhoto;
            private String showPhoto;
            private String showName;
            private int state;

            public int getTypeId() {
                return typeId;
            }

            public void setTypeId(int typeId) {
                this.typeId = typeId;
            }

            public String getTypeDescride() {
                return typeDescride;
            }

            public void setTypeDescride(String typeDescride) {
                this.typeDescride = typeDescride;
            }

            public String getTypePhoto() {
                return typePhoto;
            }

            public void setTypePhoto(String typePhoto) {
                this.typePhoto = typePhoto;
            }

            public String getShowPhoto() {
                return showPhoto;
            }

            public void setShowPhoto(String showPhoto) {
                this.showPhoto = showPhoto;
            }

            public String getShowName() {
                return showName;
            }

            public void setShowName(String showName) {
                this.showName = showName;
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
