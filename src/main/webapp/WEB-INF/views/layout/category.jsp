<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="panel panel-default">
    <div class="panel-heading">
        <span class="glyphicon glyphicon-th-list"></span>
        <strong>Chủng loại</strong>
    </div>

    <div class="list-group">
    	<c:forEach var="item" items="${cates}">
    		<c:choose>
    			<c:when test="${pageContext.response.locale.language=='vi'}">
    				<a href="product/list-by-category/${item.id}" class="list-group-item">${item.nameVN}</a>
    			</c:when>
    			<c:otherwise>
    				<a href="product/list-by-category/${item.id}" class="list-group-item">${item.name}</a>
    			</c:otherwise>
    		</c:choose>
        	
        </c:forEach>
    </div>
</div>