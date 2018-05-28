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
        <h1>员工信息表</h1>
    </div>
	<table id="mytab" border="1" class="t1">
		<thead>
			<th>员工编号</th>
			<th>员工姓名</th>
			<th>员工密码</th>
			<th>所在部门</th>
			<th>职位</th>
			<th>联系方式</th>
			<th>修改操作</th>
			<th>删除操作</th>
		</thead>
		<c:forEach var="user" items="${sessionScope.users }">
			<tr>
				<td>${user.user_id }</td>
				<td>${user.name }</td>
				<td>${user.password }</td>
				<td>${user.department }</td>
				<td>${user.emp }</td>
				<td>${user.tel }</td>
				<td><a href="${pageContext.request.contextPath }/BusinessServlet?op=removeUser&user_id=${user.user_id }">删除</a></td>
				<td><a href="${pageContext.request.contextPath }/BusinessServlet?op=toUpdateUser&user_id=${user.user_id }">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
