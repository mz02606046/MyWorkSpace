<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>下载</title>
	
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />	
	
	<meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta content="black" name="apple-mobile-web-app-status-bar-style" />
	 
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	
    <%--<link rel="stylesheet" type="text/css" href="luck.css">
    --%>
    
    <style>
    
    body{
    	margin: 0 auto;
    	max-width: 700px;
    	padding: 0;
    }
    
    a{
    display: block;
    width: 90%;
    margin: 5%;
    text-align: center;
    background: rgb(59,159,243);
    border-radius:5px;
    height: 40px;
    -moz-border-radius:5px;
    -webkit-border-radius:5px;
    border: 1px solid rgb(56, 131, 192,0.8);
    line-height: 40px;
    color: white;
    text-decoration: none;
    }
    
    .aimg{
    	background: url("img/andorid.png") no-repeat;
    	background-size:25px;
    	width: 28px;
    	height:25px;
    	display: inline-block;
    }
    
    .iimg{
    	background: url("img/ios.png") no-repeat;
    	background-size:23px;
    	width: 28px;
    	height:24px;
    	display: inline-block;
    }
    
    
    </style>
  </head>
  
  <body>
  
  <%--<a href="http://www.anzhi.com/soft_1396491.html" class="andorid"><i class="aimg"></i>安卓下载</a>
  --%><a href="itms-services://?action=download-manifest&url=https://www.joowill.com/app/marck.plist" class="ios"><i class="iimg"></i>苹果下载</a>
  
  </body>
</html>
	
	