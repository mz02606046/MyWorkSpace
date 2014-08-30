package com.marck.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marck.common.dao.HDB;
import com.marck.common.model.Apply;
import com.marck.common.model.User;
import com.marck.common.model.UserIntergral;
import com.marck.common.model.UserIntergralQuery;

@Component("queryService")
@Transactional(readOnly = true,propagation=Propagation.REQUIRED)
public class QueryService {

	@Autowired
	private HDB hdb;
	
	public Boolean checkPassword(String password) {
		// TODO Auto-generated method stub
		try {
			String hql = "from User u where u.phone ='admin'";
			List<User> users = (List<User>) hdb.findHql(hql);
			if(users.size() > 0){
				if( users.get(0).getPassword().equals(CommonUtil.Md5(password))){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public PageUtil findAccountList(String queryValue, Integer pageNow,
			Integer limit) {
		// TODO Auto-generated method stub.
		String hql = "from User u where u.phone <> 'admin' ";
		if(!CommonUtil.validParams(queryValue)){
			hql += " and ( u.phone like '%"+queryValue+"%' or u.integral like '%"+queryValue+"%' or u.lastlogin like '%"+queryValue+"%')";
		}
		
		PageUtil pu = hdb.findHql(hql, pageNow, limit);
		
		for(User u : (List<User>)pu.getData()){
			String sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 1 and ui.userId ="+u.getId();
			u.setTj( (Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 2 and ui.userId ="+u.getId();
			u.setGm((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 3 and ui.userId ="+u.getId();
			u.setJp((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 4 and ui.userId ="+u.getId();
			u.setMd((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 5 and ui.userId ="+u.getId();
			u.setYm((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 6 and ui.userId ="+u.getId();
			u.setCk((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 7 and ui.userId ="+u.getId();
			u.setMp((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 8 and ui.userId ="+u.getId();
			u.setDr((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 9 and ui.userId ="+u.getId();
			u.setYjf((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 10 and ui.userId ="+u.getId();
			u.setAw((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 11 and ui.userId ="+u.getId();
			u.setDl((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 12 and ui.userId ="+u.getId();
			u.setDm((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 13 and ui.userId ="+u.getId();
			u.setLm((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 14 and ui.userId ="+u.getId();
			u.setQm((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 15 and ui.userId ="+u.getId();
			u.setSx((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 16 and ui.userId ="+u.getId();
			u.setWp((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 17 and ui.userId ="+u.getId();
			u.setZm((Double) hdb.findUniqueSql(sql));
			sql = "select sum(ui.intergral) from userintergral ui where ui.platform = 18 and ui.userId ="+u.getId();
			u.setKy((Double) hdb.findUniqueSql(sql));
		}
		
		return pu;
	}

	public PageUtil findApplyList(String queryValue, Integer pageNow,
			Integer limit) {
		// TODO Auto-generated method stub
		String hql = "select a from Apply a,User u where a.userId = u.id ";
		if(!CommonUtil.validParams(queryValue)){
			hql += " and ( a.id like '%"+queryValue+"%' or a.userId like '%"+queryValue+"%' or a.account like '%"+queryValue+"%'  or a.num like '%"+queryValue+"%'  or a.name like '%"+queryValue+"%' or a.addTime like '%"+queryValue+"%' or u.phone like '%"+queryValue+"%') ";
		}
		
		hql += " order by a.status asc";
		
		PageUtil pu = hdb.findHql(hql, pageNow, limit);
		for(Apply a : (List<Apply>)pu.getData()){
			User u = (User) hdb.find(User.class, a.getUserId());
			a.setUserName(u.getPhone());
		}
		
		return pu;
	}

	@Transactional(readOnly = false,propagation=Propagation.REQUIRED)
	public void delAccount(Integer id) {
		// TODO Auto-generated method stub
		String hql ="from Apply a where a.userId = "+id;
		List<Apply> as = (List<Apply>) hdb.findHql(hql);
		for(Apply a : as){
			hdb.delete(a);
		}
		hql ="from UserIntergral ui where ui.userId = "+id;
		List<UserIntergral> uis = (List<UserIntergral>) hdb.findHql(hql);
		for(UserIntergral ui : uis){
			hdb.delete(ui);
		}
		
		User u = (User) hdb.find(User.class, id);
		
		hdb.delete(u);
		
	}

	@Transactional(readOnly = false,propagation=Propagation.REQUIRED)
	public void delApply(Integer id) {
		// TODO Auto-generated method stub
		Apply a = (Apply) hdb.find(Apply.class, id);
		a.setStatus(1);
		hdb.saveOrUpdate(a);
	}

	/**
	 * 查询用户ip列表
	 * @param id 
	 * @param pageNow
	 * @param limit
	 * @return
	 */
	public PageUtil findUserIp(String id, Integer pageNow, Integer limit) {
		// TODO Auto-generated method stub
		String hql = "from UserIp ui where ui.userId="+Integer.parseInt(id);
		return hdb.findHql(hql, pageNow, limit);
	}
	
	public void myStatistics(String type, String timestart, String timeend, String qd, String username, Map<String, Object> map) {
		// TODO Auto-generated method stub
		String sql = "";
		
		if(type.equals("3")){
			sql = "select count(*),sum(ui.intergral) from userintergral ui,user u where ui.userId=u.id and u.phone = '"+username+"'";
		}else{
			sql = "select count(*),sum(ui.intergral) from userintergral ui where 1=1 ";
		}
		
		if(type.equals("2")){
			sql += " and ui.platform ='"+Integer.parseInt(qd)+"'";
		}
		
		if(!CommonUtil.validParams(timestart)){
			sql += " and ui.time >='"+timestart+"'";
		}

		if(!CommonUtil.validParams(timeend)){
			sql += " and ui.time <='"+timeend+"'";
		}
		
		List<Object[]> objs =  (List<Object[]>) hdb.findSql(sql);
		
		map.put("num", objs.get(0)[0]);
		map.put("integral", objs.get(0)[1]);
		
	}
}
