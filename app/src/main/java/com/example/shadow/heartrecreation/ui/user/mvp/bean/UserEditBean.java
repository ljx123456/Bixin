package com.example.shadow.heartrecreation.ui.user.mvp.bean;

public class UserEditBean {


    /**
     * code : 0
     * message : 请求成功.
     * data : {"tokenCreateTime":0,"identity":0,"nickname":"圈555","birthday":"1997-01-01 00:00:00","constellation":"摩羯座","avatar":"http://pic.bixinyule.com/9edac003-383f-4c4a-b2d3-c15d9b22594b","age":22}
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
         * tokenCreateTime : 0
         * identity : 0
         * nickname : 圈555
         * birthday : 1997-01-01 00:00:00
         * constellation : 摩羯座
         * avatar : http://pic.bixinyule.com/9edac003-383f-4c4a-b2d3-c15d9b22594b
         * age : 22
         */

        private int tokenCreateTime;
        private int identity;
        private String nickname;
        private String birthday;
        private String constellation;
        private String avatar;
        private int age;

        public int getTokenCreateTime() {
            return tokenCreateTime;
        }

        public void setTokenCreateTime(int tokenCreateTime) {
            this.tokenCreateTime = tokenCreateTime;
        }

        public int getIdentity() {
            return identity;
        }

        public void setIdentity(int identity) {
            this.identity = identity;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
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

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
