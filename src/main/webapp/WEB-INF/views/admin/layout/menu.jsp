<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
        
        <div class="navbar navbar-inverse row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
			<!--Menu-->
                <ul class="nav navbar-nav">
                    <li><a href="home/index"><span class="glyphicon glyphicon-home"></span> Trang chủ</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Quản lý <span class="caret"></span></a>
                        <ul class="dropdown-menu">
	                            <li><a href="admin/product/index">Sản phẩm</a></li>
	                            <li><a href="admin/category/index">Chủng loại</a></li>
	                            <li><a href="admin/customer/index">Khách hàng</a></li>
	                            <li><a href="admin/order/index">Hóa đơn</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Thống kê <span class="caret"></span></a>
                        <ul class="dropdown-menu">
	                            <li><a href="admin/report/inventory">Kiểm kê hàng tồn</a></li>
	                            <li><a href="admin/report/revenue-by-category">Doanh số theo loại</a></li>
	                            <li><a href="admin/report/revenue-by-customer">Doanh số theo khách hàng</a></li>
                        </ul>
                    </li>
                </ul>
			<!--Menu-->
            </div>
        </div>