package com.example.shadow.heartrecreation.ui.login.mvp.body;

public class ResetPwdBody {

    /**
     * phone : 15101053755
     * pwd : 123
     * confirmPwd : 123
     */

    private String phone;
    private String pwd;
    private String confirmPwd;

    public ResetPwdBody(String phone, String pwd, String confirmPwd) {
        this.phone = phone;
        this.pwd = pwd;
        this.confirmPwd = confirmPwd;
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
}
