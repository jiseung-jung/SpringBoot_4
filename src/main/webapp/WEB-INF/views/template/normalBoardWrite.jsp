<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <form action="./${board}Write" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    
    <div class="form-group">
      <label for="writer">Writer:</label>
      <input type="text" value="${member.id}" readonly="readonly" class="form-control" id="writer" name="writer">
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