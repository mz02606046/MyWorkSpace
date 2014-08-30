package com.marck.bg.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.marck.bg.service.OperateService;
import com.marck.bg.service.QueryService;
import com.marck.common.BaseAction;
import com.marck.common.CommonUtil;
import com.marck.common.PageUtil;
import com.marck.common.dao.HDB;
import com.marck.common.model.Ip;
import com.marck.common.model.Notice;
import com.marck.common.model.User;

@Component("operateAction")
@Scope("prototype")
public class OperateAction extends BaseAction{

	private PageUtil pu;
	private Integer pageNow;
	private Integer limit;
	
	private String queryValue;
	
	private Integer id;
	private Notice notice;
	private Ip ip;
	
	@Autowired
	private OperateService operateService;
	
	/**
	 * 查看公告
	 * @return
	 */
	public String selNotice(){
		try {
			
			String resUrl = request.getRequestURI();
			request.getSession().setAttribute("url", resUrl.substring(resUrl.indexOf("/",1)+1)+"?");
			
			notice = operateService.selNotice();
			
			return "selNotice";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ERROR;
	}
	
	/**
	 * 更新公告
	 * @return
	 */
	public String updateNotice(){
		try {
			
			operateService.updateNotice(notice);
			
			request.setAttribute("msg", "修改成功！");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return selNotice();
	}
	
	/**
	 * 查看公告
	 * @return
	 */
	public String selIp(){
		try {
			
			String resUrl = request.getRequestURI();
			request.getSession().setAttribute("url", resUrl.substring(resUrl.indexOf("/",1)+1)+"?");
			
			pu = operateService.selIp(pageNow,limit);
			
			return "selIp";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ERROR;
	}
	
	/**
	 * 查看公告
	 * @return
	 */
	public String goAddOrUpdateIp(){
		try {
			if( CommonUtil.validParams(ip) ){
				request.setAttribute("title", "添加IP");
			}else{
				ip = operateService.getInfo(ip);
				request.setAttribute("title", "修改IP");
			}
			return "goAddOrUpdateIp";
		} catch (Exception e) {
			// TODO: handle exception
			log.error("添砖到资讯添加修改页面出错！",e);
		}
		return ERROR;
	}
	
	
	public PageUtil getPu() {
		return pu;
	
	}

	public void setPu(PageUtil pu) {
		this.pu = pu;
	}

	public Integer getPageNow() {
		return pageNow;
	
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getLimit() {
		return limit;
	
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getQueryValue() {
		return queryValue;
	
	}

	public void setQueryValue(String queryValue) {
		this.queryValue = queryValue;
	}

	public Integer getId() {
		return id;
	
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Notice getNotice() {
		return notice;
	
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Ip getIp() {
		return ip;
	
	}

	public void setIp(Ip ip) {
		this.ip = ip;
	}
	
	
	
	
}
