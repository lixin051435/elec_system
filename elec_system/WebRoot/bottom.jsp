<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>底部bottom</title>
<link href="${pageContext.request.contextPath }/css/css.css" type="text/css" rel="stylesheet" />
<style>
#footer{font-size:12px;}
.footer_pad{padding:7px 9px 5px 9px;}
</style>
</head>
<body style="overflow-x:hidden; background:url(images/main/bottombg.jpg) repeat-x top left;" onselectstart="return false" oncontextmenu=return(false) >
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="footer">
</table>
</body>
</html>