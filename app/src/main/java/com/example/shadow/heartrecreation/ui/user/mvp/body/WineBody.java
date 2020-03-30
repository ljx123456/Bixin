package com.example.shadow.heartrecreation.ui.user.mvp.body;

public class WineBody {

    /**
     * token : hEg6IBN9p3SePvpsZiaCidra3hZWGWZZin7BAMQASpYJbqRJPYhsO7O4FFD0d13eP4WHhK59Ai39YRI8/xmhByMOEDt6MpcOBEWoIQYJjSAkyR5x4dB+PEtxab8KLwjL7mZf4FBhUqKZna0C1PbbNk3gGSDXrx+F
     */

    private String token;
    /**
     * pageSize : 10
     * pageIndex : 1
     */

    private int pageSize;
    private int pageIndex;

    public WineBody(String token, int pageSize, int pageIndex) {
        this.token = token;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
