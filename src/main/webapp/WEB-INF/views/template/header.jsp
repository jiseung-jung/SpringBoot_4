<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="${pageContext.request.contextPath}/notice/noticeList">NOTICE</a></li>
      <li><a href="${pageContext.request.contextPath}/qna/qnaList">QnA</a></li>
    </ul>
    
    <!-- 로그아웃 상태 -->
	   <c:if test="${empty member}">
	     <ul class="nav navbar-nav navbar-right">
	      <li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <li><a href="${pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	     </ul>
	   </c:if>
	    
	<!-- 로그인 상태 -->
	   <c:if test="${not empty member}">
	     <ul class="nav navbar-nav navbar-right">
	      <li><a href="${pageContext.request.contextPath}/member/memberPage"><span class="glyphicon glyphicon-user"></span> MyPage</a></li>
	      <li><a href="${pageContext.request.contextPath}/member/memberLogout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
	     </ul>
   	   </c:if>
    
  </div>
</nav>