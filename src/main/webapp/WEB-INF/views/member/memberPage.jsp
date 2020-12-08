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
	<!-- session > memberVO > roles -->
  <h3>Member Page</h3>
  <hr>
	
	<!-- <h1>${sessionScope.memberVO.roles['0'].role}</h1> -->
	<div>
		<h3>ID : ${member.id}</h3>
		<h3>Name : ${member.name}</h3>
		<c:forEach items="${member.roles}" var="r">
			<h3>Role : ${r.role}</h3>
		</c:forEach>
	</div>  
</div>



</body>
</html>