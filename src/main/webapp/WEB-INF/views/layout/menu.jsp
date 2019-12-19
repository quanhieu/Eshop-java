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
                    <li><a href="home/index"><span class="glyphicon glyphicon-home"></span> <s:message code="eshop.home"/></a></li>
                    <li><a href="home/about"><span class="glyphicon glyphicon-th-list"></span> Giới thiệu</a></li>
                    <li><a href="home/contact"><span class="glyphicon glyphicon-earphone"></span> Liên hệ</a></li>
                    <li><a href="home/feedback"><span class="glyphicon glyphicon-envelope"></span> Góp ý</a></li>
                    <li><a href="home/faq"><span class="glyphicon glyphicon-question-sign"></span> Hỏi đáp</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Tài khoản <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                        <c:choose>
                        	<c:when test="${empty sessionScope.user}">
	                            <li><a href="account/login">Đăng nhập</a></li>
	                            <li><a href="account/forgot">Quên mật khẩu</a></li>
	                            <li><a href="account/register">Đăng ký thành viên</a></li>
                        	</c:when>
                        	<c:otherwise>
	                            <li><a href="account/logoff">Đăng xuất</a></li>
	                            <li><a href="account/change">Đổi mật khẩu</a></li>
	                            <li><a href="account/edit">Cập nhật hồ sơ</a></li>
	                            <li class="divider"></li>
	                            <li><a href="order/list">Đơn hàng</a></li>
	                            <li><a href="order/items">Hàng đã mua</a></li>                        	
                        	</c:otherwise>
                        </c:choose>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#" data-lang="en">English</a></li>
                    <li><a href="#" data-lang="vi">Tiếng Việt</a></li>
                </ul>
			<!--Menu-->
            </div>
        </div>