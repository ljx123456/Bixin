package com.example.shadow.heartrecreation.ui.main.mvp.body;

public class ServeListBody {

    private int sort;
    private String token;
//    private String height;
    private String age;
    private int state;
    private int sex;
    private String occupations;
    private String businessId;
    private int pageIndex;
    private int pageSize;
    private String skillTypeId;
    private String cityId;
    private String lat;
    private String lng;

    public ServeListBody(int sort, String token, String age, int state, int sex, String occupations, String businessId, int pageIndex, int pageSize, String skillTypeId, String cityId,String lat,String lng) {
        this.sort = sort;
        this.token = token;
//        this.height = height;
        this.age = age;
        this.state = state;
        this.sex = sex;
        this.occupations = occupations;
        this.businessId = businessId;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.skillTypeId = skillTypeId;
        this.cityId = cityId;
        this.lat=lat;
        this.lng=lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }


    public String getSkillTypeId() {
        return skillTypeId;
    }

    public void setSkillTypeId(String skillTypeId) {
        this.skillTypeId = skillTypeId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

//    public String getHeight() {
//        return height;
//    }
//
//    public void setHeight(String height) {
//        this.height = height;
//    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getOccupations() {
        return occupations;
    }

    public void setOccupations(String occupations) {
        this.occupations = occupations;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
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
