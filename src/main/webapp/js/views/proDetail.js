/**
 * 
 */
$(document).ready(function(){
		$("#increase").click(function(e){
			var val = $("#sNumber").val();
			$("#sNumber").val(++val);
		});
		$("#decrease").click(function(e){
			var val = $("#sNumber").val();
			if(val > 1){
				$("#sNumber").val(--val);
			}	
		})
});