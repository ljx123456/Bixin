package com.example.shadow.heartrecreation.ui.user.mvp.body;

public class UserEditBody {

    private String token;
    private String nickname;
    private String birthday;
    private String avatar;

    public UserEditBody(String token, String nickname, String birthday, String avatar) {
        this.token = token;
        this.nickname = nickname;
        this.birthday = birthday;
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
