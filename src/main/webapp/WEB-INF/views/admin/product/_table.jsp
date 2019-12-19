<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<script src="js/search.js"></script>

<div id="search">
	<input placeholder="Min Price">
	<input placeholder="Max Price">
	<button>Search</button>
	<button id="asc">ASC</button>
	<button id="desc">DESC</button>
</div>
<table class="table table-hover">
	<thead>
		<tr id="product-header">
			<th>Id</th>
			<th>Name</th>
			<th><a href="#" id="unitPrice">Unit Price</a></th>
			<th>Product Date</th>
			<th><a href="#" id="quantity">Quantity</a></th>
			<th>Available?</th>
			<th>Category</th>
			<th>Image</th>
			<th></th>
		</tr>
	</thead>
	<tbody id="result"></tbody>
</table>