package com.jiurun.data.down.entity;

import java.io.Serializable;

public class DeviceTypeSecretKey implements Serializable {
    private Integer id;
    private String smallDeviceType;
    private String secretKey;

    public DeviceTypeSecretKey() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSmallDeviceType() {
        return this.smallDeviceType;
    }

    public void setSmallDeviceType(String smallDeviceType) {
        this.smallDeviceType = smallDeviceType;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String toString() {
        return "DeviceTypeSecretKey{id=" + this.id + ", smallDeviceType='" + this.smallDeviceType + '\'' + ", secretKey='" + this.secretKey + '\'' + '}';
    }
}