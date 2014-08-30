package com.marck.common.model;

public class UserIntergralQuery {

	private Integer platform;
	private Double total;
	private String name;
	
	public String getName() {
		switch (platform) {
		case 1:
			return "推荐";
		case 2:
			return "点入";
		case 3:
			return "力美";
		case 4:
			return "米迪";
		case 5:
			return "有米";
		case 6:
			return "酷果";
		case 7:
			return "磨盘";
		case 8:
			return "果盟";
		case 9:
			return "安沃";
		case 10:
			return "触控";
		case 11:
			return "巨朋";
		case 12:
			return "万普";
		case 13:
			return "点乐";
		case 14:
			return "多盟";
		case 15:
			return "趣米";
		case 16:
			return "快友";
		case 17:
			return "手心";
		case 18:
			return "指盟";
		case 19:
			return "易积分";
		case 20:
			return "行云";
		default:
			return "未知";
		}
	
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPlatform() {
		return null == platform ? 0 : platform;
	
	}
	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
	public Double getTotal() {
		return null == total ? 0 : total;
	
	}
	public void setTotal(Double total) {
		this.total = total;
	}

	
	
}
