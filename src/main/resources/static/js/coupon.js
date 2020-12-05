/**
 * 
 */

var path = "/getData";

(function($) {
	
	$(document).ready(function() {
		console.log("1111");
		var $ajax = new CallAjax();
		console.log("2222");
		$ajax.type("post");
		$ajax.url(path);
		console.log("3333");
		$ajax.param(JSON.stringify({userId: "kainasade1"}));
		$ajax.success(function(res) {
			console.log("4444");
			var html = '';
			for(var i=0; i<res.length; i++) {
				var keys = Object.keys(res[i]);
				
				for( const [key, value] of Object.entries(res[i]) ) {
//					console.log(key);
//					console.log(value);
					html += '<ul style="width:45%;">';
					html += '<li>key : '+ key +'</li>';
					html += '<li>value : '+ value +'</li>';
					html += '</ul>';
				}
			}
			
			$('#tmp').html(html);
		});
		console.log("5555");
		$ajax.call();
		console.log("6666");
		
	});
	
})(jQuery);