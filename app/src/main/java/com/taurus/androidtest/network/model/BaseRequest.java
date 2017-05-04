package com.taurus.androidtest.network.model;

public class BaseRequest {

    private int page;

    public BaseRequest(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
