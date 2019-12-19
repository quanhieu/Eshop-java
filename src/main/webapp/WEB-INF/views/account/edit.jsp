<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h2>Edit Profile</h2>

<div class="alert alert-danger">${message}</div>

<form:form action="account/edit" modelAttribute="customer" enctype="multipart/form-data">
	<div class="form-group">
		<label>Username</label>
		<form:input path="id" class="form-control"/>
	</div>
	<form:hidden path="password"/>
	<form:hidden path="activated"/>
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
		<form:hidden path="photo"/>
		<img src="images/customers/${customer.photo}">
	</div>
	<div class="form-group">
		<button class="btn btn-default">
			<span class="glyphicon glyphicon-log-in"></span> Register
		</button>
	</div>
</form:form>