<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航menu</title>
<link href="${pageContext.request.contextPath }/css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/sdmenu.js"></script>
<script type="text/javascript">
	// <![CDATA[
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();
	};
	// ]]>
</script>
<style type=text/css>
html{ SCROLLBAR-FACE-COLOR: #538ec6; SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0; SCROLLBAR-SHADOW-COLOR: #2c6daa; SCROLLBAR-3DLIGHT-COLOR: #dce5f0; SCROLLBAR-ARROW-COLOR: #2c6daa;  SCROLLBAR-TRACK-COLOR: #dce5f0;  SCROLLBAR-DARKSHADOW-COLOR: #dce5f0; overflow-x:hidden;}
body{overflow-x:hidden; background:url(images/main/leftbg.jpg) left top repeat-y #f2f0f5; width:194px;}
</style>
</head>
<body onselectstart="return false;" ondragstart="return false;" oncontextmenu="return false;">
<div id="left-top">
	<div><img src="${pageContext.request.contextPath }/images/main/member.gif" width="44" height="44" /></div>
    <span>用户：${sessionScope.admin.name }<br>角色：超级管理员</span>
</div>
    <div style="float: left" id="my_menu" class="sdmenu">
      <div class="collapsed">
        <span>用户管理</span>
        <a href="${pageContext.request.contextPath }/page/adminshowme.jsp" target="mainFrame" onFocus="this.blur()">我的信息</a>
        <a href="${pageContext.request.contextPath }/page/showAllUsers.jsp" target="mainFrame" onFocus="this.blur()">人员管理</a>
      </div>
      <div>
        <span>故障管理</span>
        <a href="${pageContext.request.contextPath }/page/statusManage.jsp" target="mainFrame" onFocus="this.blur()">状态管理</a>
        <a href="${pageContext.request.contextPath }/page/addStatus.jsp" target="mainFrame" onFocus="this.blur()">添加实时情况</a>
      </div>
    </div>
</body>
</html>