<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="${rootURL}resources/bootstrap/css/bootstrap.css" media="screen" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${rootURL}resources/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${rootURL}resources/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${rootURL}resources/js/app.js"></script>
<script type="text/javascript">
function login() {
	jQuery.ajax({  
	type : 'POST',  
 //   headers: {
 //       Accept: "application/json"
 //   },
	//contentType : 'application/x-wisely',  
	contentType : 'application/json',  
	url : 'http://localhost:9090/console/rest/users/save',  
	//	url : 'http://localhost:9090/console/rest/users/save',  
	processData : false,  
	//dataType : 'json',  
	data : JSON.stringify({name:'test',id:33,email:'test',password:'test'}),  
	//data:"wang-yunfei",
	success : function(data) {  
		debugger;
	    alert("id: " + data.id + "\nname: " + data.name + "\nstatus: "  
	            + data.status);  
	},  
	error : function() {  
	    alert('Err...');  
	}  
});
alert(1); 
}
</script>
</head>
<body>
     <div class="row">
		<div class="col-md-6 col-md-offset-2">	
			<h2>User</h2>
			
			<form:form id="userForm" method="post" action="${rootURL}rest/users/save" modelAttribute="user" 
		class="form-horizontal" role="form" cssStyle="width: 800px; margin: 0 auto;">
		  <div class="form-group">
		    <label for="username" class="col-sm-2 control-label">UserName*</label>
		    <div class="col-sm-4">
		      <input type="text" id="username" name="username" class="form-control" placeholder="UserName" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="password" class="col-sm-2 control-label">Password*</label>
		    <div class="col-sm-4">
		      <input type="password" id="password" name="password" class="form-control" placeholder="Password" />
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-4">
		      <input type="submit" class="btn btn-primary" value="保存">
		      <input type="button" value="提交" onclick="login()">
		    </div>
		  </div>
		  
		</form:form>
	</div>
</div>

</body>
</html>