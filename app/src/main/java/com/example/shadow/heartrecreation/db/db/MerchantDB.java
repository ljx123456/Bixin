package com.example.shadow.heartrecreation.db.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class MerchantDB {
    @Id(autoincrement = true)
    private Long id;
    private String MerchantName;//商家名称
    private String MerchantID;//商家ID
    private String MerchantImage;//商家图片
    private String BaofangType;//包房类型
    private String BaofangTypeID;//包房类型ID
    private String BaofangID;//包房ID
    private String BaofangName;//包房名字
    private boolean Baofang;//true我在包间 false预约包间
    private String BaofangNum;//包房人数
    private String BaofangMoney;//最低消费
    private String lon;//商家经度
    private String dem;//商家维度
    private String MerchantAdds;//商家地址
    private String MerchatServicePrice;//包房服务费

    @Generated(hash = 903692934)
    public MerchantDB(Long id, String MerchantName, String MerchantID, String MerchantImage,
            String BaofangType, String BaofangTypeID, String BaofangID, String BaofangName,
            boolean Baofang, String BaofangNum, String BaofangMoney, String lon, String dem,
            String MerchantAdds, String MerchatServicePrice) {
        this.id = id;
        this.MerchantName = MerchantName;
        this.MerchantID = MerchantID;
        this.MerchantImage = MerchantImage;
        this.BaofangType = BaofangType;
        this.BaofangTypeID = BaofangTypeID;
        this.BaofangID = BaofangID;
        this.BaofangName = BaofangName;
        this.Baofang = Baofang;
        this.BaofangNum = BaofangNum;
        this.BaofangMoney = BaofangMoney;
        this.lon = lon;
        this.dem = dem;
        this.MerchantAdds = MerchantAdds;
        this.MerchatServicePrice = MerchatServicePrice;
    }

    @Generated(hash = 1670692506)
    public MerchantDB() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantName() {
        return this.MerchantName;
    }

    public void setMerchantName(String MerchantName) {
        this.MerchantName = MerchantName;
    }

    public String getMerchantID() {
        return this.MerchantID;
    }

    public void setMerchantID(String MerchantID) {
        this.MerchantID = MerchantID;
    }

    public String getMerchantImage() {
        return this.MerchantImage;
    }

    public void setMerchantImage(String MerchantImage) {
        this.MerchantImage = MerchantImage;
    }

    public String getBaofangType() {
        return this.BaofangType;
    }

    public void setBaofangType(String BaofangType) {
        this.BaofangType = BaofangType;
    }

    public boolean getBaofang() {
        return this.Baofang;
    }

    public void setBaofang(boolean Baofang) {
        this.Baofang = Baofang;
    }

    public String getBaofangNum() {
        return this.BaofangNum;
    }

    public void setBaofangNum(String BaofangNum) {
        this.BaofangNum = BaofangNum;
    }

    public String getBaofangMoney() {
        return this.BaofangMoney;
    }

    public void setBaofangMoney(String BaofangMoney) {
        this.BaofangMoney = BaofangMoney;
    }

    public String getLon() {
        return this.lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDem() {
        return this.dem;
    }

    public void setDem(String dem) {
        this.dem = dem;
    }

    public String getMerchantAdds() {
        return this.MerchantAdds;
    }

    public void setMerchantAdds(String MerchantAdds) {
        this.MerchantAdds = MerchantAdds;
    }

    public String getMerchatServicePrice() {
        return this.MerchatServicePrice;
    }

    public void setMerchatServicePrice(String MerchatServicePrice) {
        this.MerchatServicePrice = MerchatServicePrice;
    }

    public String getBaofangID() {
        return this.BaofangID;
    }

    public void setBaofangID(String BaofangID) {
        this.BaofangID = BaofangID;
    }

    public String getBaofangTypeID() {
        return this.BaofangTypeID;
    }

    public void setBaofangTypeID(String BaofangTypeID) {
        this.BaofangTypeID = BaofangTypeID;
    }

    public String getBaofangName() {
        return this.BaofangName;
    }

    public void setBaofangName(String BaofangName) {
        this.BaofangName = BaofangName;
    }

}
