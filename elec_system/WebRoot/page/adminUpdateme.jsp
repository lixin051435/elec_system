<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改个人信息</title>
    
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
		function updateAdmin(){
			var admin_id = $("#admin_id").text();
			var name = $("#name").text();
			var password = $("#password").text();
			var emp = $("#emp").text();
			var tel = $("#tel").text();
			$.ajax({
				type:"post",
                url:"${pageContext.request.contextPath }/BusinessServlet",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                data:{"op": "updateAdminme","admin_id":admin_id,"name":name,"password":password,"emp":emp,"tel":tel},
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
        <h1>修改 个人信息</h1>
    </div>
    <table id="mytab" border="1" class="t1">
		<thead>
			<th>员工编号</th>
			<th>员工姓名</th>
			<th>员工密码</th>
			<th>职位</th>
			<th>联系方式</th>
			<th></th>
		</thead>
			<tr>
				<td id="admin_id" contentEditable="false">${sessionScope.adminme.admin_id }</td>
				<td id="name" contentEditable="true">${sessionScope.adminme.name }</td>
				<td id="password" contentEditable="true">${sessionScope.adminme.password }</td>
				<td id="emp" contentEditable="true">${sessionScope.adminme.emp }</td>
				<td id="tel" contentEditable="true">${sessionScope.adminme.tel }</td>
				<td><a id="updateAdmin" onclick="updateAdmin()">提交</a></td>
			</tr>
	</table>
  </body>
</html>
