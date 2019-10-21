package com.snack.pojo;

public class OrderDetail {
    private Integer dId;

    private String oId;

    private String sName;

    private Integer sId;

    private Integer oNum;

    private Double oMoney;

    private SnackInfo snackinfo;

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getoNum() {
        return oNum;
    }

    public void setoNum(Integer oNum) {
        this.oNum = oNum;
    }

    public Double getoMoney() {
        return oMoney;
    }

    public void setoMoney(Double oMoney) {
        this.oMoney = oMoney;
    }

    public SnackInfo getSnackinfo() {
        return snackinfo;
    }

    public void setSnackinfo(SnackInfo snackinfo) {
        this.snackinfo = snackinfo;
    }
}