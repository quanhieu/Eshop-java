<%@ page pageEncoding="utf-8" %>

<h2>Change Password</h2>

<div class="alert alert-danger">${message}</div>

<form action="account/change" method="post">
	<div class="form-group">
		<label>Username</label>
		<input name="id" class="form-control">
	</div>
	<div class="form-group">
		<label>Current Password</label>
		<input name="password" class="form-control">
	</div>
	<div class="form-group">
		<label>New Password</label>
		<input name="password1" class="form-control">
	</div>
	<div class="form-group">
		<label>Confirm New Password</label>
		<input name="password2" class="form-control">
	</div>
	<div class="form-group">
		<button class="btn btn-default">
			<span class="glyphicon glyphicon-log-in"></span> Change Password
		</button>
	</div>
</form>