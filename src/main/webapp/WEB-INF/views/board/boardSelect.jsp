<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../template/bootStrap.jsp"></c:import>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<form action="" id="frm">
		<input type="hidden" value="${vo.num}" name="num">
	</form>  
	
  <h3>${board} Select</h3>
  <hr>

		<h3>Title : ${vo.title}</h3>
		<h3>Writer : ${vo.writer}</h3>
		<h3>Contents : ${vo.contents}</h3>
		<h3>file : </h3>
  <c:forEach items="${vo.files}" var="file">
  	<a href="noticeFileDown?fnum=${file.fnum}">${file.oriName}</a><br>
  </c:forEach>
  <br>
  <button class="btn btn-default go" title="Update">Update</button>
  <button class="btn btn-default go" title="Delete">Delete</button>
		
</div>

<script type="text/javascript">
	$(".go").click(function(){
		var board = '${board}';
		var t = $(this).attr("title");

		if(t=='Delete'){
			$("#frm").attr("method", "post");
		}
	
		$("#frm").attr("action", board+t);

		$("#frm").submit();
		
		});
</script>


</body>
</html>