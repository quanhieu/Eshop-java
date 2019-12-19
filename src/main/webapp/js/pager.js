$(document).ready(function(){
	pageNo = 0;
	pageCount = 0;
	
	$.ajax({
		url:"admin/customer/get-page-count",
		data:{pageSize:10},
		success:function(response){
			pageCount = response;
		}
	});
	
	$(".pager li:eq(0)").click(function(){
		pageNo = 0;
		load();
		return false;
	});
	$(".pager li:eq(1)").click(function(){
		if(pageNo > 0){
			pageNo--;
			load();
		}
		return false;
	});
	$(".pager li:eq(3)").click(function(){
		if(pageNo < pageCount - 1){
			pageNo++;
			load();
		}
		return false;
	});
	$(".pager li:eq(4)").click(function(){
		pageNo = pageCount - 1;
		load();
		return false;
	});
	
	$(".pager li:eq(0)").click();
	
	function load(){
		$.ajax({
			url:"admin/customer/get-page",
			data:{pageNo:pageNo, pageSize:10},
			success:function(response){
				$("#pager").html(response);
				$(".pager a:eq(2)").html("Page "+(1+pageNo)+" of "+pageCount+" pages");
				$("#page-no").val(1+pageNo);
				$("#page-no").attr("max", pageCount);
			}
		});
	}
	
	$("#go").click(function(){
		pageNo = $("#page-no").val() - 1;
		load();
	});
});