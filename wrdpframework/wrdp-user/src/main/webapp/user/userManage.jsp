<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/ria/riaconfig.jsp"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	@import "<%=path %>/ria/dojo-release-1.10.4/dojox/grid/resources/claroGrid.css";
	#gridDiv {
	    height: 20em;
	}
</style>
<script type="text/javascript" src="<%=path %>/user/userManage.js"></script>
	
<title>用户管理</title>
</head>
<body class="claro">
<div id="gridDiv"></div>
</body>
</html>