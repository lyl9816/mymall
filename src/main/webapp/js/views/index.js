/**
 * 
 */

$(document).ready(function(){
	$("#hei1").mouseover(function(){
		document.getElementById("hei1").style.display = "none";
		document.getElementById("bai1").style.display = "block";
		$("#bai1").click(function(){
			document.getElementById("lb1").style.display = "block";
			document.getElementById("lb2").style.display = "none";
			document.getElementById("lb3").style.display = "none";
		});
	});
	$("#bai1").mouseout(function(){
		document.getElementById("bai1").style.display = "none";
		document.getElementById("hei1").style.display = "block";
	});
	$("#hei2").mouseover(function(){
		document.getElementById("hei2").style.display = "none";
		document.getElementById("bai2").style.display = "block";
		$("#bai2").click(function(){
			document.getElementById("lb1").style.display = "none";
			document.getElementById("lb2").style.display = "block";
			document.getElementById("lb3").style.display = "none";
		});
	});
	$("#bai2").mouseout(function(){
		document.getElementById("bai2").style.display = "none";
		document.getElementById("hei2").style.display = "block";
	});
	$("#hei3").mouseover(function(){
		document.getElementById("hei3").style.display = "none";
		document.getElementById("bai3").style.display = "block";
		$("#bai3").click(function(){
			document.getElementById("lb1").style.display = "none";
			document.getElementById("lb2").style.display = "none";
			document.getElementById("lb3").style.display = "block";
		});
	});
	$("#bai3").mouseout(function(){
		document.getElementById("bai3").style.display = "none";
		document.getElementById("hei3").style.display = "block";
	});
	
	var i=1;
	setInterval(function bf(){
	if(i==1){
		document.getElementById("lb1").style.display = "block";
		document.getElementById("lb2").style.display = "none";
		document.getElementById("lb3").style.display = "none";
		i++;
	}else if(i==2){
		document.getElementById("lb1").style.display = "none";
		document.getElementById("lb2").style.display = "block";
		document.getElementById("lb3").style.display = "none";
		i++;
	}else {
		document.getElementById("lb1").style.display = "none";
		document.getElementById("lb2").style.display = "none";
		document.getElementById("lb3").style.display = "block";
		i=1;
	}
	},3000);
	$("#logoPic").click(function(){
		$.ajax({
			 url:"shop/index",
		 });
	});
});
