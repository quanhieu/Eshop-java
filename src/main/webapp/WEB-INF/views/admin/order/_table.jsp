<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<table class="table table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Customer</th>
			<th>Order Date</th>
			<th>Address</th>
			<th>Amount</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="item" items="${items}">
		<tr>
			<td>${item.id}</td>
			<td>${item.customer.id}</td>
			<td>${item.orderDate}</td>
			<td>${item.address}</td>
			<td>${item.amount}</td>
			<td>
				<a class="btn btn-default btn-sm" href="admin/${ctrl}/edit/${item.id}">
					<span class="glyphicon glyphicon-edit"></span>
				</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>