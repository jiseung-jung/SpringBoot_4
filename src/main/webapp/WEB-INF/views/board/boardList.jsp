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
  <h3>${board} List</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
  <img alt="" src="../images/33.jpg" width="300" height="300">
  
  <form action="./${board}List" id="frm">
  <input type="hidden" name="curPage" id="curPage" value=1>
	<div>
		<select name="kind" id="kind">
			<option>--전체--</option>
			<option value="title">제목</option>
			<option value="writer">작성자</option>
		</select>
	</div>
	
	<div class="input-group">
    	<input type="text" class="form-control" placeholder="Search" name="search" id="search">
    	<div class="input-group-btn">
      		<button class="btn btn-default" type="submit">
        		<i class="glyphicon glyphicon-search"></i>
      		</button>
   		</div>
  	</div>
  </form>
  
  <table class="table table-bordered" style="text-align: center;">
  	<tr>
  		<td>no</td>
  		<td>제목</td>
  		<td>작성자</td>
  		<td>등록일</td>
  		<td>조회수</td>
  	</tr>
  	
  	<c:forEach items="${list}" var="vo">
  		<tr>
  			<td>${vo.num}</td>
  			<td><a href="./${board}Select?num=${vo.num}">${vo.title}</a></td>
  			<td>${vo.writer}</td>
  			<td>${vo.regDate}</td>
  			<td>${vo.hit}</td>
  		</tr>
  	</c:forEach>
  
  </table>
  
  <ul class="pagination">
  	<c:if test="${pager.before}">
  		<li><a href="#" class="list" title="${pager.startNum-1}">Before</a></li>
  	</c:if>
  
  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
  		<li><a href="#" class="list" title="${i}">${i}</a></li>
  	</c:forEach>
  	
  	<c:if test="${pager.after}">
  		<li><a href="#" class="list" title="${pager.lastNum+1}">After</a></li>
  	</c:if>
  </ul>
  
  <button id="wrbtn" class="btn btn-default" style="float: right;">Write</button>
  
</div>
	


<script type="text/javascript">

	// $(document).ready(function(){ //HTML 문서가 로딩이 끝났을 때
	
	//	$(function(){				 //document.ready의 축약형
	
		$("#search").val('${param.search}');

		var kind = '${param.kind}';
		if(kind != ''){
		$("#kind").val(kind);
		}
	
		$(".list").click(function(){
			var curPage = $(this).attr("title");
			$("#curPage").val(curPage);
			$("#frm").submit();
		});
		
		
		$("#wrbtn").click(function(){
				location.href="./${board}Write";
			});


		
	//	});


</script>

</body>
</html>