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


<link rel="stylesheet" href="${pageContext.request.contextPath }/common/layui/css/layui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/common/css/sccl.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/mytable.css">

</head>

<body>
<div class="title">
    <h1>我的信息</h1>
</div>
<table width="90%" id="mytab" border="1" class="t1">
		<thead>
			<th width="10%">编号</th>
			<th width="10%">姓名</th>
			<th width="10%">密码</th>
			<th width="10%">部门</th>
			<th width="10%">职位</th>
			<th width="10%">联系方式</th>
			<th width="10%">修改操作</th>
		</thead>
		<tr>
			<td>${sessionScope.user.user_id }</td>
			<td>${sessionScope.user.name }</td>
			<td>${sessionScope.user.password }</td>
			<td>${sessionScope.user.department }</td>
			<td>${sessionScope.user.emp }</td>
			<td>${sessionScope.user.tel }</td>
			<td><a href="${pageContext.request.contextPath }/BusinessServlet?op=toUpdateme&user_id=${sessionScope.user.user_id }">修改</a></td>
		</tr>
	</table>
</body>
</html>
