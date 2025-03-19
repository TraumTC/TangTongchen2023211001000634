<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2025/3/18
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Count JSP</title>
</head>
<body>
 <%! int count=0;%>
    this Page has access :<%out.println(++count);%>
</body>
</html>
