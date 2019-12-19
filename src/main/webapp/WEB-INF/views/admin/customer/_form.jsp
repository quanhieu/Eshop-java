<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="admin/${ctrl}/index" modelAttribute="model" enctype="multipart/form-data">
	<div class="form-group">
		<label>Username</label>
		<form:input path="id" class="form-control" readonly="${!empty model.id}"/>
	</div>
	<div class="form-group">
		<label>Password</label>
		<form:input path="password" class="form-control"/>
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
		<input type="file" name="upphoto" class="form-control">
		<form:hidden path="photo"/>
	</div>
	<div class="form-group">
		<label>Activate?</label>
		<div class="form-control">
			<form:radiobutton path="activated" value="true" label="Yes"/>
			<form:radiobutton path="activated" value="false" label="No"/>
		</div>
	</div>

	<div class="form-group">
	<jsp:include page="../shared/buttons.jsp"/>
	</div>
</form:form>