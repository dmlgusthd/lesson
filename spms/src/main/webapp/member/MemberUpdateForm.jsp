<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<title>ȸ������</title>
</head>
<body>
<h1>ȸ������</h1>
<form action='update' method='post'>
��ȣ: <input type='text' name='no' value='${member.no}' readonly><br>
�̸�: <input type='text' name='name' value='${member.name}'><br>
�̸���: <input type='text' name='email' value='${member.email}'><br>
������: ${member.createdDate}<br>
<input type='submit' value='����'>
<input type='button' value='����' 
	onclick='location.href="delete?no=${member.no}";'>
<input type='button' value='���' onclick='location.href="list"'>
</form>
</body>
</html>