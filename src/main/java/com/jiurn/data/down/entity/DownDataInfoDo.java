package com.jiurn.data.down.entity;


import java.util.Date;

/**
 * @Package: com.jiurn.data.down.entity
 * @ClassName: DownDataInfoDo
 * @Author: ${zhouzhiqiang}
 * @Date: 31/7/2019 17:33
 */
//下发数据封装
public class DownDataInfoDo  {

    private Integer  id;
    private String  deviceId;
    private String  dataDownValue1;
    private String  dataDownValue2;
    private String  dataDownValue3;
    private String  dataDownValue4;
    private String  dataDownValue5;
    private Date  downTime;
    private Date  downUpdataTime;
    private Date  downSuccessfulTime;
    private Integer  downBit;
    private Integer  sendNumber;

    public Integer getSendNumber() {
        return sendNumber;
    }

    public void setSendNumber(Integer sendNumber) {
        this.sendNumber = sendNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDataDownValue1() {
        return dataDownValue1;
    }

    public void setDataDownValue1(String dataDownValue1) {
        this.dataDownValue1 = dataDownValue1;
    }

    public String getDataDownValue2() {
        return dataDownValue2;
    }

    public void setDataDownValue2(String dataDownValue2) {
        this.dataDownValue2 = dataDownValue2;
    }

    public String getDataDownValue3() {
        return dataDownValue3;
    }

    public void setDataDownValue3(String dataDownValue3) {
        this.dataDownValue3 = dataDownValue3;
    }

    public String getDataDownValue4() {
        return dataDownValue4;
    }

    public void setDataDownValue4(String dataDownValue4) {
        this.dataDownValue4 = dataDownValue4;
    }

    public String getDataDownValue5() {
        return dataDownValue5;
    }

    public void setDataDownValue5(String dataDownValue5) {
        this.dataDownValue5 = dataDownValue5;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Date getDownUpdataTime() {
        return downUpdataTime;
    }

    public void setDownUpdataTime(Date downUpdataTime) {
        this.downUpdataTime = downUpdataTime;
    }

    public Date getDownSuccessfulTime() {
        return downSuccessfulTime;
    }

    public void setDownSuccessfulTime(Date downSuccessfulTime) {
        this.downSuccessfulTime = downSuccessfulTime;
    }

    public Integer getDownBit() {
        return downBit;
    }

    public void setDownBit(Integer downBit) {
        this.downBit = downBit;
    }

    @Override
    public String toString() {
        return "DownDataInfoDo{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", dataDownValue1='" + dataDownValue1 + '\'' +
                ", dataDownValue2='" + dataDownValue2 + '\'' +
                ", dataDownValue3='" + dataDownValue3 + '\'' +
                ", dataDownValue4='" + dataDownValue4 + '\'' +
                ", dataDownValue5='" + dataDownValue5 + '\'' +
                ", downTime=" + downTime +
                ", downUpdataTime=" + downUpdataTime +
                ", downSuccessfulTime=" + downSuccessfulTime +
                ", downBit=" + downBit +
                ", sendNumber=" + sendNumber +
                '}';
    }
}
