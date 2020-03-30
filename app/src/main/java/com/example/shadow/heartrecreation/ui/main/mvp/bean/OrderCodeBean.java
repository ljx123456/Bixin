package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.math.BigDecimal;
import java.util.List;

public class OrderCodeBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"businessId":6,"businessName":"黄金唛量贩KTV","boxTypeId":21,"boxTypeName":"豪包","boxId":81,"boxName":"A999","boxFreePrice":"1000.0","boxServiceMoney":"200.0","skillTypeId":"1","referencesUser":{"userId":3488,"nickname":"牛奶煮萝莉","sex":1,"age":28,"avatar":"http://pic1.win4000.com/pic/1/4b/230157fe85_250_350.jpg","occupationName":"护士"},"serviceUsers":[{"userId":3265,"nickname":"再苦再痛也终将过去","sex":2,"age":19,"avatar":"http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB","occupationName":"健身教练","skillPrice":800}],"wines":[{"wineId":153,"wineName":"剑南春","num":3,"winePrice":775,"wineImg":"https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=5c569456a944ad343ab28fd5b1cb6791/1ad5ad6eddc451da4cbe3a50befd5266d11632c4.jpg","wineTypeId":32,"wineTypeName":"白酒","specifications":"500ml","unit":"瓶","isDetails":0}]}
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
         * businessId : 6
         * businessName : 黄金唛量贩KTV
         * boxTypeId : 21
         * boxTypeName : 豪包
         * boxId : 81
         * boxName : A999
         * boxFreePrice : 1000.0
         * boxServiceMoney : 200.0
         * skillTypeId : 1
         * referencesUser : {"userId":3488,"nickname":"牛奶煮萝莉","sex":1,"age":28,"avatar":"http://pic1.win4000.com/pic/1/4b/230157fe85_250_350.jpg","occupationName":"护士"}
         * serviceUsers : [{"userId":3265,"nickname":"再苦再痛也终将过去","sex":2,"age":19,"avatar":"http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB","occupationName":"健身教练","skillPrice":800}]
         * wines : [{"wineId":153,"wineName":"剑南春","num":3,"winePrice":775,"wineImg":"https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=5c569456a944ad343ab28fd5b1cb6791/1ad5ad6eddc451da4cbe3a50befd5266d11632c4.jpg","wineTypeId":32,"wineTypeName":"白酒","specifications":"500ml","unit":"瓶","isDetails":0}]
         */

        private int businessId;
        private String businessName;
        private int boxTypeId;
        private String boxTypeName;
        private int boxId;
        private String boxName;
        private String boxFreePrice;
        private String boxServiceMoney;
        private String skillTypeId;
        private ReferencesUserBean referencesUser;
        private List<ServiceUsersBean> serviceUsers;
        private List<WinesBean> wines;

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

        public int getBoxTypeId() {
            return boxTypeId;
        }

        public void setBoxTypeId(int boxTypeId) {
            this.boxTypeId = boxTypeId;
        }

        public String getBoxTypeName() {
            return boxTypeName;
        }

        public void setBoxTypeName(String boxTypeName) {
            this.boxTypeName = boxTypeName;
        }

        public int getBoxId() {
            return boxId;
        }

        public void setBoxId(int boxId) {
            this.boxId = boxId;
        }

        public String getBoxName() {
            return boxName;
        }

        public void setBoxName(String boxName) {
            this.boxName = boxName;
        }

        public String getBoxFreePrice() {
            return boxFreePrice;
        }

        public void setBoxFreePrice(String boxFreePrice) {
            this.boxFreePrice = boxFreePrice;
        }

        public String getBoxServiceMoney() {
            return boxServiceMoney;
        }

        public void setBoxServiceMoney(String boxServiceMoney) {
            this.boxServiceMoney = boxServiceMoney;
        }

        public String getSkillTypeId() {
            return skillTypeId;
        }

        public void setSkillTypeId(String skillTypeId) {
            this.skillTypeId = skillTypeId;
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

        public List<WinesBean> getWines() {
            return wines;
        }

        public void setWines(List<WinesBean> wines) {
            this.wines = wines;
        }

        public static class ReferencesUserBean {
            /**
             * userId : 3488
             * nickname : 牛奶煮萝莉
             * sex : 1
             * age : 28
             * avatar : http://pic1.win4000.com/pic/1/4b/230157fe85_250_350.jpg
             * occupationName : 护士
             */

            private int userId;
            private String nickname;
            private int sex;
            private int age;
            private String avatar;
            private String occupationName;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
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

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getOccupationName() {
                return occupationName;
            }

            public void setOccupationName(String occupationName) {
                this.occupationName = occupationName;
            }
        }

        public static class ServiceUsersBean {
            /**
             * userId : 3265
             * nickname : 再苦再痛也终将过去
             * sex : 2
             * age : 19
             * avatar : http://pic.bixinyule.com/Fu_9VPUZF48catM2jt2OvaMyLgOB
             * occupationName : 健身教练
             * skillPrice : 800
             */

            private int userId;
            private String nickname;
            private int sex;
            private int age;
            private String avatar;
            private String occupationName;
            private BigDecimal skillPrice=new BigDecimal(0.00);

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
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

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getOccupationName() {
                return occupationName;
            }

            public void setOccupationName(String occupationName) {
                this.occupationName = occupationName;
            }

            public BigDecimal getSkillPrice() {
                return skillPrice;
            }

            public void setSkillPrice(BigDecimal skillPrice) {
                this.skillPrice = skillPrice;
            }
        }

        public static class WinesBean {
            /**
             * wineId : 153
             * wineName : 剑南春
             * num : 3
             * winePrice : 775
             * wineImg : https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=5c569456a944ad343ab28fd5b1cb6791/1ad5ad6eddc451da4cbe3a50befd5266d11632c4.jpg
             * wineTypeId : 32
             * wineTypeName : 白酒
             * specifications : 500ml
             * unit : 瓶
             * isDetails : 0
             */

            private int wineId;
            private String wineName;
            private int num;
            private BigDecimal winePrice=new BigDecimal(0.00);
            private String wineImg;
            private int wineTypeId;
            private String wineTypeName;
            private String specifications;
            private String unit;
            private int isDetails;

            public int getWineId() {
                return wineId;
            }

            public void setWineId(int wineId) {
                this.wineId = wineId;
            }

            public String getWineName() {
                return wineName;
            }

            public void setWineName(String wineName) {
                this.wineName = wineName;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public BigDecimal getWinePrice() {
                return winePrice;
            }

            public void setWinePrice(BigDecimal winePrice) {
                this.winePrice = winePrice;
            }

            public String getWineImg() {
                return wineImg;
            }

            public void setWineImg(String wineImg) {
                this.wineImg = wineImg;
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

            public String getSpecifications() {
                return specifications;
            }

            public void setSpecifications(String specifications) {
                this.specifications = specifications;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public int getIsDetails() {
                return isDetails;
            }

            public void setIsDetails(int isDetails) {
                this.isDetails = isDetails;
            }
        }
    }
}
