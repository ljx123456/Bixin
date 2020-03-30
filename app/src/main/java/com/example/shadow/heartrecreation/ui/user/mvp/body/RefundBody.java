package com.example.shadow.heartrecreation.ui.user.mvp.body;

public class RefundBody {


    /**
     * refundState : 1
     * pageIndex : 1
     * pageSize : 10
     */

    private String refundState;
    private int pageIndex;
    private int pageSize;

    public RefundBody(String refundState, int pageIndex, int pageSize) {
        this.refundState = refundState;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public String getRefundState() {
        return refundState;
    }

    public void setRefundState(String refundState) {
        this.refundState = refundState;
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
