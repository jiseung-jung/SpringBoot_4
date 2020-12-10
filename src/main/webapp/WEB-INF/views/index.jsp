<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/bootStrap.jsp"></c:import>
<link href="./css/index.css" rel="stylesheet">

</head>
</head>
<body>
<c:import url="./template/header.jsp"></c:import>
  
<div class="container">
	<c:if test="${not empty member}">
		<h2><spring:message code="member.login.message" arguments="${member.id}"></spring:message></h2>
		<h2><spring:message code="member.login.message2" arguments="${member.id}, ${member.name}" argumentSeparator=","></spring:message></h2>
	</c:if>

  <h3>Right Aligned Navbar</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
  <img alt="" src="./images/33.jpg" width="550" height="500">
  
  <spring:message code="name" var="n"></spring:message>
  <h1>Message : <spring:message code="hello"></spring:message></h1>
  <h1>Name : ${n}  </h1>
  <h1>Age : <spring:message code="user.age"></spring:message> </h1>
  <h1>Default : <spring:message code="use" text="Defalut Message"></spring:message> </h1>
  <h3>var : ${n}</h3>
  
  <a href="./rest/member/jiseung/1">Click</a>
  <button class="btn btn-default" id="btn">Click Me</button>
  <button class="btn btn-default" id="list">List</button>
  
  
</div>


<script type="text/javascript">

	$("#list").click(function(){
			$.get("board/boardList?curPage=1", function(data){
					console.log(data);

			});
		
	});


	$("#btn").click(function(){
			$.ajax({
				type:"GET",
				url:"board/boardSelect",
				data:{
					num:1
				},
					success:function(){
					alert(data);	
				}
				

				});
		});


/*$("#btn").click(function(){
	$.get("https://api.manana.kr/exchange.json", function(data){
			for(i=0;i<data.length;i++){
				console.log(data.[i].kr);
				}
			
		})
	alert("click");
});

/*	var v = '{"name":"jiseung", "age":"27", "job":{"singer":"top", "actor":"second"}, food:["steak, "bread", "milk"]}';
	v = JSON.parse(v);
	//변수명.json의 키(name)
	alert(v.name);
	alert(v.age);
	alert(v.job.singer);
	alert(v.job.actor);
	alret(v.food[1]);
	for(i=0;i<v.food.length;i++){
			console.log(v.food[i])
		}

	*/

</script>



</body>
</html>