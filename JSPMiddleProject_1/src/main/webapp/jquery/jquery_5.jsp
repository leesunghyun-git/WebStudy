<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
		$('h3:eq(0)').css("color","red")
		$('h3:eq(1)').css("color","blue")
		$('h3:eq(2)').css("color","green")

})
</script>
</head>
<body>
	<h1>eq : 0번부터</h1>
	<h3>Hello JQuery1</h3>
	<h3>Hello JQuery2</h3>
	<h3>Hello JQuery3</h3>
</body>
</html>