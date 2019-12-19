<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<h2>DANH SÁCH ĐƠN HÀNG CỦA BẠN</h2>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Customer</th>
			<th>Order Date</th>
			<th>Amount</th>
			<th>Address</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="item" items="${orders}">
		<tr>
			<td>${item.id}</td>
			<td>${item.customer.id}</td>
			<td>${item.orderDate}</td>
			<td>${item.amount}</td>
			<td>${item.address}</td>
			<td>
				<a href="order/detail/${item.id}">Details</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th>Total: ?</th>
		</tr>
	</tfoot>
</table>
