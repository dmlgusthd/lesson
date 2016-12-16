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
		<a href="<c:url value='/auth/logout'/>">�α׾ƿ�</a>
	</c:when>
	<c:otherwise>
		<a href="<c:url value='/auth/login'/>">�α���</a>
	</c:otherwise>
</c:choose>

</div>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>ȸ�� ���</title>
</head>
<body>
<h1>ȸ�����</h1>
<p><a href='add'>�ű� ȸ��</a></p>
	<c:forEach var="member" items="${members}">
		${member.no},
		<a href='update?no=${member.no}'>${member.name}</a>,
		${member.email},
		${member.createdDate}
		<a href='delete?no=${member.no}'>[����]</a><br>	
	</c:forEach>
	
	<c:import url="/Tail.jsp"/>
</body>
</html>