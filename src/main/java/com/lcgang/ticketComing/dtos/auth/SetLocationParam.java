package com.lcgang.ticketComing.dtos.auth;

import java.io.Serializable;

public class SetLocationParam implements Serializable {
    private String openId;
    private float longitude;
    private float latitude;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
