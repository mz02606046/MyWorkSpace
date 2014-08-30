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
					  <li>首页 </li>
					</ul>
                </div>

                <div class="row-fluid form-wrapper">
                    <!-- left column -->
                    <div class="span9 with-sidebar">
                        <div class="container">
                            <form class="new_user_form inline-input" id="myForm" action="bg/operate!updateNotice" method="post"  />
                            	<input type="hidden" name="notice.id" value="${notice.id }"/>
                                <div class="span12 field-box">
                                    <label>标题:</label>
                                     <input class="span6" id="title"
											type="text" name="notice.title" 
											placeholder="*必填" value="${notice.title }" />
									<div class="tooltip fade right in" style="display: none;">
										<div class="tooltip-arrow"></div>
										<div class="tooltip-inner" style="max-width: 300px;">请填写到标题</div>
									</div>
                                </div>
                                 <div class="span12 field-box">
                                    <label>内容:</label>
                                    <textarea class="span6"  name="notice.content" >${notice.content }</textarea>
                                </div>
                                <div class="span11 field-box actions">
                                    <input type="button" class="btn-flat primary" value="提 交" onclick="myValid(this)" />
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
    
    <script type="text/javascript">
		$(function(){
			if('${msg}' != ''){
				$('#tipContent').html('${msg}');
				$('#myModal').modal('show');
			}
			
			$("#myPassword").blur(function(){
				 if($(this).val() != ""){
					 $(this).next().hide();
				 }
			 });
		});
     </script>
  </body>
</html>
