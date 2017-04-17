<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modification Adresse</title>
</head>
<body>

<p> Modification de l'adresse : </p>
	<p><%= request.getAttribute("lid") %></p>
	<p><%= request.getAttribute("lenomRue") %></p>
	<p><%= request.getAttribute("laville") %></p>
	<p><%= request.getAttribute("lecodePostale") %></p>

</body>
</html>