<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addOrUpdate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    
    <%@include file="../../common.jsp" %>
    
    <link href="css/lib/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet">
    
    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/new-user.css" type="text/css" media="screen" />


    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
  </head>
  
  <body style="background-color: white;">
    <div id="myBody">
    	<div class="container-fluid">
            <div id="pad-wrapper" class="new-user">
                <div class="row-fluid header" style="border-bottom:1px solid #edeef1 ;box-shadow:0px 3px 4px -1px #fafafa;">
                    <ul class="breadcrumb" style="background-color: white;margin-bottom: 0;">
					  <li><a href="welcome.jsp">首页</a> <span class="divider">/</span>
							</li>
							<li class="active"><a href="${url }"
								style="cursor: pointer;"> IP限制</a> <span class="divider">/</span>
							</li>
							
							<li class="active">${title }</li>
					</ul>
                </div>

                <div class="row-fluid form-wrapper">
                    <!-- left column -->
                    <div class="span9 with-sidebar">
                        <div class="container">
                            <form class="new_user_form inline-input" id="myForm" action="bg/operate!updateNotice" method="post"  />
                            	<input type="hidden" name="notice.id" value="${ip.id }"/>
                                <div class="span12 field-box">
                                    <label>IP:</label>
                                     <input class="span1" id="title"
											type="text" name="notice.title" 
											placeholder="*必填" value="${ip.ip1 }" onkeyup="validIp(this)"/>
											<input class="span1" id="title"
											type="text" name="notice.title" 
											placeholder="*必填" value="${ip.ip2 }" onkeyup="validIp(this)"/>
											<input class="span1" id="title"
											type="text" name="notice.title" 
											placeholder="*必填" value="${ip.ip3 }" onkeyup="validIp(this)"/>
											<input class="span1" id="title"
											type="text" name="notice.title" 
											placeholder="*必填" value="${ip.ip4 }" onkeyup="validIp(this)"/>
											<span style="color: red;">可以填入*，代表匹配所有，例如：192.168.1.*</span>
									<div class="tooltip fade right in" style="display: none;">
										<div class="tooltip-arrow"></div>
										<div class="tooltip-inner" style="max-width: 300px;">请填写IP</div>
									</div>
                                </div>
                                 <div class="span12 field-box">
                                    <label>时间:</label>
                                    <input class="span3 form_datetime" id="title"
											type="text" name="notice.title" 
											placeholder="*必填" value="${ip.endTime }" />
                                </div>
                                <div class="span12 field-box">
										<label>是否限制:</label>
										<div class="slider-frame primary">
											<span id="isTopButton" data-on-text="是" data-off-text="否"
												class="slider-button">否</span> <input id="isTop"
												type="hidden" name="commodity.isTop" value="${ip.isLock}" />
										</div>
									</div>
                                <div class="span11 field-box actions">
                                    <input type="button" class="btn-flat primary" value="提 交" onclick="myValid(this)" />
                                    <span>或者</span> <a
										class="btn-flat default" href="${url }">返回</a>
                                </div>
                                <script type="text/javascript">
                                function myValid(t){
                                	validSubmit(t,'myForm','title');
                                }
                                
                                </script>
                                
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    
    <!-- Modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">提示信息</h3>
	  </div>
	  <div class="modal-body">
	    <p id="tipContent"></p>
	  </div>
	  <div class="modal-footer">
	  	<a id="sure" class="btn-flat primary" data-dismiss="modal" aria-hidden="true" >确定</a>
	  
	    <%--<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	    <button class="btn btn-primary">确定</button>
	  --%></div>
	</div>
          
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js" ></script>
			<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script type="text/javascript">
		$(function(){
			if('${msg}' != ''){
				$('#tipContent').html('${msg}');
				$('#myModal').modal('show');
			}
			
			if ($("#isTop").val() == "" || $("#isTop").val() != 1) {
				$("#isTop").val(2);
			} else {
				$("#isTopButton").addClass('on').html(
						$("#isTopButton").data("on-text"));
			}
			
			// Switch slide buttons
			$("#isTopButton").click(function() {
				if ($(this).hasClass("on")) {
					$("#isTop").val(2);
					$(this).removeClass('on').html($(this).data("off-text"));
				} else {
					$("#isTop").val(1);
					$(this).addClass('on').html($(this).data("on-text"));
				}
			});
			
			
			$("#myPassword").blur(function(){
				 if($(this).val() != ""){
					 $(this).next().hide();
				 }
			 });
		});
		
		// datepicker plugin
        $('.form_datetime').datetimepicker({
        	 	language:  'zh-CN',
			    format: 'yyyy-mm-dd hh:ii'
		 	});
     </script>
  </body>
</html>
