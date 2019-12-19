<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<script src="js/pager.js"></script>

<ul class="pager">
	<li><a href="#"><span class="glyphicon glyphicon-hand-up"></span></a></li>
	<li><a href="#"><span class="glyphicon glyphicon-hand-left"></span></a></li>
	<li><a>page 3 of 15 pages</a></li>
	<li><a href="#"><span class="glyphicon glyphicon-hand-right"></span></a></li>
	<li><a href="#"><span class="glyphicon glyphicon-hand-down"></span></a></li>
</ul>
<input id="page-no" type="number" min="0"><button id="go">go</button>
<div id="pager"></div>