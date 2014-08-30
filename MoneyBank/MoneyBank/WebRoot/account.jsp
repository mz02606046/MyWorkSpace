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

    <!-- this page specific styles -->
    <link rel="stylesheet" href="css/compiled/index.css" type="text/css" media="screen" />
    
    <link rel="stylesheet" href="css/menu.css" type="text/css"  />

	
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
                    <form id="searchForm" action="${url }" method="post" >
					
                    <div class="row-fluid filter-block">
                    	
                    	
                        <div class="pull-right">
                           <input name="queryValue" type="text" class="search" style="background-image: url('');" value="${queryValue }"   /><img src="img/lens.png" style="margin:0 60px 0 -84px;cursor: pointer;" onclick="search()" />
                        
                           <script type="text/javascript">
                           function search(){
                        	   $("#searchForm").submit();
                           }
                           </script><%--
                            <a class="btn-flat new-product" href="bg/system!goAddOrUpdateAccount">+ 新 增</a>
                        --%></div>
                        
                    </div>
 				</form>
                    <div class="row-fluid">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                	<th class="span3">
                                        	id
                                    </th>
                                    <th class="span3">
                                   		 <span class="line"></span>
                                        	电话
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	当前积分
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	ip
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	推荐总积分
                                    </th>
                                     <th class="span3">
                                        <span class="line"></span>
                                        	果盟总积分
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	巨朋总积分
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	米迪总积分
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	有米总积分
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	触控总积分
                                    </th>
                                     <th class="span3">
                                        <span class="line"></span>
                                        	磨盘总积分
                                    </th>
                                     <th class="span3">
                                        <span class="line"></span>
                                        	点入总积分
                                    </th>
                                     <th class="span3">
                                        <span class="line"></span>
                                        	易积分总积分
                                    </th>
                                     <th class="span3">
                                        <span class="line"></span>
                                        	安沃总积分
                                    </th>
                                     <th class="span3">
                                        <span class="line"></span>
                                        	点乐总积分
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	多盟总积分
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	力美总积分
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	趣米总积分
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	手心总积分
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	万普总积分
                                    </th>
                                    <th class="span3">
                                        <span class="line"></span>
                                        	指盟总积分
                                    </th>
                                     <th class="span3">
                                        <span class="line"></span>
                                        	快友总积分
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- row -->
                                <c:set var="i" value="1" scope="page"></c:set>
                                <c:set var="temp" value="first" scope="page"></c:set>
                                <c:forEach items="${pu.data }" var="pd" >
                                	<c:if test="${i != 1 }">
                                		<c:set var="temp" value="" scope="page"></c:set>
                                	</c:if>
                                	<c:set var="i" value="${i + 1 }" scope="page" ></c:set>
                                	<tr class="${temp }" style="height: 50px;" >
                                		<td>
								          ${pd.id }
	                                    </td>
	                                    <td>
	                                        ${pd.phone }
	                                    </td>
	                                    <td>
	                                        ${pd.integral }
	                                    </td>
	                                    <td>
	                                        <a href="bg/query!showIp?id=${pd.id }">查看</a>
	                                    </td>
	                                    <td>
	                                        ${pd.tj }
	                                    </td>
	                                    <td>
	                                         ${pd.gm }
	                                    </td>
	                                    <td>
	                                        ${pd.jp }
	                                    </td>
	                                    <td>
	                                        ${pd.md }
	                                    </td>
	                                    <td>
	                                        ${pd.ym }
	                                    </td>
	                                    <td>
	                                        ${pd.ck }
	                                    </td>
	                                    <td>
	                                        ${pd.mp }
	                                    </td>
	                                    <td>
	                                        ${pd.dr }
	                                    </td>
	                                    <td>
	                                        ${pd.yjf }
	                                    </td>
	                                    <td>
	                                        ${pd.aw }
	                                    </td>
	                                    <td>
	                                        ${pd.dl }
                                        </td>
                                        <td>
	                                        ${pd.dm }
                                        </td>
                                        <td>
	                                        ${pd.lm }
                                        </td>
                                        <td>
	                                        ${pd.qm }
                                        </td>
                                        <td>
	                                        ${pd.sx }
                                        </td>
                                        <td>
	                                        ${pd.wp }
                                        </td>
                                        <td>
	                                        ${pd.zm }
                                        </td>
	                                    <td>
	                                        ${pd.ky }
	                                        <ul class="actions">
	                                           <li class="last"><i class="table-delete" onclick="del('${pd.id }')"></i></li>
	                                        </ul>
	                                        <script type="text/javascript">
	                                        function del(id){
	                            				$('#myModal').modal('show');
	                            				
	                            				$('#sure').attr("href","bg/query!delAccount?id="+id+"&queryValue=${queryValue }");
	                                        }
	                                        </script>
	                                    </td>
	                                </tr>
                                </c:forEach>
                                
                            </tbody>
                        </table>
                    </div>
                    <div class="pagination">
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
                </div>
                <!-- end table sample -->
            </div>
            
            
			<!-- Modal -->
			<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-header">
			    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			    <h3 id="myModalLabel">提示信息</h3>
			  </div>
			  <div class="modal-body">
			    <p id="tipContent">确定删除此用户？若删除该用户的相关数据将一并删除,是否确认？</p>
			  </div>
			  <div class="modal-footer">
			  	<a class="btn-flat white" data-dismiss="modal" aria-hidden="true">关闭</a>
			  	<a id="sure" class="btn-flat primary" >确定</a>
			  
			    <%--<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
			    <button class="btn btn-primary">确定</button>
			  --%></div>
			</div>
            
            
            <script type="text/javascript" src="js/bootstrap.min.js"></script>
            
    </div>
  </body>
</html>
