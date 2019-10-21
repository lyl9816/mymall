package com.snack.pojo;

import java.util.Set;

public class ReceiptInfo {
    private Integer rId;

    private String oId;

    private String oName;

    private String oPhone;

    private String oAddress;

    private Set<OrderDetail> orderdetailSet;

    public void setOrderdetailSet(Set<OrderDetail> orderdetailSet) {
        this.orderdetailSet = orderdetailSet;
    }
    public Set<OrderDetail> getOrderdetailSet() {
        return orderdetailSet;
    }
    public ReceiptInfo(){

    }

    public ReceiptInfo(Set<OrderDetail> orderdetailSet) {
        super();
        this.setOrderdetailSet(orderdetailSet);
    }


    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName == null ? null : oName.trim();
    }

    public String getoPhone() {
        return oPhone;
    }

    public void setoPhone(String oPhone) {
        this.oPhone = oPhone == null ? null : oPhone.trim();
    }

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress == null ? null : oAddress.trim();
    }
}