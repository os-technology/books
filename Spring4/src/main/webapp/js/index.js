	$(function(){
	    $("#btn").click(function(){
	       $.post("hello/getPerson",{name:$("#name").val()},function(data){
	            alert(data);
	        });
	    });
	});
