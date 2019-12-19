$(document).ready(function(){
	$("[data-lang]").click(function(){
		var lang = $(this).attr("data-lang");
		$.ajax({
			url:"home/lang?lang="+lang,
			success:function(response){
				location.reload();
			}
		});
		return false;
	});
	//-------------------------------
	$("[data-cart-add]").click(function(){
		var id = $(this).attr("data-cart-add");
		$.ajax({
			url:"cart/add/"+id,
			success:function(response){
				$("#cart-cnt").html(response.count);
				$("#cart-amt").html(response.amount);
			}
		});
	});
	
	$("[data-cart-remove]").click(function(){
		var id = $(this).attr("data-cart-remove");
		$.ajax({
			url:"cart/remove/"+id,
			success:function(response){
				$("#cart-cnt").html(response.count);
				$("#cart-amt").html(response.amount);
			}
		});
		$(this).parents("tr").hide(200);
	});
	
	$("[data-cart-update]").on("input", function(){
		var id = $(this).attr("data-cart-update");
		var qty = $(this).val();
		var price = $(this).attr("data-cart-price");
		$(this).parents("tr").find(".nn-amount").html(qty*price);
		$.ajax({
			url:"cart/update/"+id+"/"+qty,
			success:function(response){
				$("#cart-cnt").html(response.count);
				$("#cart-amt").html(response.amount);
			}
		});
	});
	
	//----------------------------//
	
	$("[data-favorite]").click(function(){
		var id = $(this).attr("data-favorite");
		loadFavorite(id);
	});
	
	function loadFavorite(id){
		$.ajax({
			url:"product/favorite/"+id,
			success:function(response){
				$("#favorite").html(response);
			}
		});
	}
	loadFavorite(2018);
	
	//-------------------//
	
	$("[data-send]").click(function(){
		var id = $(this).attr("data-send");
		$("#dialog input[name=id]").val(id);
	});
	
	$("button.nn-send").click(function(){
		var data = {};
		data.id = $("#dialog input[name=id]").val();
		data.sender = $("#dialog input[name=sender]").val();
		data.receiver = $("#dialog input[name=receiver]").val();
		data.subject = $("#dialog input[name=subject]").val();
		data.message = $("#dialog textarea[name=message]").val();
		$(".nn-sending").show();
		$.ajax({
			url:"product/send",
			data: data,
			success:function(response){
				alert(response);
				$(".nn-sending").hide();
				$("[data-dismiss]").click();
			}
		});
	});
	$(".nn-sending").hide();
});