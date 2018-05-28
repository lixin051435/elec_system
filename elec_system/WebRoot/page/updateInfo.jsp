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
		function updateInfo(){
			var date = $("#date").text();
			var ia1 = $("#ia1").text();
			var ia2 = $("#ia2").text();
			var ib1 = $("#ib1").text();
			var ib2 = $("#ib2").text();
			var ic1 = $("#ic1").text();
			var ic2 = $("#ic2").text();
			$.ajax({
				type:"post",
                url:"${pageContext.request.contextPath }/BusinessServlet",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                data:{"op": "updateInfo","date":date,"ia1":ia1,"ia2":ia2,"ib1":ib1,"ib2":ib2,"ic1":ic1,"ic2":ic2},
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
			<th>时间</th>
			<th>母线a相一端电流</th>
			<th>母线a相另一端电流</th>
			<th>母线b相一端电流</th>
			<th>母线b相另一端电流</th>
			<th>母线c相一端电流</th>
			<th>母线c相另一端电流</th>
			<th>状态</th>
			<th>操作</th>
		</thead>
			<tr>
				<td id="date">${sessionScope.updateInfo.date }</td>
				<td id="ia1" contentEditable="true">${sessionScope.updateInfo.ia1 }</td>
				<td id="ia2" contentEditable="true">${sessionScope.updateInfo.ia2 }</td>
				<td id="ib1" contentEditable="true">${sessionScope.updateInfo.ib1 }</td>
				<td id="ib2" contentEditable="true">${sessionScope.updateInfo.ib2 }</td>
				<td id="ic1" contentEditable="true">${sessionScope.updateInfo.ic1 }</td>
				<td id="ic2" contentEditable="true">${sessionScope.updateInfo.ic2 }</td>
				<td>${sessionScope.updateInfo.status }</td>
				<td><a id="updateInfo" onclick="updateInfo()">提交</a></td>
			</tr>
	</table>
  </body>
</html>
