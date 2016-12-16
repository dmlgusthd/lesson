<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>

<!DOCTYPE html PUBLIC>
<html>
<head>
<div>
SPMS(Simple Project Management System)

<c:choose>
	<c:when test="${member.email != null}">
		${member.name}
		<a href="<c:url value='/auth/logout'/>">로그아웃</a>
	</c:when>
	<c:otherwise>
		<a href="<c:url value='/auth/login'/>">로그인</a>
	</c:otherwise>
</c:choose>

</div>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>회원 목록</title>
</head>
<body>
<h1>회원목록</h1>
<p><a href='add'>신규 회원</a></p>
	<c:forEach var="member" items="${members}">
		${member.no},
		<a href='update?no=${member.no}'>${member.name}</a>,
		${member.email},
		${member.createdDate}
		<a href='delete?no=${member.no}'>[삭제]</a><br>	
	</c:forEach>
	
	<c:import url="/Tail.jsp"/>
</body>
</html>