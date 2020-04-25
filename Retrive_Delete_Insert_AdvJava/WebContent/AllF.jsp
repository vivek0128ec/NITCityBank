 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.nt.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%HttpSession hs= request.getSession();
ArrayList<MyDto> mdto=(ArrayList<MyDto>)hs.getAttribute("mdto");
String s=(String)request.getAttribute("msg");
if(s!=null){
	out.print(s);
}
%>
<table border="1">
<tr><td>EMPID</td><td>EMPLOYEE</td><td>SALARY</td><td>DESIGNATION</td><td>DELETE</td></tr>
<%Iterator<MyDto> it=mdto.iterator(); 
while(it.hasNext()){
MyDto dto=it.next();
%>
<tr><td><%out.print(dto.getEmpid()); %></td>
<td><% out.print(dto.getEmployee());%></td>
<td><%out.print(dto.getSalary()); %></td>
<td><%out.print(dto.getDesignstion()); %></td>
<td><a href="delete.htm?val=<% out.print(dto.getEmpid());%> " onclick="return confirm('are you sure for deletion ')">delete</a></td>
<td> <a href="f.htm?va=<%out.print(dto.getEmpid());%>" onclick="return confirm('do you want updatation')">update</a></td>
</tr>
<% 
}
%>
</table><br>
<a href="add.htm">AddFaulty</a><br>
<a href="home.htm">home</a>
</body>
</html>