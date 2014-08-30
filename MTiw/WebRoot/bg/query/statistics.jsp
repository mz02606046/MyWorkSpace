<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'table.jsp' starting page</title>
    
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
    <link rel="stylesheet" href="css/compiled/index.css" type="text/css" media="screen" />
    
  </head>
  
  <body style="background-color: white;">
  <div id="myBody">
    <div id="pad-wrapper">
   <ul class="breadcrumb" style="background-color: white;margin-bottom: 0;">
	  <li>首页</li>
	</ul>
                <!-- table sample -->
                <!-- the script for the toggle all checkboxes from header is located in js/theme.js -->
                <div class="table-products section" style="margin-top: 0;">
                    <form id="searchForm" action="bg/query!statistics" method="post" >
					
                    <div class="row-fluid filter-block">

                        <div class="pull-right">
                        
                        	<div class="ui-select span3">
								<select name="type" id="type" onchange="changeType(this)">
									<option value="1" selected="selected">时间统计</option>
									<option value="2">渠道统计</option>
									<option value="3">用户统计</option>
								</select>
							</div>
                        	
                        	<div class="ui-select span3" id="qddiv" style="display: none;">
								<select name="qd" id="qd">
									<option value="1" selected="selected">推荐</option>
									<option value="2" >果盟</option>
									<option value="3">巨朋</option>
									<option value="4">迷迪</option>
									<option value="5">有米</option>
									<option value="6">触控</option>
									<option value="7">磨盘</option>
									<option value="8">点入</option>
									<option value="9">易积分</option>
									<option value="10">安沃</option>
									<option value="11">点乐</option>
									<option value="12">多盟</option>
									<option value="13">力美</option>
									<option value="14">趣米</option>
									<option value="15">手心</option>
									<option value="16">万普</option>
									<option value="17">指盟</option>
									<option value="18">快友</option>
								</select>
							</div>
                            
                            <input id="username" name="username" placeholder="请填写完整的用户名" type="text" style="display: none;height: 15px;margin-bottom: 0px;" value="${username }"   />
                            
                            <input id="timestart" name="timestart" placeholder="起始时间" type="text" class="search form_datetime" style="margin-right:10px;background-image: url('');" value="${timestart }"   />--
         					<input id="timeend" name="timeend" placeholder="结束时间" type="text" class="search form_datetime" style="margin-right:10px;background-image: url('');" value="${timeend }"   />
                            
                            <input class="btn-flat new-product" onclick="search()" type="submit" value="统	计" />
                            
                             <script type="text/javascript">
                             function changeType(t){
                            	 if($(t).val() == 1){
                            		 $("#username").hide();
                            		 $("#qddiv").hide();
                            	 }
                            	 if( $(t).val() == 2){
                            		 $("#username").hide();
                         			$("#qddiv").show();
                         		}
                         		if( $(t).val() == 3){
                         			$("#qddiv").hide();
                         			$("#username").show();
                         		}
                             }
                             
	                           function search(){
	                        	   $("#searchForm").submit();
	                           }
                           </script>
                        </div>
                        
                    </div>
 				</form>
                    <div class="row-fluid">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                	<th class="span3">
                                        	起始时间
                                    </th>
                                    <th class="span3">
                                   		 <span class="line"></span>
                                        	结束时间
                                    </th>
                                     <th class="span3">
                                   		 <span class="line"></span>
                                        	总积分
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	总数量
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- row -->
                                <c:set var="i" value="1" scope="page"></c:set>
                                <c:set var="temp" value="first" scope="page"></c:set>
                                	<c:if test="${i != 1 }">
                                		<c:set var="temp" value="" scope="page"></c:set>
                                	</c:if>
                                	<c:set var="i" value="${i + 1 }" scope="page" ></c:set>
                                	<tr class="${temp }" style="height: 50px;" >
                                		<td>
								          ${timestart }
	                                    </td>
	                                    <td>
	                                        ${timeend }
	                                    </td>
	                                     <td>
	                                     	${integral }
	                                    </td>
	                                    <td>
	                                     	${num }
	                                    </td>
	                                </tr>
                                
                            </tbody>
                        </table>
                    </div>
                    <%--<div class="pagination">
                    	<ul >
								<c:choose>
									<c:when test="${pu.isFrist }"><li><a id="pageFirst" >&laquo;</a></li></c:when>
									<c:otherwise>
										<li><a id="pageFirst" href="${url }&pageNow=1&queryValue=${queryValue}">&laquo;</a></li></c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${pu.hasPre }">
										<li  ><a id="pagePre" href="${url }&pageNow=${pu.pageNow - 1}&queryValue=${queryValue}">&lsaquo;</a></li>
									</c:when>
									<c:otherwise><li  ><a id="pagePre">&lsaquo;</a></li></c:otherwise>
								</c:choose>
								<c:forEach items="${pu.navigatePages }" var="pnp">
									<c:choose>
										<c:when test="${pu.pageNow == pnp }"><li><a class="active"><c:out value="${pnp }"></c:out></a></li>
											</c:when>
										<c:otherwise>
											<li><a href="${url }&pageNow=${pnp}&queryValue=${queryValue}"> <c:out
														value="${pnp }"></c:out> </a></li></c:otherwise>
									</c:choose>
								</c:forEach>
								<c:choose>
									<c:when test="${pu.hasNext }">
										<li  ><a id="pageNext" href="${url }&pageNow=${pu.pageNow + 1}&queryValue=${queryValue}">&rsaquo;</a>
										</li></c:when>
									<c:otherwise><li  ><a  id="pageNext" >&rsaquo;</a></li></c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${pu.isLast }"><li><a id="pageLast" >&raquo;</a></li></c:when>
									<c:otherwise>
										<li><a id="pageLast" href="${url }&pageNow=${pu.pageTotal}&queryValue=${queryValue}">&raquo;</a></li></c:otherwise>
								</c:choose>
							</ul>
                    </div>
                --%></div>
                <!-- end table sample -->
            </div>
            
            <br/>
            <br/>
            <br/>
            
			<!-- Modal -->
			<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			    <h3 id="myModalLabel">提示信息</h3>
			  </div>
			  <div class="modal-body">
			    <p id="tipContent">确定处理此记录？</p>
			  </div>
			  <div class="modal-footer">
			  	<a class="btn-flat white" data-dismiss="modal" aria-hidden="true">关闭</a>
			  	<a id="sure" class="btn-flat primary" >确定</a>
			  
			    <%--<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			    <button class="btn btn-primary">确定</button>
			  --%></div>
			</div>
            
            <script type="text/javascript" src="js/bootstrap.min.js"></script>
           <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js" ></script>
			<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
            <script type="text/javascript">
            $(function(){
            	if("${type}" == null || "${type}" == ""){
            		$("#type").val(1);
            	}else{
            		if( "${type}" == 2){
            			$("#qddiv").show();
            		}
            		if( "${type}" == 3){
            			$("#username").show();
            		}
            		
            		$("#type").val("${type}");
            	}
            	
            	if("${qd}" == null || "${qd}" == ""){
            		$("#qd").val(1);
            	}else{
            		$("#qd").val("${qd}");	
            	}
            	
            });
            
            // datepicker plugin
            $('.form_datetime').datetimepicker({
            	 	language:  'zh-CN',
				    format: 'yyyy-mm-dd hh:ii'
			 	});
            </script>
    </div>
  </body>
</html>
