<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.sist.dao.*,com.sist.vo.*"%>
   <%
      MusicDAO dao=MusicDAO.newInstance();
      List<MusicVO> list=dao.musicListData(1);
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('input[type="text"]').keyup(function(){
		let k=$(this).val()
		console.log(k)
	
	})


})


</script>
</head>
<body>
	<table width=800>
		<tr>
			<td>
				<input type="text" size=20>
			</td>
		</tr>
	</table>
   <table border=1 bordercolor=black width=800>
      <tr>
         <th>순위</th>
         <th></th>
         <th>곡명</th>
         <th>가수명</th>
      </tr>
      <%
         for(MusicVO vo:list) {
      %>
            <tr>
               <td><%=vo.getNo() %></td>
               <td>
                  <img src="<%=vo.getPoster() %>"
                     width="35" height="35">
               </td>
               <td><%=vo.getTitle() %></td>
               <td><%=vo.getSinger() %></td>
            </tr>
      <%
         }
      %>
   </table>
</body>
</html>