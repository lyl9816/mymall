package com.snack.pojo;

import java.util.Date;

public class Integral {
    private Integer iId;

    private Integer uId;

    private Integer iNumber;

    private Date iTime;

    private String iDese;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getiNumber() {
        return iNumber;
    }

    public void setiNumber(Integer iNumber) {
        this.iNumber = iNumber;
    }

    public Date getiTime() {
        return iTime;
    }

    public void setiTime(Date iTime) {
        this.iTime = iTime;
    }

    public String getiDese() {
        return iDese;
    }

    public void setiDese(String iDese) {
        this.iDese = iDese == null ? null : iDese.trim();
    }
}