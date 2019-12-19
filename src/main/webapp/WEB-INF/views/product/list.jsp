<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<h2>SẢN PHẨM</h2>

<c:forEach var="item" items="${list}">
	<div class="col-sm-4">
		<div class="panel panel-default nn-prod">
			<div class="panel-heading">${item.name}</div>
			<div class="panel-body">
				<a href="product/detail/${item.id}">
					<img src="images/products/${item.image}">
				</a>
			</div>
			<div class="panel-footer">
				<div class="row">
					<div class="pull-left">${item.unitPrice}</div>
					<div class="pull-right">
							<button class="btn btn-success btn-sm" data-cart-add="${item.id}">
								<span class="glyphicon glyphicon-shopping-cart"></span>
							</button>
							<button class="btn btn-danger btn-sm" data-favorite="${item.id}">
								<span class="glyphicon glyphicon-heart"></span>
							</button>
							<button data-toggle="modal" data-target="#dialog" class="btn btn-info btn-sm" data-send="${item.id}">
								<span class="glyphicon glyphicon-envelope"></span>
							</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:forEach>

<style>
.panel-footer>.row{
	padding-left: 5px;
	padding-right: 5px;
	font-family: impact;
	font-size: 20px;
	color: darkgray;
}
</style>

<jsp:include page="dialog.jsp"/>