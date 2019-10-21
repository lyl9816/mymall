package com.snack.pojo;

import java.util.Date;

public class SnackInfo {
    private Integer sId;

    private String sBatch;

    private String sName;

    private Double sPrice;

    private String sDiscount;

    private String sPictureurl;

    private String sBrand;

    private String sPlace;

    private Integer sImported;

    private Integer sScore;

    private Date sPdate;

    private String sQdate;

    private Integer state;

    private Date sCreatedate;

    private String sDese;

    private String sType;

    private Integer sNumber;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsBatch() {
        return sBatch;
    }

    public void setsBatch(String sBatch) {
        this.sBatch = sBatch == null ? null : sBatch.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public Double getsPrice() {
        return sPrice;
    }

    public void setsPrice(Double sPrice) {
        this.sPrice = sPrice;
    }

    public String getsDiscount() {
        return sDiscount;
    }

    public void setsDiscount(String sDiscount) {
        this.sDiscount = sDiscount == null ? null : sDiscount.trim();
    }

    public String getsPictureurl() {
        return sPictureurl;
    }

    public void setsPictureurl(String sPictureurl) {
        this.sPictureurl = sPictureurl == null ? null : sPictureurl.trim();
    }

    public String getsBrand() {
        return sBrand;
    }

    public void setsBrand(String sBrand) {
        this.sBrand = sBrand == null ? null : sBrand.trim();
    }

    public String getsPlace() {
        return sPlace;
    }

    public void setsPlace(String sPlace) {
        this.sPlace = sPlace == null ? null : sPlace.trim();
    }

    public Integer getsImported() {
        return sImported;
    }

    public void setsImported(Integer sImported) {
        this.sImported = sImported;
    }

    public Integer getsScore() {
        return sScore;
    }

    public void setsScore(Integer sScore) {
        this.sScore = sScore;
    }

    public Date getsPdate() {
        return sPdate;
    }

    public void setsPdate(Date sPdate) {
        this.sPdate = sPdate;
    }

    public String getsQdate() {
        return sQdate;
    }

    public void setsQdate(String sQdate) {
        this.sQdate = sQdate == null ? null : sQdate.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getsCreatedate() {
        return sCreatedate;
    }

    public void setsCreatedate(Date sCreatedate) {
        this.sCreatedate = sCreatedate;
    }

    public String getsDese() {
        return sDese;
    }

    public void setsDese(String sDese) {
        this.sDese = sDese == null ? null : sDese.trim();
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType == null ? null : sType.trim();
    }

    public Integer getsNumber() {
        return sNumber;
    }

    public void setsNumber(Integer sNumber) {
        this.sNumber = sNumber;
    }
}