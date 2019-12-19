<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

	<c:forEach var="item" items="${list}">
		<tr>
			<td>${item.id}</td>
			<td>${item.name}</td>
			<td>${item.unitPrice}</td>
			<td>${item.productDate}</td>
			<td>${item.quantity}</td>
			<td>${item.available?'Yes':'No'}</td>
			<td>${item.category.nameVN}</td>
			<td>${item.image}</td>
			<td>
				<a class="btn btn-default btn-sm" href="admin/${ctrl}/edit/${item.id}">
					<span class="glyphicon glyphicon-edit"></span>
				</a>
			</td>
		</tr>
	</c:forEach>
