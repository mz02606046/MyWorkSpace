package com.marck.bg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marck.common.CommonUtil;
import com.marck.common.DateUtil;
import com.marck.common.PageUtil;
import com.marck.common.dao.HDB;
import com.marck.common.model.Apply;
import com.marck.common.model.Ip;
import com.marck.common.model.Notice;
import com.marck.common.model.User;
import com.marck.common.model.UserIntergral;
import com.marck.common.model.UserIntergralQuery;

@Component("operateService")
@Transactional(readOnly = false,propagation=Propagation.REQUIRED)
public class OperateService {

	@Autowired
	private HDB hdb;
	
	/**
	 * 查询公告
	 * @return
	 */
	@Transactional(readOnly = true,propagation=Propagation.REQUIRED)
	public Notice selNotice() {
		// TODO Auto-generated method stub
		Notice notice = (Notice) hdb.findUniqueHql("from Notice");
		return notice;
	}

	/**
	 * 更新公告
	 * @param notice
	 */
	public void updateNotice(Notice notice) {
		// TODO Auto-generated method stub
		notice.setAddTime(DateUtil.getNowString("yyyy-MM-dd"));
		hdb.saveOrUpdate(notice);
	}

	/**
	 * 查询限制ip
	 * @param limit 
	 * @param pageNow 
	 * @return
	 */
	public PageUtil selIp(Integer pageNow, Integer limit) {
		// TODO Auto-generated method stub
		return hdb.findAll(Ip.class, pageNow, limit);
	}

	/**
	 * 查询ip
	 * @param ip
	 * @return
	 */
	public Ip getInfo(Ip ip) {
		// TODO Auto-generated method stub
		return (Ip) hdb.find(Ip.class, ip.getId());
	}
	
}
