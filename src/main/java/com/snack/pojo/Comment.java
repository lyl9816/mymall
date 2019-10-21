package com.snack.pojo;

import java.util.Date;

public class Comment {
    private Integer eId;

    private Integer eParentid;

    private Integer sId;

    private Integer uId;

    private String ePicturename;

    private Integer eType;

    private Integer eScore;

    private String info;

    private Date eDate;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer geteParentid() {
        return eParentid;
    }

    public void seteParentid(Integer eParentid) {
        this.eParentid = eParentid;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getePicturename() {
        return ePicturename;
    }

    public void setePicturename(String ePicturename) {
        this.ePicturename = ePicturename == null ? null : ePicturename.trim();
    }

    public Integer geteType() {
        return eType;
    }

    public void seteType(Integer eType) {
        this.eType = eType;
    }

    public Integer geteScore() {
        return eScore;
    }

    public void seteScore(Integer eScore) {
        this.eScore = eScore;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Date geteDate() {
        return eDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }
}