package com.marck.common.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="notice")
public class Notice {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String content;
	@Column
	private String addTime ;
	@Column
	private String title;
	
	public Integer getId() {
		return null == id ? 0 : id;
	
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return null == content ? "" : content;
	
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddTime() {
		return null == addTime ? "" : addTime;
	
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getTitle() {
		return null == title ? "" : title;
	
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
}
