<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="keywords" content="scclui框架">
<title>首页</title>
<style type="text/css">
#s{
	align:right;
}
</style>


<link rel="stylesheet" href="${pageContext.request.contextPath }/common/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/common/css/sccl.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/mytable.css">

</head>

<body>
<div class="title">
        <h1>状态明细</h1>
    </div>
    
	<table id="mytab" border="1" class="t1">
		<thead>
			<th>时间</th>
			<th>母线a相一端电流</th>
			<th>母线a相另一端电流</th>
			<th>母线b相一端电流</th>
			<th>母线b相另一端电流</th>
			<th>母线c相一端电流</th>
			<th>母线c相另一端电流</th>
			<th>状态</th>
			<th>修改操作</th>
			<th>删除操作</th>
		</thead>
		<c:forEach var="info" items="${sessionScope.eleinfos }">
			<tr>
				<td>${info.date }</td>
				<td>${info.ia1 }</td>
				<td>${info.ia2 }</td>
				<td>${info.ib1 }</td>
				<td>${info.ib2 }</td>
				<td>${info.ic1 }</td>
				<td>${info.ic2 }</td>
				<td>${info.status }</td>
				<td><a href="${pageContext.request.contextPath }/BusinessServlet?op=removeInfo&date=${info.date }">删除</a></td>
				<td><a href="${pageContext.request.contextPath }/BusinessServlet?op=toUpdateInfo&date=${info.date }">修改</a></td>
			</tr>
		</c:forEach>
	</table>
	<a id="s" href = "${pageContext.request.contextPath }/BusinessServlet?op=toExcel">导出到csv</a>
</body>
</html>
