/**
 * 
 */ 
var CallAjax = function() {
	var f = {};
	var o = {
			$f: jQuery(f),
			dataType: 'json',
			headers: {
				"Content-Type": "application/javascript",
				"Access-Control-Allow-Origin": "*",
				"Access-Control-Allow-Methods": "*",
				"Access-Control-Allow-Headers": "Content-Type"
			}
	};
	f.type = function(type) {
		o.type = type;
		
		return f;
	};
	f.url= function(url) {
		o.url = url;
		
		return f;
	};
	f.param = function(param) {
		o.param = param;
		
		return f;
	};
	f.success = function(success) {
		o.success = success;
		
		return f;
	};
	f.call = function call() {
		$.ajax({
			contentType: "application/javascript",
 			type: o.type,
 			dataType: o.dataType,
 			header: o.header,
			url: o.url,
			data: o.param,
			crossDomain: true,
			success: function(data, status, xhr) {
				console.log("ajax success : " + data + " : " + status + " : " + xhr)
				
				o.success(data);
			},
			error: function(xhr, status, errorThrown) {
				console.log("ajax fail : " + xhr.status + " : " + status + " : " + errorThrown);
			}
		});
	}
	
	return f;
}