<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<form:form action="admin/${ctrl}/index" modelAttribute="model">
	<div class="form-group">
		<label>Id</label>
		<form:input path="id" class="form-control" readonly="true" placeholder="Auto Number"/>
	</div>
	<div class="form-group">
		<label>Customer</label>
		<form:input path="customer.id" class="form-control"/>
	</div>
	<div class="form-group">
		<label>Address</label>
		<form:input path="address" class="form-control"/>
	</div>
	<div class="form-group">
		<label>Order Date</label>
		<form:input path="orderDate" class="form-control"/>
	</div>
	<div class="form-group">
		<label>Amount</label>
		<form:input path="amount" class="form-control"/>
	</div>
	<div class="form-group">
		<label>Description</label>
		<form:textarea path="description" class="form-control" rows="4"></form:textarea>
	</div>
	<div class="form-group">
	<jsp:include page="../shared/buttons.jsp"/>
	</div>
</form:form>

<c:if test="${!empty model.orderDetails}">
	<h3>CHI TIẾT ĐƠN HÀNG</h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Unit Price</th>
				<th>Quantity</th>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="d" items="${model.orderDetails}">
			<tr>
				<td>${d.product.id}</td>
				<td>${d.product.name}</td>
				<td>${d.unitPrice}</td>
				<td>${d.quantity}</td>
				<td>${d.unitPrice*d.quantity}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</c:if>