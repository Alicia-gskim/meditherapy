<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<script type="text/javascript" src="http://210.114.19.46:18080/js/jquery-latest.min.js"></script>
	<script type="text/javascript" src="http://210.114.19.46:18080/js/jquery.ajax-cross-origin.min.js"></script>
	<script type="text/javascript" src="http://210.114.19.46:18080/js/common.js"></script>
	<script>
		function cupponOn(cupponName) {
		    var path = "http://210.114.19.46:18080/issuingCoupons";
	        var memberId = "kainasade";
	        var coObj = {
	            userId: memberId,
	            couponId: "coupon1"
	        }
	        var $ajax = new CallAjax();
	        $ajax.type("get");
	        $ajax.url(path);
	        $ajax.param(coObj);
	        $ajax.success(function(res) {
	            console.log(res);
	        });
	        $ajax.call();
		}
	</script>
<body>
	<hr>
	This page is index.html.
	
	<h3>${str}</h3> : ${now}
	<button onclick="cupponOn()">쿠폰발급</button>
</body>
</html>