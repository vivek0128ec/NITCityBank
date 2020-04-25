<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <%String empid=request.getParameter("va"); %> --%>
<form action="updatevalue.htm" method="post">
Salary:<input type="text" name="salary"><br>
designation:<input type="text" name="desg"><br>
<input type="hidden" name="eid" value=<%out.print(request.getParameter("va"));%>>
<input type="submit" value="submit">
</form>
</body>
</html>