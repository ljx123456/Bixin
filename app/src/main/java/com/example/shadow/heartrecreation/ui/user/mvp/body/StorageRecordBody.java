package com.example.shadow.heartrecreation.ui.user.mvp.body;

public class StorageRecordBody {

    /**
     * token : 2j/RNIaEFRloXDJHunZLHXqPx+JJ73xtHrt3EDWGyyEJbqRJPYhsO11jwjVnESZlP4WHhK59Ai3ej44Z9mQLpiMOEDt6MpcOtd4nDDcEKdSQcVeGOh5O7Etxab8KLwjLvXm89EhPTiH1UOrYBiJtb79dCP/9FJmRAZB17vHSCNM=
     * businessId : 1
     * pageSize : 10
     * pageIndex : 1
     */

    private String token;
    private int businessId;
    private int pageSize;
    private int pageIndex;

    public StorageRecordBody(String token, int businessId, int pageSize, int pageIndex) {
        this.token = token;
        this.businessId = businessId;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }
}
