package com.example.shadow.heartrecreation.ui.user.mvp.body;

public class BlackListBody {

    /**
     * token : fkmyYzAz4QZ7HTFiyH9xwJMxzF1j4weMwCGAdxB0FLwJbqRJPYhsO7/VJfA1JPhhbenE+D5EaIJaQ+A/pPia9KtgbBMIN5SVsJPmKqEPs8VkemYYKPwhM1x0752cRnVUD1xqiMI76kZZ023hbTUn3hiadLbNFhqf
     * lng : 105.83
     * lat : 32.43
     * pageIndex : 1
     * pageSize : 10
     */

    private String token;
    private String lng;
    private String lat;
    private int pageIndex;
    private int pageSize;

    public BlackListBody(String token, String lng, String lat, int pageIndex, int pageSize) {
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

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
