<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<h2><s:message code="login.title"/></h2>

<div class="alert alert-danger">${message}</div>

<form action="account/login" method="post">
	<div class="form-group">
		<label><s:message code="login.username"/></label>
		<input name="id" class="form-control" value="${userid}">
	</div>
	<div class="form-group">
		<label><s:message code="login.password"/></label>
		<input name="password" class="form-control" value="${pass}">
	</div>
	<div class="form-group">
		<div class="form-control">
			<label>
				<input type="checkbox" name="remember">
				<s:message code="login.remember"/>
			</label>
		</div>
	</div>
	<div class="form-group">
		<button class="btn btn-default">
			<span class="glyphicon glyphicon-log-in"></span> <s:message code="login.button"/>
		</button>
	</div>
</form>