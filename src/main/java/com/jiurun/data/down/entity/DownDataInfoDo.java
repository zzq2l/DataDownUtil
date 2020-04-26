package com.jiurun.data.down.entity;


import java.util.Date;

/**
 * @Package: com.jiurn.data.down.entity
 * @ClassName: DownDataInfoDo
 * @Author: ${zhouzhiqiang}
 * @Date: 31/7/2019 17:33
 */
//下发数据封装
public class DownDataInfoDo  {

    private Integer id;
    private String deviceId;
    private String dataDownValue1;
    private String dataDownValue2;
    private String dataDownValue3;
    private String dataDownValue4;
    private String dataDownValue5;
    private Date downTime;
    private Date downUpdataTime;
    private Date downSuccessfulTime;
    private Integer downBit;
    private Integer sendNumber;

    public DownDataInfoDo() {
    }

    public Integer getSendNumber() {
        return this.sendNumber;
    }

    public void setSendNumber(Integer sendNumber) {
        this.sendNumber = sendNumber;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDataDownValue1() {
        return this.dataDownValue1;
    }

    public void setDataDownValue1(String dataDownValue1) {
        this.dataDownValue1 = dataDownValue1;
    }

    public String getDataDownValue2() {
        return this.dataDownValue2;
    }

    public void setDataDownValue2(String dataDownValue2) {
        this.dataDownValue2 = dataDownValue2;
    }

    public String getDataDownValue3() {
        return this.dataDownValue3;
    }

    public void setDataDownValue3(String dataDownValue3) {
        this.dataDownValue3 = dataDownValue3;
    }

    public String getDataDownValue4() {
        return this.dataDownValue4;
    }

    public void setDataDownValue4(String dataDownValue4) {
        this.dataDownValue4 = dataDownValue4;
    }

    public String getDataDownValue5() {
        return this.dataDownValue5;
    }

    public void setDataDownValue5(String dataDownValue5) {
        this.dataDownValue5 = dataDownValue5;
    }

    public Date getDownTime() {
        return this.downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Date getDownUpdataTime() {
        return this.downUpdataTime;
    }

    public void setDownUpdataTime(Date downUpdataTime) {
        this.downUpdataTime = downUpdataTime;
    }

    public Date getDownSuccessfulTime() {
        return this.downSuccessfulTime;
    }

    public void setDownSuccessfulTime(Date downSuccessfulTime) {
        this.downSuccessfulTime = downSuccessfulTime;
    }

    public Integer getDownBit() {
        return this.downBit;
    }

    public void setDownBit(Integer downBit) {
        this.downBit = downBit;
    }

    public String toString() {
        return "DownDataInfoDo{id=" + this.id + ", deviceId='" + this.deviceId + '\'' + ", dataDownValue1='" + this.dataDownValue1 + '\'' + ", dataDownValue2='" + this.dataDownValue2 + '\'' + ", dataDownValue3='" + this.dataDownValue3 + '\'' + ", dataDownValue4='" + this.dataDownValue4 + '\'' + ", dataDownValue5='" + this.dataDownValue5 + '\'' + ", downTime=" + this.downTime + ", downUpdataTime=" + this.downUpdataTime + ", downSuccessfulTime=" + this.downSuccessfulTime + ", downBit=" + this.downBit + ", sendNumber=" + this.sendNumber + '}';
    }
}
