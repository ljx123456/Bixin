package com.example.shadow.heartrecreation.db.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class ServePersonnelDB {
    @Id(autoincrement = true)
    private Long id;
    private String serveID;//服务人员ID
    private String name;//服务人员名字
    private String image;//图片
    private String money;//多少钱一场
    private String lon;//经纬度
    private String lat;//
    private String age;//年龄
    private String sex;//性别
    private String adds;//距离
    private String join;//职业

    @Generated(hash = 2051935337)
    public ServePersonnelDB(Long id, String serveID, String name, String image, String money,
            String lon, String lat, String age, String sex, String adds, String join) {
        this.id = id;
        this.serveID = serveID;
        this.name = name;
        this.image = image;
        this.money = money;
        this.lon = lon;
        this.lat = lat;
        this.age = age;
        this.sex = sex;
        this.adds = adds;
        this.join = join;
    }

    @Generated(hash = 1893155015)
    public ServePersonnelDB() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServeID() {
        return this.serveID;
    }

    public void setServeID(String serveID) {
        this.serveID = serveID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMoney() {
        return this.money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getLon() {
        return this.lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return this.lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdds() {
        return this.adds;
    }

    public void setAdds(String adds) {
        this.adds = adds;
    }

    public String getJoin() {
        return this.join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

}
