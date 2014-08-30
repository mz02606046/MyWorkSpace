<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	    <!-- bootstrap -->
    <link href="css/bootstrap/bootstrap.css" rel="stylesheet" />
    <link href="css/bootstrap/bootstrap-responsive.css" rel="stylesheet" />

    <!-- global styles -->
    <link rel="stylesheet" type="text/css" href="css/layout.css" />
    <link rel="stylesheet" type="text/css" href="css/elements.css" />
    <link rel="stylesheet" type="text/css" href="css/icons.css" />

    <!-- libraries -->
    <link rel="stylesheet" type="text/css" href="css/lib/font-awesome.css" />
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/signin.css" type="text/css" media="screen" />
	
  </head>
  
  <body class="login-bg" >
  
  	
  
    <div class="row-fluid login-wrapper">
    	<div style="display: block;font-size: 40px;margin-bottom: 40px;font-weight: bolder;color: white;" >
			<img src="img/logo-empty.png" width="200px"/>
		</div>

        <div class="span4 box">
            <div class="content-wrap">
                <h4 style="font-weight: bolder;margin-bottom: 20px;" >登&nbsp;录</h4>
                <form id="myForm" action="bg/query!login" method="post" style="margin: 0;" >
                <input id="password" name="password" class="span12" type="password" placeholder="请输入密码" />
                </form>
                <div id="tip" style="margin-bottom: 8px;color: red;" >${msg }&nbsp;</div>
                <button class="btn-glow primary login" style="font-size: 20px;" onclick="valid()" >登&nbsp;录</button>
                <script type="text/javascript">
                function valid(){
                	
                	if( "" == $("#password").val() ){
                		$("#tip").html("*请填写密码！");
                		return;
                	}
                	
                	$("#myForm").submit();
                	
                }
                </script>
            </div>
        </div>
		
    </div>
	
	

	<!-- scripts -->
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/theme.js"></script>

  </body>
</html>
