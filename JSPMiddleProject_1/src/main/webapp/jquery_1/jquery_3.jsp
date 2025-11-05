<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	let width=0
	let height=0
	$('img').hover(function(){
		width=parseInt($(this).css("width"))
		height=parseInt($(this).css("height"))
		$(this).css({"opacity":0.3,"cursor":"pointer","border":"2px solid red","width":(width+50)+"px","height":(height+50)+"px"})
	
	},function(){
		$(this).css({"opacity":1.0,"cursor":"none","border":"none","width":width+"px","height":height+"px"})
	
	})
	$('li').hover(function(){
		$(this).css({"cursor":"pointer"})
	
	},function(){
		$(this).css({"cursor":"none"})
	
	})

	$('li').on('click',function(){
		let data=$(this).text()
		alert("선택된 과정:"+data)
		$(this).text(data+"과정")
	})
	$('#image').click(function(){
		let file=$('#image').attr("src")
		alert(file)
		
		$('#image').attr("src","mm2.gif")
	
	})
	$('#readBtn').click(function(){
		let name=$('input[type=text]').val()
		alert(name)
	
	})
	$('#writeBtn').click(function(){
		$('input[type=text]').val("심청이")
	
	})
	$('h1').click(function(){
		/* let text=$('h1').text()
		alert(text) */
		/* let html=$('h1').html()
		alert(html) */
		$('h1').html('<font color=red>Hello Jquery</font>')
	})
	$('#appBtn').click(function(){
		$('div').append(
		'<h1>Hello Append</h1> '		
		)
	
	})

})

</script>
</head>
<body>
	<img src="mm1.gif" style="width:150px;height:200px">
	<img src="mm2.gif" style="width:150px;height:200px">
	<img src="mm3.jpg" style="width:150px;height:200px">
	<p>
	<ul>
		<li>Java</li>
		<li>Oracle</li>
		<li>JSP</li>
		<li>Spring</li>
		<li>Spring-Boot</li>
		<li>HTML/CSS/JavaScript</li>
		<li>Jquery(Ajax)</li>
		<li>VueJS</li>
		<li>ReactJS</li>
		<li>CI/CD</li>
		<li>DevOps</li>
	</ul>
	<p>
	<img src="mm1.gif" style="width:200px;height:250px" id="image">
	<p>
	<input type=text id="name" size=20>
	<input type=button value="읽기" id="readBtn">
	<input type=button value="쓰기" id="writeBtn">
	<p>
	<h1><span>hello jquery</span></h1>
	<p>
	<input type=button id="appBtn" value="몰루">
	<div>
	
	</div>
</body>
</html>