package com.example.shadow.heartrecreation.ui.main.mvp.body;

public class MerchantBody {

    private String lng;
    private String lat;
    private int type;
    private String pageIndex;
    private String pageSize;
    /**
     * cityId : 1
     */

    private String cityId;

    public MerchantBody(String lng, String lat, int type, String pageIndex, String pageSize, String cityId) {
        this.lng = lng;
        this.lat = lat;
        this.type = type;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.cityId = cityId;
    }

    public MerchantBody(String lng, String lat, int type, String pageIndex, String pageSize) {
        this.lng = lng;
        this.lat = lat;
        this.type = type;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
