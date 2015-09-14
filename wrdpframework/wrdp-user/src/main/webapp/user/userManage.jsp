<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/ria/riaconfig.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	@import "<%=path %>/ria/dojox/grid/resources/claroGrid.css";
	#gridDiv {
	    height: 20em;
	}
</style>
<script type="text/javascript" src="<%=path %>/user/userManage.js"></script>
	
<title>用户管理</title>
</head>
<body class="claro">
<spring:message code="aaa"></spring:message>
<table data-dojo-type="dojox.grid.DataGrid" >
  <thead>
    <tr>
      <th field="fieldName" width="200px">用户名</th>
      <th field="fieldName" width="200px">密码</th>
    </tr>
  </thead>
</table>
<div id="gridDiv"></div>
</body>
</html>