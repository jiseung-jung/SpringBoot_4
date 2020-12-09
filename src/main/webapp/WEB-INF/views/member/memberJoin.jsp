<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:import url="../template/bootStrap.jsp"></c:import>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<style type="text/css">
	.error{
		color: red;
	}
</style>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h3>Member Join</h3>
  
  <form:form modelAttribute="memberVO" enctype="multipart/form-data">
  	 <div class="form-group">
      <label for="id">ID:</label>
      <form:input path="id" class="form-control"/>
      <form:errors path="id" cssClass="error"></form:errors>
    </div>
    
    <div class="form-group">
      <label for="pw">Password:</label>
      <form:password path="pw" class="form-control"/>
      <form:errors path="pw" cssClass="error"></form:errors>
    </div>
    
    <div class="form-group">
      <label for="name">Name:</label>
      <form:input path="name" class="form-control"/>
      <form:errors path="name" cssClass="error"></form:errors>
    </div>
    
    
    <div class="form-group">
      <label for="age">Age:</label>
      <form:input path="age" class="form-control"/>
      <form:errors path="age" cssClass="error"></form:errors>
    </div>
    
    
    <div class="form-group">
      <label for="email">Email:</label>
      <form:input path="email" class="form-control"/>
      <form:errors path="email" cssClass="error"></form:errors>
    </div>
    

	
	<div class="form-group">
      <label for="files">file:</label>
      <input type="file" class="form-control" name="files">
    </div>

    <button type="submit" class="btn btn-default">확인</button>
  </form:form>
   
  
</div>



</body>
</html>