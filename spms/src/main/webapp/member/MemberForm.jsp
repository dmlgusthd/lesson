<%@ page 
	language="java" 
	contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>ȸ�� ���</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>ȸ�� ���</h1>
<form action='add' method='post'>
�̸�: <input type='text' name='name'><br>
�̸���: <input type='text' name='email'><br>
��ȣ: <input type='password' name='password'><br>
<input type='submit' value='�߰�'>
<input type='reset' value='���'>
</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>