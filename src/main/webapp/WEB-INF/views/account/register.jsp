<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h2>Login</h2>

<div class="alert alert-danger">${message}</div>

<form:form action="account/register" modelAttribute="customer" enctype="multipart/form-data">
	<div class="form-group">
		<label>Username</label>
		<form:input path="id" class="form-control"/>
	</div>
	<div class="form-group">
		<label>Password</label>
		<form:input path="password" class="form-control"/>
	</div>
	<div class="form-group">
		<label>Confirm Password</label>
		<input name="password2" class="form-control"/>
	</div>
	<div class="form-group">
		<label>Fullname</label>
		<form:input path="fullname" class="form-control"/>
	</div>
	<div class="form-group">
		<label>Email Address</label>
		<form:input path="email" class="form-control"/>
	</div>
	<div class="form-group">
		<label>Photo</label>
		<input type="file" name="upphoto" class="form-control"/>
	</div>
	<div class="form-group">
		<button class="btn btn-default">
			<span class="glyphicon glyphicon-log-in"></span> Register
		</button>
	</div>
</form:form>