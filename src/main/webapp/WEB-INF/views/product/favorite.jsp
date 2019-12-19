<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="panel panel-default">
	<div class="panel-heading">Your Favorite</div>
	<div class="panel-body nn-favorite text-center">
	<div class="row">
		<c:forEach var="item" items="${list}">
		<div class="col-sm-6">
			<a href="product/detail/${item.id}">
				<img src="images/products/${item.image}">
			</a>
		</div>
		</c:forEach>
	</div>
	</div>
</div>

<style>
	.nn-favorite img{
		height: 60px;
		max-width: 99%;
	}
	.nn-favorite .col-sm-6>a:hover{
		box-shadow:0 0 5px red;
	}
	.nn-favorite .col-sm-6{
		margin:0;
		padding:0px;
	}
	.nn-favorite .col-sm-6>a{
		display:block;
		box-shadow:0 0 3px blue;
		border-radius: 5px;
		margin: 10px;
		padding: 5px;
	}
</style>