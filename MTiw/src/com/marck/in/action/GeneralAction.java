package com.marck.in.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.marck.common.BaseAction;
import com.marck.common.CommonUtil;
import com.marck.common.DateUtil;
import com.marck.common.Jpush;
import com.marck.common.model.User;
import com.marck.common.model.Apply;
import com.marck.in.service.GeneralService;

@Component("generalAction")
@Scope("prototype")
public class GeneralAction extends BaseAction {

	@Autowired
	private GeneralService generalService;
	
	
	private Map<String, Object> map = new HashMap<String, Object>();
	
	private Apply apply;
	private Integer pageNo;
	private Integer pageNum;
	
	/**
	 * 接收用户token
	 */
	public String updateToken(){
		try {
			
			String userId = request.getParameter("userId");
			String token = request.getParameter("token");
			
			if( CommonUtil.validParams(token) ){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			generalService.updateToken(userId,token,map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询评论列表异常",e);
			map.put("msg", "更新异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}
	
	/**
	 * 申请提现
	 */
	public String apply(){
		try {
			
			if( apply == null || CommonUtil.validParams(apply.getUserId(),apply.getAccount(),apply.getNum(),apply.getType()) ){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			generalService.apply(apply,map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询评论列表异常",e);
			map.put("msg", "查询异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}
	
	/**
	 * 查询用户
	 * @return
	 */
	public String selUser(){
		try {
			
			String userId = request.getParameter("userId");
			
			if( CommonUtil.validParams(userId) ){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			generalService.selUserIntergral(userId,map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询用户积分异常",e);
			map.put("msg", "查询异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}
	
	/**
	 * 查询用户积分
	 * @return
	 */
	public String selUserIntergral(){
		try {
			
			String userId = request.getParameter("userId");
			
			if( CommonUtil.validParams(userId) ){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			generalService.selUserIntergral(userId,map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询用户积分异常",e);
			map.put("msg", "查询异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}
	
	/**
	 * 查询用户明细
	 * @return
	 */
	public String selUserDetail(){
		try {
			
			String userId = request.getParameter("userId");
			String type = request.getParameter("type");//1赚取,推广明细，2获取兑奖明细
			String platForm = request.getParameter("platForm");
			
			if( CommonUtil.validParams(userId,type) ){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			generalService.selUserDetail(userId,type,platForm,pageNo,pageNum,map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询用户积分异常",e);
			map.put("msg", "查询异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}
	
	/**
	 * 查询用户申请
	 * @return
	 */
	public String selUserApply(){
		try {
			
			String userId = request.getParameter("userId");
			
			if( CommonUtil.validParams(userId) ){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			generalService.selUserApply(userId,pageNo,pageNum,map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询用户积分异常",e);
			map.put("msg", "查询异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}
	
	/**
	 * 查询用户申请
	 * @return
	 */
	public String sign(){
		try {
			
			String userId = request.getParameter("userId");
			
			if( CommonUtil.validParams(userId) ){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			generalService.sign(userId,map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询用户积分异常",e);
			map.put("msg", "查询异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}
	
	/**
	 * 查询用户申请
	 * @return
	 */
	public String modifyPassword(){
		try {
			
			String userId = request.getParameter("userId");
			String oldpw = request.getParameter("oldpw");
			String newpw = request.getParameter("newpw");
			
			if( CommonUtil.validParams(userId,oldpw,newpw) ){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			generalService.modifyPassword(userId,oldpw,newpw,map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("查询用户积分异常",e);
			map.put("msg", "查询异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}
	
	/**
	 * 赠送积分
	 * @return
	 */
	public String giveOther(){
		try {
			
			String userId = request.getParameter("userId");
			String other = request.getParameter("other");
			String num = request.getParameter("num");
			
			if( CommonUtil.validParams(userId,other,num) ){
				map.put("msg", "缺少必传参数");
				map.put("code", 0);
				return SUCCESS;
			}
			
			generalService.giveOhter(userId,other,num,map);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("赠送积分异常",e);
			map.put("msg", "赠送异常");
			map.put("code", 0);
		}
		return SUCCESS;
	}
	
	
	/**
	 * 点入
	 * @return
	 */
	public String dr(){
		try {

			String userId = request.getParameter("userid");
			String openudid = request.getParameter("deviceid");
			String points = request.getParameter("point");
			String adname = request.getParameter("adname");
			String orderId = request.getParameter("hashid");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,null,2,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "点入平台,应用《"+CommonUtil.changeIos8859ToUtf8(adname)+"》获得"+points+"积分");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("发送信息异常",e);
			map.put("message", "失败");
			map.put("success", false);
		}
		return SUCCESS;
	}
	
	/**
	 * 力美
	 * @return
	 */
	public String lm(){
		try {
			
			String userId = request.getParameter("aid");
			String openudid = request.getParameter("uid");
			String points = request.getParameter("point");
			String adname = request.getParameter("title");
			String orderId = request.getParameter("orderId");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,null,3,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "力美平台,应用《"+adname+"》获得"+points+"积分");
			}
			
			map.put("code", 200);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("发送信息异常",e);
			map.put("code", 500);
		}
		return SUCCESS;
	}
	
	
	/**
	 * 迷迪
	 * @return
	 */
	public String md(){
		try {
			
			String userId = request.getParameter("param0");
			String openudid = request.getParameter("imei");
			String points = request.getParameter("cash");
			String adname = request.getParameter("appName");
			String orderId = request.getParameter("trand_no");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,null,4,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "迷迪平台,应用《"+CommonUtil.changeIos8859ToUtf8(adname)+"》获得"+points+"积分");
			}

			PrintWriter pt = response.getWriter();
			pt.print("200");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				PrintWriter pt = response.getWriter();
				pt.print("403");
				log.error("发送信息异常",e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 有米
	 * @return
	 */
	public String ym(){
		try {
			
			String userId = request.getParameter("user");
			String openudid = request.getParameter("device");
			String points = request.getParameter("points");
			String adname = request.getParameter("ad");
			String orderId = request.getParameter("order");
			String price = request.getParameter("price");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,price,5,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "有米平台,应用《"+CommonUtil.changeIos8859ToUtf8(adname)+"》获得"+points+"积分");
			}
			
			PrintWriter pt = response.getWriter();
			pt.print("200");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				PrintWriter pt = response.getWriter();
				pt.print("403");
				log.error("发送信息异常",e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	
	/**
	 * 酷果接口
	 * @return
	*/
	public String kg(){
		try {
			
			String userId = request.getParameter("userId");
			String openudid = request.getParameter("idfa");
			String points = request.getParameter("points");
			String adname = request.getParameter("advertName");
			String price = request.getParameter("price");
			String orderId = request.getParameter("orderId");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,price,6,map)){
				generalService.myPush(userId,request.getRealPath("/app"),"酷果平台,应用《"+adname+"》获得"+points+"积分");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("发送信息异常",e);
			map.put("message", "无效数据");
			map.put("success", false);
		}
		return SUCCESS;
	}
	
	/**
	 * 磨盘
	 * @return
	 */
	public String mp(){
		try {
			
			String userId = request.getParameter("param0");
			String openudid = request.getParameter("imei");
			String points = request.getParameter("cash");
			String adname = request.getParameter("appShowName");
			String orderId = request.getParameter("trand_no");
			
//			String id = request.getParameter("id");
//			String sign = request.getParameter("sign");
//			
//			StringBuffer mySign=  new StringBuffer();
//			mySign.append(id).append(orderId).append(points).append(userId==null?"":userId).append(key);
//			
//			String md5 = CommonUtil.Md5(mySign);
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,null,7,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "磨盘平台,应用《"+CommonUtil.changeIos8859ToUtf8(adname)+"》获得"+points+"积分");
			}
			
			PrintWriter pt = response.getWriter();
			pt.print("success");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				PrintWriter pt = response.getWriter();
				pt.print("fail");
				log.error("发送信息异常",e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 果盟广告
	 * @return
	 */
	public String gm(){
		try {
			
			String userId = request.getParameter("other");
			String openudid = request.getParameter("openudid");
			String points = request.getParameter("points");
			String adname = request.getParameter("ad");
			String orderId = request.getParameter("order");
			String price = request.getParameter("price");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,price,8,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "果盟平台,应用《"+CommonUtil.changeIos8859ToUtf8(adname)+"》获得"+points+"积分");
			}
			
			PrintWriter pt = response.getWriter();
			pt.print("200");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				PrintWriter pt = response.getWriter();
				pt.print("403");
				log.error("发送信息异常",e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 安沃
	 * @return
	*/
	public String aw(){
		try {
			
			String userId = request.getParameter("keyword");
			String openudid = request.getParameter("idfa");
			if(CommonUtil.validParams(openudid)){
				openudid = request.getParameter("imei");
			}
			String points = request.getParameter("point");
			String adname = request.getParameter("adname");
			String ts = request.getParameter("ts");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),ts+openudid,null,9,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "安沃平台,应用《"+CommonUtil.changeIos8859ToUtf8(adname)+"》获得"+points+"积分");
			}
			
			PrintWriter pt = response.getWriter();
			pt.print("200");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				PrintWriter pt = response.getWriter();
				pt.print("403");
				log.error("发送信息异常",e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 触控
	 * @return
	*/
	public String ck(){
		try {
			
			String userId = request.getParameter("token");
			String openudid = request.getParameter("mac");
			String points = request.getParameter("coins");
			String adname = request.getParameter("adtitle");
			String orderId = request.getParameter("transactionid");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,null,10,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "触控平台,应用《"+CommonUtil.changeIos8859ToUtf8(adname)+"》获得"+points+"积分");
			}
			
			PrintWriter pt = response.getWriter();
			pt.print("200");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				PrintWriter pt = response.getWriter();
				pt.print("403");
				log.error("发送信息异常",e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 巨朋
	 * @return
	*/
	public String jp(){
		try {
			
			String userId = request.getParameter("userdef");
			String openudid = request.getParameter("udid");
			String points = request.getParameter("score");
			String adname = request.getParameter("adShowName");
			String orderId = request.getParameter("follow");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,null,11,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "巨朋平台,应用《"+CommonUtil.changeIos8859ToUtf8(adname)+"》获得"+points+"积分");
			}
			
			PrintWriter pt = response.getWriter();
			pt.print("success");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				PrintWriter pt = response.getWriter();
				pt.print("fail");
				log.error("发送信息异常",e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	} 
	
	
	/**
	 * 万普接口
	 * @return
	*/
	public String wp(){
		try {
			
			String userId = request.getParameter("key");
			String openudid = request.getParameter("open_udid");
			String points = request.getParameter("points");
			String adname = request.getParameter("ad_name");
			String orderId = request.getParameter("order_id");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,null,12,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "万普平台,应用《"+adname+"》获得"+points+"积分");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("发送信息异常",e);
			map.put("message", "无效数据");
			map.put("success", false);
		}
		return SUCCESS;
	}
	 
	
	
	
	/**
	 * 点乐
	 * @return
	*/
	public String dl(){
		try {
			
			String userId = request.getParameter("snuid");
			String openudid = request.getParameter("device_id");
			String points = request.getParameter("currency");
			String adname = request.getParameter("ad_name");
			String pack_name = request.getParameter("pack_name");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),openudid+pack_name,null,13,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "点乐平台,"+adname+"获得"+points+"积分");
			}
			
			PrintWriter pt = response.getWriter();
			pt.print("200");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				PrintWriter pt = response.getWriter();
				pt.print("403");
				log.error("发送信息异常",e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		return null;
	} 

	
	
	/**
	 * 多盟
	 * @return
	*/
	public String dm(){
		try {
			
			String userId = request.getParameter("user");
			String openudid = request.getParameter("device");
			String points = request.getParameter("point");
			String adname = request.getParameter("ad");
			String orderId = request.getParameter("orderid");
			String price = request.getParameter("price");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,price,14,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "多盟平台,应用《"+adname+"》获得"+points+"积分");
			}
			
			PrintWriter pt = response.getWriter();
			pt.print("200");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				PrintWriter pt = response.getWriter();
				pt.print("403");
				log.error("发送信息异常",e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	/**
	 * 趣米
	 * @return
	 */
	public String qm(){
		try {
			
			String userId = request.getParameter("user");
			String openudid = request.getParameter("device");
			String points = request.getParameter("points");
			String adname = request.getParameter("ad");
			String orderId = request.getParameter("order");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,null,15,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "趣米平台,应用《"+CommonUtil.changeIos8859ToUtf8(adname)+"》获得"+points+"积分");
			}
			
			PrintWriter pt = response.getWriter();
			pt.print("200");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				PrintWriter pt = response.getWriter();
				pt.print("403");
				log.error("发送信息异常",e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 快友
	 * @return
	 */
	public String ky(){
		try {
			
			String userId = request.getParameter("userId");
			String openudid = request.getParameter("device");
			String points = request.getParameter("points");
			String adname = request.getParameter("dan");
			String orderId = request.getParameter("order");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,null,16,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "快友平台,应用《"+CommonUtil.changeIos8859ToUtf8(adname)+"》获得"+points+"积分");
			}
			
			PrintWriter pt = response.getWriter();
			pt.print("200");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				PrintWriter pt = response.getWriter();
				pt.print("403");
				log.error("发送信息异常",e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 手心广告
	 * @return
	 */
	public String sx(){
		try {
			
			String userId = request.getParameter("param0");
			String openudid = request.getParameter("mac");
			String points = request.getParameter("cash");
			String adname = request.getParameter("appName");
			String orderId = request.getParameter("trand_no");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,null,17,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "手心平台,应用《"+CommonUtil.changeIos8859ToUtf8(adname)+"》获得"+points+"积分");
			}
			
			PrintWriter pt = response.getWriter();
			pt.print("200");
			
		} catch (Exception e) {
			// TODO: handle exception
			try {
				PrintWriter pt = response.getWriter();
				pt.print("403");
				log.error("发送信息异常",e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	/**
	 * 指盟
	 * @return
	*/
	public String zm(){
		try {
			
			String userId = request.getParameter("UID");
			String openudid = request.getParameter("OPENUDID");
			String points = request.getParameter("POINTS");
			String adname = request.getParameter("APPNAME");
			String orderId = request.getParameter("TID");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),orderId,null,18,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "指盟平台,应用《"+adname+"》获得"+points+"积分");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("发送信息异常",e);
			map.put("message", "无效数据");
			map.put("success", false);
		}
		return SUCCESS;
	} 
	
	/**
	 * 易积分
	 * @return
	*/
	public String yjf(){
		try {
			
			String userId = request.getParameter("userID");
			String openudid = request.getParameter("idfa");
			String points = request.getParameter("score");
			String adname = request.getParameter("adName");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),null,null,19,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "易积分平台,应用《"+adname+"》获得"+points+"积分");
			}
			
			map.put("message", "成功");
			map.put("success", true);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("发送信息异常",e);
			map.put("message", "失败");
			map.put("success", false);
		}
		return SUCCESS;
	} 
	
	/**
	 * 行云
	 * @return
	*/
	public String xy(){
		try {
			
			String userId = request.getParameter("userID");
			String openudid = request.getParameter("idfa");
			String points = request.getParameter("score");
			String adname = request.getParameter("appName");
			
			if(generalService.addIntergral(userId,openudid,points,adname,DateUtil.getNowString("yyyy-MM-dd HH:mm:ss"),null,null,20,map)){
				generalService.myPush(userId,request.getRealPath("/app"), "行云平台,应用《"+adname+"》获得"+points+"积分");
			}
			
			map.put("message", "数据接受成功");
			map.put("success", true);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("发送信息异常",e);
			map.put("message", "失败");
			map.put("success", false);
		}
		return SUCCESS;
	} 
	
	public Integer getPageNo() {
		return pageNo;
	
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageNum() {
		return pageNum;
	
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Map<String, Object> getMap() {
		return map;//null == map?"":map;
	
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Apply getApply() {
		return apply;
	
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}

}
