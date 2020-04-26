package com.jiurun.data.down.entity;

/**
 * @Package: com.jiurn.data.down.entity
 * @ClassName: Dee
 * @Author: ${zhouzhiqiang}
 * @Date: 8/8/2019 18:12
 */
public class SecretKey {

    private Integer id;
    private String queryCondition;
    private String appId;
    private String secret;
    private String baseUrl;

    public SecretKey() {
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQueryCondition() {
        return this.queryCondition;
    }

    public void setQueryCondition(String queryCondition) {
        this.queryCondition = queryCondition;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getSecret() {
        return this.secret;
    }

    public String toString() {
        return "SecretKey{id=" + this.id + ", queryCondition='" + this.queryCondition + '\'' + ", appId='" + this.appId + '\'' + ", secret='" + this.secret + '\'' + ", baseUrl='" + this.baseUrl + '\'' + '}';
    }
}
