<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="layout/head.jsp"/>
</head>
<body>
    <div class="container">
        <header class="nn-header row">
        	<div class="nn-company">
	            <h1>Online shopping mall</h1>
	            <h5>The center point of the professional programming</h5>
            </div>
            <img class="pull-right" src="images/header-object.png" />
        </header>

		<jsp:include page="layout/menu.jsp"/>

        <div class="nn-sheet row">

            <article class="col-sm-9">
                <div class="nn-body">
                	<jsp:include page="${view}.jsp"/>
                </div>
            </article>

            <aside class="col-sm-3">
            <div id="favorite"></div>
            
            <c:if test="${!empty sessionScope.user && sessionScope.user.admin}">
            	<div class="panel panel-default">
					<div class="panel-body">
						<a class="btn btn-danger btn-lg" href="admin/home/index">Quản trị website</a>
					</div>
				</div>
			</c:if>
                <!--CartInfo-->
				<jsp:include page="layout/cart.jsp"/>
                <!--/CartInfo-->

                <!--Search-->
				<jsp:include page="layout/search.jsp"/>
                <!--/Search-->
				
                <!--Category-->
				<jsp:include page="layout/category.jsp"/>
                <!--/Category-->

                <!--Special-->
				<jsp:include page="layout/special.jsp"/>
                <!--/Special-->
            </aside>
        </div>

        <footer class="panel panel-default row">
	        <div class="panel-heading">
	        	<p class="text-center">Nhất Nghệ &copy; 10-2018. All rights reserved.</p>
	        </div>
        </footer>
    </div>
</body>
</html>