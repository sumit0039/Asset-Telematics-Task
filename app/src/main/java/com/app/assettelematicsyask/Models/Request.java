package com.app.assettelematicsyask.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {
    @SerializedName("clientid")
    @Expose
    private Integer clientid;
    @SerializedName("enterprise_code")
    @Expose
    private Integer enterpriseCode;
    @SerializedName("mno")
    @Expose
    private String mno;
    @SerializedName("passcode")
    @Expose
    private Integer passcode;

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public Integer getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(Integer enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public Integer getPasscode() {
        return passcode;
    }

    public void setPasscode(Integer passcode) {
        this.passcode = passcode;
    }

}
