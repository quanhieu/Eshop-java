$(document).ready(function(){
	orderby = false;
	prop = "id";
	$("#search button:eq(0)").click(function(){
		load();
	});
	
	$("#product-header a").click(function(){
		orderby=!orderby;
		prop = $(this).attr("id");
		load();
		return false;
	});
	
	
	function load(){
		min = $("#search input:first").val();
		max = $("#search input:last").val();
		$.ajax({
			url:"admin/product/search",
			data:{min:min, max:max, orderby: orderby, prop:prop},
			success:function(response){
				$("#result").html(response);
			}
		});
	}
});