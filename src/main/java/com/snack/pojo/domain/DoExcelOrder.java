package com.snack.pojo.domain;

public class DoExcelOrder {
	String oId;
	String oName;
	String oPhone;
	String oAddress;
	String sName;
	String num;
	String money;
	
	public String getOId() {
		return oId;
	}
	public void setOId(String oId) {
		this.oId = oId;
	}
	public String getOName() {
		return oName;
	}
	public void setOName(String oName) {
		this.oName = oName;
	}
	public String getOPhone() {
		return oPhone;
	}
	public void setOPhone(String oPhone) {
		this.oPhone = oPhone;
	}
	public String getOAddress() {
		return oAddress;
	}
	public void setOAddress(String oAddress) {
		this.oAddress = oAddress;
	}
	public String getSName() {
		return sName;
	}
	public void setSName(String sName) {
		this.sName = sName;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "DoExcelOrder [oId=" + oId + ", oName=" + oName + ", oPhone="
				+ oPhone + ", oAddress=" + oAddress + ", sName=" + sName
				+ ", num=" + num + ", money=" + money + "]";
	}
	
}
