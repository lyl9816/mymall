package com.snack.pojo.domain;

import java.util.Set;

import com.snack.pojo.OrderDetail;

public class DoMyOrder {
	
		private Integer id;

	    private String oId;

	    private Integer uId;

	    private Integer eId;

	    private String oTime;
	    
	    private Integer rId;

	    private Integer oType;
	    
	    private String oName;

	    private String oPhone;

	    private String oAddress;
    
    private Set<OrderDetail> orderdetailSet;
    
    public DoMyOrder (){
    	
    }
    
    public DoMyOrder(Set<OrderDetail> orderdetailSet) {
		super();
		this.setOrderdetailSet(orderdetailSet);
	}
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
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
		this.oId = oId;
	}


	public String getoName() {
		return oName;
	}


	public void setoName(String oName) {
		this.oName = oName;
	}


	public String getoPhone() {
		return oPhone;
	}


	public void setoPhone(String oPhone) {
		this.oPhone = oPhone;
	}


	public String getoAddress() {
		return oAddress;
	}


	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}


	public Integer getuId() {
		return uId;
	}


	public void setuId(Integer uId) {
		this.uId = uId;
	}


	public String getoTime() {
		return oTime;
	}


	public void setoTime(String oTime) {
		this.oTime = oTime;
	}


	public Integer getoType() {
		return oType;
	}


	public void setoType(Integer oType) {
		this.oType = oType;
	}


	public Set<OrderDetail> getOrderdetailSet() {
		return orderdetailSet;
	}


	public void setOrderdetailSet(Set<OrderDetail> orderdetailSet) {
		this.orderdetailSet = orderdetailSet;
	}
}
