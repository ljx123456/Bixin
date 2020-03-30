package com.example.shadow.heartrecreation.ui.user.mvp.bean;

import java.util.List;

public class BlackListBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : [{"userId":3,"nickname":"你好","sex":1,"avatar":"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=476678274,1145143993&fm=173&app=25&f=JPEG?w=292&h=483&s=98C0EA05BAF5E85F443C1C890100E090","birthday":"1993-08-21 00:00:00","age":25,"constellation":"狮子座"}]
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
         * userId : 3
         * nickname : 你好
         * sex : 1
         * avatar : https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=476678274,1145143993&fm=173&app=25&f=JPEG?w=292&h=483&s=98C0EA05BAF5E85F443C1C890100E090
         * birthday : 1993-08-21 00:00:00
         * age : 25
         * constellation : 狮子座
         */

        private int userId;
        private String nickname;
        private int sex;
        private String avatar;
        private String birthday;
        private int age = 0;
        private String constellation;

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

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getConstellation() {
            return constellation;
        }

        public void setConstellation(String constellation) {
            this.constellation = constellation;
        }
    }
}
