<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="panel panel-default">
	<div class="panel-heading">Inventory by Category</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Category</th>
				<th>Total Quantity</th>
				<th>Total Value</th>
				<th>Min Price</th>
				<th>Max Price</th>
				<th>Average Price</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="a">
			<tr>
				<td>${a[0]}</td>
				<td>${a[1]}</td>
				<td>${a[2]}</td>
				<td>${a[3]}</td>
				<td>${a[4]}</td>
				<td>${a[5]}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

