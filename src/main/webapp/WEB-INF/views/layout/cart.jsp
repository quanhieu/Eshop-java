<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>


<div class="nn-cart">
 <div class="panel panel-default">
     <div class="panel-body">
         <img class="col-sm-5" src="images/shoppingcart.gif" />
         <ul class="col-sm-7">
             <li><span id="cart-cnt">${sessionScope['scopedTarget.cart'].count }</span> <s:message code="eshop.cart.items"/></li>
             <li>$ <span id="cart-amt">${sessionScope['scopedTarget.cart'].amount }</span></li>
             <li><a href="cart/index"><s:message code="eshop.cart.view"/></a></li>
         </ul>
     </div>
 </div>
</div>