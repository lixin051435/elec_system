<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<meta name="keywords" content="scclui框架">
    <title>管理员登录</title>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/common/layui/css/layui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/common/css/sccl.css">
	<script type="text/javascript" src="script/jquery-1.4.4.min.js"></script>
    
  </head>
  
  <body class="login-bg">
    <div class="login-box">
        <header>
            <h1>电力故障推理系统</h1>
        </header>
        <div class="login-main">
        <p style="color: red; font-weight: 900">${requestScope.msg }</p>
			<form action="${pageContext.request.contextPath }/BusinessServlet?op=login&user_type=admin" class="layui-form" method="post">
				<input name="__RequestVerificationToken" type="hidden" value="">                
				<div class="layui-form-item">
					<input type="text" name="userName" lay-verify="userName" autocomplete="off" placeholder="这里输入登录名" class="layui-input">
				</div>
				<div class="layui-form-item">
					<input type="password" name="password" lay-verify="password" autocomplete="off" placeholder="这里输入密码" class="layui-input"><br />
				</div>
				<div class="layui-form-item">
					<div class="pull-left login-remember">
						<label>记住帐号？</label>

						<input type="checkbox" name="rememberMe" value="false" lay-skin="switch" title="记住帐号"><div class="layui-unselect layui-form-switch"><i></i></div>
					</div>
					<div class="pull-right">
						<input type="submit" onclick="handleSubmit()" value="登录" class="layui-btn layui-btn-primary" lay-submit="" lay-filter="login">
						</input>
					</div>
				</div>
			</form>        
    <script src="${pageContext.request.contextPath }/common/layui/layui.js"></script>
    <script>
        layui.use(['layer', 'form'], function () {
            var layer = layui.layer,
				$ = layui.jquery,
				form = layui.form();

            form.verify({
                userName: function (value) {
                    if (value === '')
                        return '请输入用户名';
                },
                password: function (value) {
                    if (value === '')
                        return '请输入密码';
                }
            });
        });
		
        
       
    </script>
  </body>
</html>
