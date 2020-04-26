package com.jiurun.data.down.entity;

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
    public String upperLimit;
    public String lowerLimit;

    public DataDownDO() {
    }

    public String getVendorInfo() {
        return this.vendorInfo;
    }

    public void setVendorInfo(String vendorInfo) {
        this.vendorInfo = vendorInfo;
    }

    public String getTimeInterval() {
        return this.timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDataDownValue() {
        return this.dataDownValue;
    }

    public void setDataDownValue(String dataDownValue) {
        this.dataDownValue = dataDownValue;
    }

    public String getUpperLimit() {
        return this.upperLimit;
    }

    public void setUpperLimit(String upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getLowerLimit() {
        return this.lowerLimit;
    }

    public void setLowerLimit(String lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public String toString() {
        return "DataDownDO{deviceId='" + this.deviceId + '\'' + ", dataDownValue='" + this.dataDownValue + '\'' + ", timeInterval='" + this.timeInterval + '\'' + ", vendorInfo='" + this.vendorInfo + '\'' + ", upperLimit=" + this.upperLimit + ", lowerLimit=" + this.lowerLimit + '}';
    }
}
