<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="taglib.jsp"%>
<html>
<head>
<title>Welcome</title>

<link href="${rootURL}resources/bootstrap/css/bootstrap.css" media="screen" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${rootURL}resources/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${rootURL}resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/app.js"></script>

</head>
<body>

<h2>Welcome  </h2>
<h3>Email: <sec:authentication property="name"/></h3>
<h3>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="${rootUrl}admin">Administration</a>
	</sec:authorize>
</h3>
<p>	<a href="${rootUrl}user">用户注册</a></p>
<p>	<a href="${rootUrl}queryuser">用户查询</a></p>
<p>	<a href="${rootUrl}orgmanage">组织管理</a></p>
<p>	<a href="${rootUrl}menumanage">菜单管理</a></p>
<p>	<a href="${rootUrl}rolemanage">角色管理</a></p>
<p>	<a href="${rootUrl}logout">Logout</a></p>
</body>
</html>