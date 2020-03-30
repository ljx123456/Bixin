package com.example.shadow.heartrecreation.ui.login.mvp.body;

public class RegDataBody {


    /**
     * phone : 15101053757
     * pwd : 12
     * confirmPwd : 12
     * nickname : 你好
     * sex : 1
     * birthday : 1993-08-21 00:00:00
     */

    private String phone;
    private String pwd;
    private String confirmPwd;
    private String nickname;
    private int sex;
    private String birthday;
    private String referee;

    public RegDataBody(String phone, String pwd, String confirmPwd, String nickname, int sex, String birthday) {
        this.phone = phone;
        this.pwd = pwd;
        this.confirmPwd = confirmPwd;
        this.nickname = nickname;
        this.sex = sex;
        this.birthday = birthday;
    }

    public RegDataBody(String phone, String pwd, String confirmPwd, String nickname, int sex, String birthday, String referee) {
        this.phone = phone;
        this.pwd = pwd;
        this.confirmPwd = confirmPwd;
        this.nickname = nickname;
        this.sex = sex;
        this.birthday = birthday;
        this.referee = referee;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
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
}
