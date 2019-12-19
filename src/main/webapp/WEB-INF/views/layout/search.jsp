<%@ page pageEncoding="utf-8" %>

<div class="nn-cart">
    <div class="panel panel-default">
        <div class="panel-body">
            <form method="post" action="product/search">
                <input placeholder="Keywords" name="keywords" 
                		class="form-control" value="${param.keywords}"/>
            </form>
        </div>
    </div>
</div>