<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="admin/${ctrl}/index" modelAttribute="model">
	<div class="form-group">
		<label>Id</label>
		<form:input path="id" class="form-control" readonly="true" placeholder="Auto Number"/>
	</div>
	<div class="form-group">
		<label>Name</label>
		<form:input path="name" class="form-control"/>
	</div>
	<div class="form-group">
		<label>Name VN</label>
		<form:input path="nameVN" class="form-control"/>
	</div>
	<div class="form-group">
	<jsp:include page="../shared/buttons.jsp"/>
	</div>
</form:form>