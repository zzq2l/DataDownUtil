package com.jiurun.data.down.entity;


public class DownEntity {
    private String WINDOWOPENTIME;
    private String IMEI;
    private String Threshold_DN;
    private String Threshold_UP;
    private String Detectinterval;
    private String TimeInterval;
    private String rawData;
    private String CRC;
    private String IMSI;

    public DownEntity() {
    }

    public String getWINDOWOPENTIME() {
        return this.WINDOWOPENTIME;
    }

    public void setWINDOWOPENTIME(String WINDOWOPENTIME) {
        this.WINDOWOPENTIME = WINDOWOPENTIME;
    }

    public String getIMEI() {
        return this.IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getThreshold_DN() {
        return this.Threshold_DN;
    }

    public void setThreshold_DN(String threshold_DN) {
        this.Threshold_DN = threshold_DN;
    }

    public String getRawData() {
        return this.rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getThreshold_UP() {
        return this.Threshold_UP;
    }

    public void setThreshold_UP(String threshold_UP) {
        this.Threshold_UP = threshold_UP;
    }

    public String getDetectinterval() {
        return this.Detectinterval;
    }

    public void setDetectinterval(String detectinterval) {
        this.Detectinterval = detectinterval;
    }

    public String getTimeInterval() {
        return this.TimeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.TimeInterval = timeInterval;
    }

    public String getCRC() {
        return this.CRC;
    }

    public void setCRC(String CRC) {
        this.CRC = CRC;
    }

    public String getIMSI() {
        return this.IMSI;
    }

    public void setIMSI(String IMSI) {
        this.IMSI = IMSI;
    }

    public String toString() {
        return "DownEntity{WINDOWOPENTIME='" + this.WINDOWOPENTIME + '\'' + ", IMEI='" + this.IMEI + '\'' + ", Threshold_DN='" + this.Threshold_DN + '\'' + ", Threshold_UP='" + this.Threshold_UP + '\'' + ", Detectinterval='" + this.Detectinterval + '\'' + ", TimeInterval='" + this.TimeInterval + '\'' + ", rawData='" + this.rawData + '\'' + ", CRC='" + this.CRC + '\'' + ", IMSI='" + this.IMSI + '\'' + '}';
    }
}
