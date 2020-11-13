/**
 * 
 */

var path = "/getData";

(function($) {
	
	$(document).ready(function() {
		var $ajax = new CallAjax();
		$ajax.url(path);
//		$ajax.param();
		$ajax.success(function(res) {
			console.log("success");
			var html = '';
			for(var i=0; i<res.length; i++) {
				var keys = Object.keys(res[i]);
				
				for( const [key, value] of Object.entries(res[i]) ) {
					console.log(key);
					console.log(value);
					html += '<ul style="width:45%;">';
					html += '<li>key : '+ key +'</li>';
					html += '<li>value : '+ value +'</li>';
					html += '</ul>';
				}
			}
			
			$('#tmp').html(html);
		});
		$ajax.call();
		
	});
	
})(jQuery);