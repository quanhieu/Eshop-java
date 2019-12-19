<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="layout/head.jsp"/>
</head>
<body>
    <div class="container">
    	<h1 class="alert alert-danger">Admistration Tool</h1>
		<jsp:include page="layout/menu.jsp"/>

        <div class="nn-sheet row">
            <article class="col-sm-12">
                <div class="nn-body">
                	<jsp:include page="${view}.jsp"/>
                </div>
            </article>
        </div>

        <footer class="panel panel-default row">
	        <div class="panel-heading">
	        	<p class="text-center">Nhất Nghệ &copy; 10-2018. All rights reserved.</p>
	        </div>
        </footer>
    </div>
</body>
</html>