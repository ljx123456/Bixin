package com.example.shadow.heartrecreation.db.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class OrderServeDB {
    @Id(autoincrement = true)
    private Long id;
    private String serveID;//服务人员ID
    private String name;//服务人员名字
    private String image;//图片
    @Generated(hash = 666094694)
    public OrderServeDB(Long id, String serveID, String name, String image) {
        this.id = id;
        this.serveID = serveID;
        this.name = name;
        this.image = image;
    }
    @Generated(hash = 182776936)
    public OrderServeDB() {
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
}
