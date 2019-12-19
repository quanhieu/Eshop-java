<%@ page pageEncoding="utf-8" %>

<h2>Forgot Password</h2>

<div class="alert alert-danger">${message}</div>

<form action="account/forgot" method="post">
	<div class="form-group">
		<label>Username</label>
		<input name="id" class="form-control">
	</div>
	<div class="form-group">
		<label>Email Address</label>
		<input name="email" class="form-control">
	</div>
	<div class="form-group">
		<button class="btn btn-default">
			<span class="glyphicon glyphicon-log-in"></span> Get Password
		</button>
	</div>
</form>