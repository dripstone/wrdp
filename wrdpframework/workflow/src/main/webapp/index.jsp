<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<c:url var="rootURL" value="/"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${rootURL}jquery-2.1.4.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function save() {
	jQuery.ajax({
		type : 'POST', 
		contentType : 'application/json',  
		url : '${rootURL}test/save',  
		processData : false,
		data : JSON.stringify({
				businessName:$("#businessName").val(),
				businessID:$("#businessID").val(),
				wfDefinitionID:$("#wfDefinitionID").val(),
				userAccount:$("#userAccount").val()
			}),  
		success : function(data) {  
			debugger;
		},  
		error : function() {  
		    alert('Err...');  
		}  
	});
}
</script>
</head>
<body>
<form:form id="testForm" method="post" action="${rootURL}test/save" enctype="application/x-www-form-urlencoded">
	<table>
		<tr>
			<td>业务主键</td>
			<td><input type="text" id="businessID" name="businessID" placeholder="businessID" /></td>
		</tr>
		<tr>
			<td>业务名称</td>
			<td><input type="text" id="businessName" name="businessName" placeholder="businessName" /></td>
		</tr>
		<tr>
			<td>流程模板ID</td>
			<td><input type="text" id="wfDefinitionID" name="wfDefinitionID" placeholder="wfDefinitionID" /></td>
		</tr>
		<tr>
			<td>操作用户</td>
			<td><input type="text" id="userAccount" name="userAccount" placeholder="userAccount" /></td>
		</tr>
	</table>
	<button type="button" value="提交" onclick="save()">提交</button>
	<button type="submit" value="Submit" >Submit</button>
</form:form>
<form action="${rootURL}test/save" method="post">
<table>
<tr>
    <td width="160">业务主键</td>
    <td width="160">业务名称</td>
    <td width="160">任务ID</td>
</tr>
<c:forEach items="${rf}" var="testDTO">  
<tr>  
    <td><c:out value="${testDTO.businessID}"/></td>  
    <td><c:out value="${testDTO.businessName}"/></td>  
    <td><c:out value="${testDTO.wfDefinitionID}"/></td>  
</tr>  
</c:forEach>  
</table>  
</form>  
</body>
</html>