package com.example.shadow.heartrecreation.ui.main.mvp.body;

public class MerchantListSearchBody {

    private String lng;
    private String lat;
    private String pageIndex;
    private String pageSize;
    private String name;

    public MerchantListSearchBody(String lng, String lat, String pageIndex, String pageSize, String name) {
        this.lng = lng;
        this.lat = lat;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
