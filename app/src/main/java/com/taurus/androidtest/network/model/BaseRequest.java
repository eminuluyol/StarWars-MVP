package com.taurus.androidtest.network.model;

public class BaseRequest {

    private int type;

    public BaseRequest(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
