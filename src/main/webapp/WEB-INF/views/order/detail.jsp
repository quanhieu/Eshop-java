<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



<h2>ĐẶT HÀNG</h2>
<form:form action="order/purchase" modelAttribute="order">
	<div class="form-group">
		<label>Id</label>
		<form:input path="id" cssClass="form-control" readonly="true" placeholder="AutoNumber"/>
	</div>
	<div class="form-group">
		<label>Customer</label>
		<form:input path="customer.id" cssClass="form-control" readonly="true"/>
	</div>
	<div class="form-group">
		<label>Order Date</label>
		<form:input path="orderDate" cssClass="form-control" readonly="true"/>
	</div>
	<div class="form-group">
		<label>Address</label>
		<form:input path="address" cssClass="form-control" readonly="true"/>
	</div>
	<div class="form-group">
		<label>Total Amount</label>
		<form:input path="amount" cssClass="form-control" readonly="true"/>
	</div>
	<div class="form-group">
		<label>Description</label>
		<form:textarea path="description" rows="4" cssClass="form-control" readonly="true"></form:textarea>
	</div>
</form:form>

<h2>CÁC MẶT HÀNG ĐÃ CHỌN</h2>
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
	<c:forEach var="item" items="${order.orderDetails}">
		<tr>
			<td>${item.product.id}</td>
			<td>${item.product.name}</td>
			<td>${item.unitPrice}</td>
			<td>${item.quantity}</td>
			<td>${item.quantity*item.unitPrice}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>