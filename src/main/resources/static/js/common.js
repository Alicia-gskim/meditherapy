/**
 * 
 */
var CallAjax = function() {
	var f = {};
	var o = {
			$f: jQuery(f),
			type: 'post',
			dataType: 'json',
			async: true,
			cache: false,
			contentType: "application/json; charset=UTF-8"
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
			type: o.type,
			dataType: o.dataType,
			async: o.async,
			cache: o.cache,
			contentType: o.contentType,
			url: o.url,
			data: o.param,
			success: function(data, status, xhr) {
				if( status == "success" && xhr.status == 200 ) {
					if( typeof(o.success) == "function" ) {
						o.success(data);
					} else {
						eval(o.success + "(data);");
					}
				}
			},
			error: function(xhr, status, errorThrown) {
				alert("ajax 통신 오류 : " + xhr.status + " : " + status + " : " + errorThrown);
			}
		});
	}
	
	return f;
}