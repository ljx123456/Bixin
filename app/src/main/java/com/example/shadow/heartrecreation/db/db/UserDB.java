package com.example.shadow.heartrecreation.db.db;

import android.support.annotation.IntDef;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserDB {
    @Id(autoincrement = true)
    private Long id;
    private String avatar;
    private String birthday;
    private String constellation;
    private int identity;
    private String nickname;
    private String phone;
    private String rongToken;
    private String sex;
    private String token;
    private int bixinId;
    private int userId;
    private int age;
    private String jmpassword;
    @Generated(hash = 1063480095)
    public UserDB(Long id, String avatar, String birthday, String constellation,
            int identity, String nickname, String phone, String rongToken,
            String sex, String token, int bixinId, int userId, int age,
            String jmpassword) {
        this.id = id;
        this.avatar = avatar;
        this.birthday = birthday;
        this.constellation = constellation;
        this.identity = identity;
        this.nickname = nickname;
        this.phone = phone;
        this.rongToken = rongToken;
        this.sex = sex;
        this.token = token;
        this.bixinId = bixinId;
        this.userId = userId;
        this.age = age;
        this.jmpassword = jmpassword;
    }
    @Generated(hash = 1312299826)
    public UserDB() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAvatar() {
        return this.avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getBirthday() {
        return this.birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getConstellation() {
        return this.constellation;
    }
    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }
    public int getIdentity() {
        return this.identity;
    }
    public void setIdentity(int identity) {
        this.identity = identity;
    }
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRongToken() {
        return this.rongToken;
    }
    public void setRongToken(String rongToken) {
        this.rongToken = rongToken;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public int getBixinId() {
        return this.bixinId;
    }
    public void setBixinId(int bixinId) {
        this.bixinId = bixinId;
    }
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getJmpassword() {
        return this.jmpassword;
    }
    public void setJmpassword(String jmpassword) {
        this.jmpassword = jmpassword;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
