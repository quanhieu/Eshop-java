<%@ page pageEncoding="utf-8" %>

<button class="btn btn-default" formaction="admin/${ctrl}/create">
	<span class="glyphicon glyphicon-log-in"></span> Create
</button>
<button class="btn btn-default" formaction="admin/${ctrl}/update">
	<span class="glyphicon glyphicon-log-in"></span> Update
</button>
<a class="btn btn-default" href="admin/${ctrl}/delete/${model.id}">
	<span class="glyphicon glyphicon-log-in"></span> Delete
</a>
<a class="btn btn-default" href="admin/${ctrl}/index">
	<span class="glyphicon glyphicon-log-in"></span> Reset
</a>