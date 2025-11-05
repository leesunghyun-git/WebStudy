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
	ajaxData('한식')
	$('span').click(function(){
		let type=$(this).text()
		ajaxData(type)
		})
})
function ajaxData(type){
	$.ajax({
		type:'post',
		url:'../food/food_list.do',
		data:{"type":type}	,
		success:function(result){
			//console.log(result)
			let json=JSON.parse(result)
			console.log(json)
			let html=''
			json.map(function(vo){
				html+='<div class="col-sm-3">'
					+'<div class="thumbnail">'
					+'<a href="../food/detail.do?fno='+vo.fno+'">'
					+'<img src="'+vo.poster+'" style="width:230px;height:150px"> </a>'
					+'<p>'+vo.name+'</p>'
					+'</div>'
					+'</div>'
			})
		$('.print').html(html)
		}
	
	})

}
</script>
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<span class="btn btn-sm btn-danger">한식</span>
			<span class="btn btn-sm btn-success">양식</span>
			<span class="btn btn-sm btn-primary">중식</span>
			<span class="btn btn-sm btn-warning">일식</span>
			<span class="btn btn-sm btn-info">분식</span>
		</div>
		<div style="height:20px"></div>
		<div class="row print">
			
		</div>
	</div>
</body>
</html>