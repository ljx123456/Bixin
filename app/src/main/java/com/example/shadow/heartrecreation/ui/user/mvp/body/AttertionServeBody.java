package com.example.shadow.heartrecreation.ui.user.mvp.body;

public class AttertionServeBody {

    private String token;
    private String lng;
    private String lat;
    private String pageIndex;
    private String pageSize;

    public AttertionServeBody(String token, String lng, String lat, String pageIndex, String pageSize) {
        this.token = token;
        this.lng = lng;
        this.lat = lat;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
}
