package com.cheny.web.bean;



public class Load  {
    private String clientId;
    private String securityCode; //安全码
    private Float timeSpan; //时间间隔（分钟）
    private LoadStatus status = LoadStatus.Open; //装填
    private WeChatUserInfo owner; //用户
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public String getSecurityCode() {
        return securityCode;
    }
    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
    public Float getTimeSpan() {
        return timeSpan;
    }
    public void setTimeSpan(Float timeSpan) {
        this.timeSpan = timeSpan;
    }
    public LoadStatus getStatus() {
        return status;
    }
    public void setStatus(LoadStatus status) {
        this.status = status;
    }
    public WeChatUserInfo getOwner() {
        return owner;
    }
    public void setOwner(WeChatUserInfo owner) {
        this.owner = owner;
    }

}
