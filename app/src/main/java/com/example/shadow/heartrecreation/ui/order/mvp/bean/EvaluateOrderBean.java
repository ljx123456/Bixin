package com.example.shadow.heartrecreation.ui.order.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class EvaluateOrderBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"orderNo":"1000201901214243752399711","businessId":2,"businessName":"梦乐美纯K量贩KTV","businessImg":"http://e.hiphotos.baidu.com/bainuo/crop%3D0%2C21%2C690%2C418%3Bw%3D470%3Bq%3D80/sign=8ed59e9a3ff33a878a225a5afb6c3c0a/4ec2d5628535e5ddbcfdb87573c6a7efcf1b6242.jpg","boxName":"ka111","boxTypeName":"豪包","serviceUsers":[{"serviceUserId":3265,"age":"19","nickname":"了那寂静的伤","sex":2,"avatar":"http://pic1.win4000.com/pic/0/fa/b52b814459_250_350.jpg","occupation":"教师","price":800}],"serviceTags":[{"tagId":10,"parentId":-1,"tagName":"外表"},{"tagId":1,"parentId":10,"tagName":"美丽"}]}
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
         * orderNo : 1000201901214243752399711
         * businessId : 2
         * businessName : 梦乐美纯K量贩KTV
         * businessImg : http://e.hiphotos.baidu.com/bainuo/crop%3D0%2C21%2C690%2C418%3Bw%3D470%3Bq%3D80/sign=8ed59e9a3ff33a878a225a5afb6c3c0a/4ec2d5628535e5ddbcfdb87573c6a7efcf1b6242.jpg
         * boxName : ka111
         * boxTypeName : 豪包
         * serviceUsers : [{"serviceUserId":3265,"age":"19","nickname":"了那寂静的伤","sex":2,"avatar":"http://pic1.win4000.com/pic/0/fa/b52b814459_250_350.jpg","occupation":"教师","price":800}]
         * serviceTags : [{"tagId":10,"parentId":-1,"tagName":"外表"},{"tagId":1,"parentId":10,"tagName":"美丽"}]
         */

        private String orderNo;
        private int businessId;
        private String businessName;
        private String businessImg;
        private String boxName;
        private String boxTypeName;
        private List<ServiceUsersBean> serviceUsers;
        private List<ServiceTagsBean> serviceTags;

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

        public String getBusinessImg() {
            return businessImg;
        }

        public void setBusinessImg(String businessImg) {
            this.businessImg = businessImg;
        }

        public String getBoxName() {
            return boxName;
        }

        public void setBoxName(String boxName) {
            this.boxName = boxName;
        }

        public String getBoxTypeName() {
            return boxTypeName;
        }

        public void setBoxTypeName(String boxTypeName) {
            this.boxTypeName = boxTypeName;
        }

        public List<ServiceUsersBean> getServiceUsers() {
            return serviceUsers;
        }

        public void setServiceUsers(List<ServiceUsersBean> serviceUsers) {
            this.serviceUsers = serviceUsers;
        }

        public List<ServiceTagsBean> getServiceTags() {
            return serviceTags;
        }

        public void setServiceTags(List<ServiceTagsBean> serviceTags) {
            this.serviceTags = serviceTags;
        }

        public static class ServiceUsersBean {
            /**
             * serviceUserId : 3265
             * age : 19
             * nickname : 了那寂静的伤
             * sex : 2
             * avatar : http://pic1.win4000.com/pic/0/fa/b52b814459_250_350.jpg
             * occupation : 教师
             * price : 800
             */

            private int serviceUserId;
            private String age;
            private String nickname;
            private int sex;
            private String avatar;
            private String occupation;
            private BigDecimal price=new BigDecimal(0.00);
            private float one = 3;
            private float tow = 3;
            private float three = 3;
            private float four = 3;

            public float getOne() {
                return one;
            }

            public void setOne(float one) {
                this.one = one;
            }

            public float getTow() {
                return tow;
            }

            public void setTow(float tow) {
                this.tow = tow;
            }

            public float getThree() {
                return three;
            }

            public void setThree(float three) {
                this.three = three;
            }

            public float getFour() {
                return four;
            }

            public void setFour(float four) {
                this.four = four;
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

            public BigDecimal getPrice() {
                return price;
            }

            public void setPrice(BigDecimal price) {
                this.price = price;
            }
        }

        public static class ServiceTagsBean {
            /**
             * tagId : 10
             * parentId : -1
             * tagName : 外表
             */

            private int tagId;
            private int parentId;
            private String tagName;

            public int getTagId() {
                return tagId;
            }

            public void setTagId(int tagId) {
                this.tagId = tagId;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }
        }
    }
}
