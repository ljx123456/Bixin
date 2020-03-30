package com.example.shadow.heartrecreation.ui.meassage.mvp.body;

public class NotificationBody {

    /**
     * pageIndex : 1
     * pageSize : 10
     */

    private int pageIndex;
    private int pageSize;

    public NotificationBody(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
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
