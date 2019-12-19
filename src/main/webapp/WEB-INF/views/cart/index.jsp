<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<h2>GIỎ HÀNG</h2>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Unit Price</th>
			<th>Quantity</th>
			<th>Amount</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="item" items="${sessionScope['scopedTarget.cart'].items }">
		<tr>
			<td>${item.id}</td>
			<td>${item.name}</td>
			<td>${item.unitPrice}</td>
			<td><input value="${item.quantity}" type="number" min="1" style="width:50px" 
									data-cart-update="${item.id}" data-cart-price="${item.unitPrice}"></td>
			<td class="nn-amount">${item.quantity*item.unitPrice}</td>
			<td>
				<button class="btn btn-default btn-sm" data-cart-remove="${item.id}">
					<span class="glyphicon glyphicon-trash"></span>
				</button>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<a class="btn btn-default" href="cart/clear">
	<span class="glyphicon glyphicon-trash"></span> Clear
</a>
<a class="btn btn-default" href="order/checkout">
	<span class="glyphicon glyphicon-trash"></span> Checkout
</a>