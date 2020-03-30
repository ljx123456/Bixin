package com.example.shadow.heartrecreation.ui.order.mvp.body;

import java.util.List;

public class ComplaintBody {

    /**
     * orderServiceNo : 3000201904160857131952091
     * reasonId : 1
     * content : 内容
     * photos : ["http://t1.27270.com/uploads/tu/201811/232/5f4adf133b.jpg","http://t1.27270.com/uploads/tu/201811/232/5f4adf133b.jpg"]
     */

    private String orderServiceNo;
    private String reasonId;
    private String content;
    private List<String> photos;

    public String getOrderServiceNo() {
        return orderServiceNo;
    }

    public void setOrderServiceNo(String orderServiceNo) {
        this.orderServiceNo = orderServiceNo;
    }

    public String getReasonId() {
        return reasonId;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public ComplaintBody(String orderServiceNo, String reasonId, String content, List<String> photos) {
        this.orderServiceNo = orderServiceNo;
        this.reasonId = reasonId;
        this.content = content;
        this.photos = photos;
    }
}
