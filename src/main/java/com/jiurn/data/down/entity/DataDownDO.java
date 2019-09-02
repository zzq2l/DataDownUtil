package com.jiurn.data.down.entity;

import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * 封装下发参数值
 *
 * @Package: com.jiurn.data.down.entity
 * @ClassName: DataDownDO
 * @Author: ${zhouzhiqiang}
 * @Date: 27/7/2019 15:55
 */

public class DataDownDO {
    private String deviceId;
    private String dataDownValue;

    private String timeInterval;
    private String vendorInfo;

    public Double upperLimit;

    public Double lowerLimit;

    public String getVendorInfo() {
        return vendorInfo;
    }

    public void setVendorInfo(String vendorInfo) {
        this.vendorInfo = vendorInfo;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDataDownValue() {
        return dataDownValue;
    }

    public void setDataDownValue(String dataDownValue) {
        this.dataDownValue = dataDownValue;
    }

    public Double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Double getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Double lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    @Override
    public String toString() {
        return "DataDownDO{" +
                "deviceId='" + deviceId + '\'' +
                ", dataDownValue='" + dataDownValue + '\'' +
                ", timeInterval='" + timeInterval + '\'' +
                ", vendorInfo='" + vendorInfo + '\'' +
                ", upperLimit=" + upperLimit +
                ", lowerLimit=" + lowerLimit +
                '}';
    }
}
