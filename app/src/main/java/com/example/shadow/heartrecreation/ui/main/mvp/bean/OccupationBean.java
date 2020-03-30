package com.example.shadow.heartrecreation.ui.main.mvp.bean;

import java.util.List;

public class OccupationBean {

    /**
     * code : 0
     * message : 请求成功.
     * data : ["教师","律师","医生","模特","驻唱","主播","歌手","演员","行政","人事","销售","客服","运营","秘书","前台","会计","护士","舞蹈老师","音乐老师","健身教练","摄影师","设计师","化妆师","造型师","品酒师","无业","自由职业","在校学生"]
     */

    private int code;
    private String message;
    private List<String> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
