<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../template/bootStrap.jsp"></c:import>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h3>${board} Select</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
  

	<div>
		<h3>Num : ${vo.num}</h3>
		<h3>Title : ${vo.title}</h3>
		<h3>Writer : ${vo.writer}</h3>
		<h3>Contents : ${vo.contents}</h3><br>
		
  <c:forEach items="${vo.files}" var="file">
  	<a href="noticeFileDown?fnum=${file.fnum}">${file.oriName}</a><br>
  </c:forEach>
		
	</div>  
</div>



</body>
</html>