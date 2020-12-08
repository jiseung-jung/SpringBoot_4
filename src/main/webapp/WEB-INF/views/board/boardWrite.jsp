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
  <h3>${board} Write</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
  
    <form action="./${board}Write" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="title" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    
    <div class="form-group">
      <label for="writer">Writer:</label>
      <input type="writer" class="form-control" id="writer" placeholder="Enter writer" name="writer">
    </div>

    <div class="form-group">
 	 <label for="contents">Contents:</label>
  	 <textarea class="form-control" rows="5" id="contents" name="contents"></textarea>
	</div>
	
	<div class="form-group">
      <label for="files">file:</label>
      <input type="file" class="form-control" name="files">
      <input type="file" class="form-control" name="files">
    </div>

    <button type="submit" class="btn btn-default">Submit</button>
  </form>
  
</div>

<script type="text/javascript">
	$('#contents').summernote({
		 height: 300
		});
</script>


</body>
</html>