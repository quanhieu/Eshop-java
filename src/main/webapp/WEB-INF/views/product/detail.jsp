<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<h2>Product Details</h2>

<img src="images/products/${prod.image}">
<ul>
	<li>Id: ${prod.id}</li>
	<li>Name: ${prod.name}</li>
	<li>Unit Price: ${prod.unitPrice}</li>
	<li>Quantity: ${prod.quantity}</li>
	<li>Product Date: ${prod.productDate}</li>
	<li>Category: ${prod.category.nameVN}</li>
	<li>Available: ${prod.available?'Yes':'No'}</li>
</ul>
<div>${prod.description}</div>

<h2>The same category items</h2>

<div class="nn-thumbnail">
	<c:forEach var="item" items="${prod.category.products}">
		<a href="product/detail/${item.id}">
			<img src="images/products/${item.image}">
		</a>
	</c:forEach>
</div>