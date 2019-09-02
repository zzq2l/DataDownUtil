package com.jiurn.data.down.entity;

/**
 * @Package: com.jiurn.data.down.entity
 * @ClassName: DeviceInfo
 * @Author: ${zhouzhiqiang}
 * @Date: 27/7/2019 14:35
 */
public class DeviceInfo {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String positionName;

    private String deviceId;

    private Integer deviceRout;

    private Integer unitId;

    private Integer status;

    private Integer deviceStatus;

    private String addTime;

    private String pxpy;

    private String lastUpdateTime;

    private Integer deviceType;

    private String msgTittle; // 设备表没有的字段

    private String msgContent; // 设备表没有的字段

    private String iotDeviceId;

    private String setMessageTime;

    private String deviceValue;

    private String oneNetProductApikey;

    private String oneNetDeviceId;

    private Integer deviceObjId;

    private Integer deviceObjInstId;

    private Integer deviceResId;

    private Integer deviceExist;

    private String deviceRecoveTime;

    private String deviceCallThePoliceMessage;

    private Integer communicationType;

    private String callMessage;

    private String deviceOffLine;

    private String oneNetIMSI;

    private Integer iotType;

    private Long areaLevel;

    /**
     * 视频短地址
     */
    private String shortAddress;

    public String getShortAddress() {
        return shortAddress;
    }

    public void setShortAddress(String shortAddress) {
        this.shortAddress = shortAddress;
    }

    public String getIotDeviceId() {
        return iotDeviceId;
    }

    public void setIotDeviceId(String iotDeviceId) {
        this.iotDeviceId = iotDeviceId;
    }

    public Long getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Long areaLevel) {
        this.areaLevel = areaLevel;
    }

    public Integer getIotType() {
        return iotType;
    }

    public void setIotType(Integer iotType) {
        this.iotType = iotType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOneNetIMSI() {
        return oneNetIMSI;
    }

    public void setOneNetIMSI(String oneNetIMSI) {
        this.oneNetIMSI = oneNetIMSI;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceRout() {
        return deviceRout;
    }

    public void setDeviceRout(Integer deviceRout) {
        this.deviceRout = deviceRout;
    }

    public String getMsgTittle() {
        return msgTittle;
    }

    public void setMsgTittle(String msgTittle) {
        this.msgTittle = msgTittle;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getPxpy() {
        return pxpy;
    }

    public void setPxpy(String pxpy) {
        this.pxpy = pxpy;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getSetMessageTime() {
        return setMessageTime;
    }

    public void setSetMessageTime(String setMessageTime) {
        this.setMessageTime = setMessageTime;
    }

    public String getDeviceValue() {
        return deviceValue;
    }

    public void setDeviceValue(String deviceValue) {
        this.deviceValue = deviceValue;
    }

    public String getOneNetProductApikey() {
        return oneNetProductApikey;
    }

    public void setOneNetProductApikey(String oneNetProductApikey) {
        this.oneNetProductApikey = oneNetProductApikey;
    }

    public String getOneNetDeviceId() {
        return oneNetDeviceId;
    }

    public void setOneNetDeviceId(String oneNetDeviceId) {
        this.oneNetDeviceId = oneNetDeviceId;
    }

    public Integer getDeviceObjId() {
        return deviceObjId;
    }

    public void setDeviceObjId(Integer deviceObjId) {
        this.deviceObjId = deviceObjId;
    }

    public Integer getDeviceObjInstId() {
        return deviceObjInstId;
    }

    public void setDeviceObjInstId(Integer deviceObjInstId) {
        this.deviceObjInstId = deviceObjInstId;
    }

    public Integer getDeviceResId() {
        return deviceResId;
    }

    public void setDeviceResId(Integer deviceResId) {
        this.deviceResId = deviceResId;
    }

    public Integer getDeviceExist() {
        return deviceExist;
    }

    public void setDeviceExist(Integer deviceExist) {
        this.deviceExist = deviceExist;
    }

    public String getDeviceRecoveTime() {
        return deviceRecoveTime;
    }

    public void setDeviceRecoveTime(String deviceRecoveTime) {
        this.deviceRecoveTime = deviceRecoveTime;
    }

    public String getDeviceCallThePoliceMessage() {
        return deviceCallThePoliceMessage;
    }

    public void setDeviceCallThePoliceMessage(String deviceCallThePoliceMessage) {
        this.deviceCallThePoliceMessage = deviceCallThePoliceMessage;
    }

    public Integer getCommunicationType() {
        return communicationType;
    }

    public void setCommunicationType(Integer communicationType) {
        this.communicationType = communicationType;
    }

    public String getCallMessage() {
        return callMessage;
    }

    public void setCallMessage(String callMessage) {
        this.callMessage = callMessage;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getDeviceOffLine() {
        return deviceOffLine;
    }

    public void setDeviceOffLine(String deviceOffLine) {
        this.deviceOffLine = deviceOffLine;
    }

    @Override
    public String toString() {
        return "DeviceInfoPojo [id=" + id + ", positionName=" + positionName
                + ", deviceId=" + deviceId + ", deviceRout=" + deviceRout
                + ", unitId=" + unitId + ", status=" + status
                + ", deviceStatus=" + deviceStatus + ", addTime=" + addTime
                + ", pxpy=" + pxpy + ", lastUpdateTime=" + lastUpdateTime
                + ", deviceType=" + deviceType + ", setMessageTime="
                + setMessageTime + ", deviceValue=" + deviceValue
                + ", oneNetProductApikey=" + oneNetProductApikey
                + ", oneNetDeviceId=" + oneNetDeviceId + ", deviceObjId="
                + deviceObjId + ", deviceObjInstId=" + deviceObjInstId
                + ", deviceResId=" + deviceResId + ", deviceExist="
                + deviceExist + ", deviceRecoveTime=" + deviceRecoveTime
                + ", deviceCallThePoliceMessage=" + deviceCallThePoliceMessage
                + ", communicationType=" + communicationType + ", callMessage="
                + callMessage + ", deviceOffLine=" + deviceOffLine + "]";
    }

}
