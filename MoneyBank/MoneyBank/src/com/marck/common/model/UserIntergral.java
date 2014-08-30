package com.marck.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="userintergral")
public class UserIntergral {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private Integer userId;
	@Column
	private String adname;
	@Column
	private String orderid;
	@Column
	private String intergral;
	@Column
	private String time;
	@Column
	private String openudid;
	@Column
	private String price;
	@Column
	private Integer platform;
	@Transient
	private Integer total;
	
	public Integer getTotal() {
		return null == total ? 0 : total;
	
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getId() {
		return null == id ? 0 : id;
	
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return null == userId ? 0 : userId;
	
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAdname() {
		return null == adname ? "" : adname;
	
	}
	public void setAdname(String adname) {
		this.adname = adname;
	}
	public String getOrderid() {
		return null == orderid ? "" : orderid;
	
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public Integer getPlatform() {
		return null == platform ? 0 : platform;
	
	}
	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
	public String getTime() {
		return null == time ? "" : time;
	
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getIntergral() {
		return null == intergral ? "" : intergral;
	
	}
	public void setIntergral(String intergral) {
		this.intergral = intergral;
	}
	public String getOpenudid() {
		return null == openudid ? "" : openudid;
	
	}
	public void setOpenudid(String openudid) {
		this.openudid = openudid;
	}
	public String getPrice() {
		return null == price ? "" : price;
	
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
