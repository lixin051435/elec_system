<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/common/layui/css/layui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/common/css/sccl.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/mytable.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
	<script>
		function updateUser(){
			var user_id = $("#user_id").text();
			var name = $("#name").text();
			var password = $("#password").text();
			var department = $("#department").text();
			var emp = $("#emp").text();
			var tel = $("#tel").text();
			$.ajax({
				type:"post",
                url:"${pageContext.request.contextPath }/BusinessServlet",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                data:{"op": "updateUser","user_id":user_id,"name":name,"password":password,"department":department,"emp":emp,"tel":tel},
                success:function(data){
                	alert("操作成功");
                	window.location.href = "${pageContext.request.contextPath}/" + data;
                },
                error:function(arr) {
                    alert("有错误");
                }
			});
			
		}
	</script>
  </head>
  
  <body>
  <div class="title">
        <h1>修改信息</h1>
    </div>
    <table id="mytab" border="1" class="t1">
		<thead>
			<th>员工编号</th>
			<th>员工姓名</th>
			<th>员工密码</th>
			<th>所在部门</th>
			<th>职位</th>
			<th>联系方式</th>
			<th></th>
		</thead>
			<tr>
				<td id="user_id" contentEditable="false">${sessionScope.updateUser.user_id }</td>
				<td id="name" contentEditable="true">${sessionScope.updateUser.name }</td>
				<td id="password" contentEditable="false">${sessionScope.updateUser.password }</td>
				<td id="department" contentEditable="true">${sessionScope.updateUser.department }</td>
				<td id="emp" contentEditable="true">${sessionScope.updateUser.emp }</td>
				<td id="tel" contentEditable="true">${sessionScope.updateUser.tel }</td>
				<td><a id="updateUser" onclick="updateUser()">提交</a></td>
			</tr>
	</table>
  </body>
</html>
