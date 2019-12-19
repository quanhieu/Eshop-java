<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="panel panel-default">
	<div class="panel-heading">Revenue by Category</div>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Category</th>
				<th>Total Quantity</th>
				<th>Revenue</th>
				<th>Min Price</th>
				<th>Max Price</th>
				<th>Average Price</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="a">
			<tr>
				<td>${a[0]}</td>
				<td>${a[1]}</td>
				<td>${a[2]}</td>
				<td>${a[3]}</td>
				<td>${a[4]}</td>
				<td>${a[5]}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Category', 'Revenue'],
          <c:forEach items="${list}" var="a">
          ["${a[0]}",  ${a[2]}],
          </c:forEach>
        ]);

        var options = {
          title: 'Revenue by Category',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
    <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
    


