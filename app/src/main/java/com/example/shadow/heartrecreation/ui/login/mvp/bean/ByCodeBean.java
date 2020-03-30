package com.example.shadow.heartrecreation.ui.login.mvp.bean;

public class ByCodeBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : {"userId":"1234","jmpassword":"ohxn9dfz","tokenCreateTime":1555125551883,"token":"+4I3srIbxVWL7uJn9F9hEnqPx+JJ73xtHrt3EDWGyyEJbqRJPYhsO9oN7t37xIN6P4WHhK59Ai3ej44Z9mQLpiMOEDt6MpcOfUsJN0+AQVUNxj8h1PV170txab8KLwjLvXm89EhPTiH1UOrYBiJtb53lZ89RnEFNAZB17vHSCNM=","identity":1,"rongToken":"kEwk7U5k6Cgop3jVn+HYIDTGc5QD0vNbc19NRlM1oXY6EfkUPJkvbZg/AmgOEKTcpdu4F0gIZbolNHrR6R4E5A==","phone":"17608390011","nickname":"你好555","sex":1,"birthday":"1999-08-20 00:00:00","constellation":"狮子座","avatar":"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2634837288,2580771641&fm=173&app=25&f=JPEG?w=550&h=550&s=62A223E550133FCC4AE845A20300A002","bixinId":6666666,"age":19}
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
         * userId : 1234
         * jmpassword : ohxn9dfz
         * tokenCreateTime : 1555125551883
         * token : +4I3srIbxVWL7uJn9F9hEnqPx+JJ73xtHrt3EDWGyyEJbqRJPYhsO9oN7t37xIN6P4WHhK59Ai3ej44Z9mQLpiMOEDt6MpcOfUsJN0+AQVUNxj8h1PV170txab8KLwjLvXm89EhPTiH1UOrYBiJtb53lZ89RnEFNAZB17vHSCNM=
         * identity : 1
         * rongToken : kEwk7U5k6Cgop3jVn+HYIDTGc5QD0vNbc19NRlM1oXY6EfkUPJkvbZg/AmgOEKTcpdu4F0gIZbolNHrR6R4E5A==
         * phone : 17608390011
         * nickname : 你好555
         * sex : 1
         * birthday : 1999-08-20 00:00:00
         * constellation : 狮子座
         * avatar : https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2634837288,2580771641&fm=173&app=25&f=JPEG?w=550&h=550&s=62A223E550133FCC4AE845A20300A002
         * bixinId : 6666666
         * age : 19
         */

        private String userId;
        private String jmpassword;
        private long tokenCreateTime;
        private String token;
        private int identity;
        private String rongToken;
        private String phone;
        private String nickname;
        private int sex;
        private String birthday;
        private String constellation;
        private String avatar;
        private int bixinId;
        private int age;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getJmpassword() {
            return jmpassword;
        }

        public void setJmpassword(String jmpassword) {
            this.jmpassword = jmpassword;
        }

        public long getTokenCreateTime() {
            return tokenCreateTime;
        }

        public void setTokenCreateTime(long tokenCreateTime) {
            this.tokenCreateTime = tokenCreateTime;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getIdentity() {
            return identity;
        }

        public void setIdentity(int identity) {
            this.identity = identity;
        }

        public String getRongToken() {
            return rongToken;
        }

        public void setRongToken(String rongToken) {
            this.rongToken = rongToken;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
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

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getConstellation() {
            return constellation;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getBixinId() {
            return bixinId;
        }

        public void setBixinId(int bixinId) {
            this.bixinId = bixinId;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
