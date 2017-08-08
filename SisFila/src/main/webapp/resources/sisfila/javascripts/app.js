$(document).ready(function() {
	
	$('.js-toggle').bind('click', function() {
		$('.js-sidebar').toggleClass('is-toggled');
		$('.js-content').toggleClass('is-toggled');
	});
	
});

$(function(){	
	var loc = location.href;
	var params =  loc.split("/");
	
	if(params[4] == '' || params[4] == 'Dashboard.xhtml'){
		document.getElementById("dashboard").className = 'is-selected';
		
	} else{
		document.getElementById(params[4]).className = 'is-selected';
	}
}); 