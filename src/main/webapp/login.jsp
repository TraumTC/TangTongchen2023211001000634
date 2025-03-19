<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2025/3/18
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Welcome to Login </h1>
<%
if(!(request.getAttribute("message")==null)){
    out.print("<h3>"+request.getAttribute("message")+"</h3>");
}
%>

    <form action="login" method="post">
        Username:<input type="text" name="username"/><br>
        Password:<input type="password" name="password"/><br>
        <input type="submit" value="Login"/>
    </form>
</body>
</html>
<%@include file="footer.jsp"%>