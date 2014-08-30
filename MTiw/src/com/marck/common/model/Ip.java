package com.marck.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="userip")
public class Ip {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String ip1;
	@Column
	private String ip2;
	@Column
	private String ip3;
	@Column
	private String ip4;
	@Column
	private Integer isLock;
	@Column
	private String endTime;
	
	public String getEndTime() {
		return null == endTime ? "" : endTime;
	
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getId() {
		return null == id ? 0 : id;
	
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp1() {
		return null == ip1 ? "" : ip1;
	
	}
	public void setIp1(String ip1) {
		this.ip1 = ip1;
	}
	public String getIp2() {
		return null == ip2 ? "" : ip2;
	
	}
	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}
	public String getIp3() {
		return null == ip3 ? "" : ip3;
	
	}
	public void setIp3(String ip3) {
		this.ip3 = ip3;
	}
	public String getIp4() {
		return null == ip4 ? "" : ip4;
	
	}
	public void setIp4(String ip4) {
		this.ip4 = ip4;
	}
	public Integer getIsLock() {
		return null == isLock ? 0 : isLock;
	
	}
	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}
	
	
}
