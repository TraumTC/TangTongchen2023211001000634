<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2025/3/18
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>User Info</h1>
    <h2>Username:<%=request.getAttribute("username")%></h2>
    <h2>Password:<%=request.getAttribute("password")%></h2>
    <h2>Email:<%=request.getAttribute("email")%></h2>
    <h2>Gender:<%=request.getAttribute("gender")%></h2>
    <h2>Birthdate:<%=request.getAttribute("birthdate")%></h2>
   Do you want to update <a href="userupdate.jsp?id=<%=request.getAttribute("id")%>">Click here </a>
</body>
</html>
<%@include file="footer.jsp"%>
