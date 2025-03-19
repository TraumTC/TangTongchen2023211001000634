<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>JSP - Hello World</title>--%>
<%--</head>--%>
<%--<body>--%>
<%@include file="header.jsp"%>
<%--<h1><%= "Welcome to my home page" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet-week1</a>--%>
<%--<br>--%>
<%--<a href="hello">Student Info Servlet-week1 </a>--%>
<%--<br>--%>
<%--<a href="LifeCycle">Life Cycle Servlet-week2 </a>--%>
<%--<br>--%>
<%--<a href="register.jsp">Regiester-getParameter-week2 </a>--%>
<%--<br>--%>
<%--<a href="config">Config parmeter-week2 </a>--%>
<%--<br>--%>
<%--<a href="register">Register JDBC-week2 </a>--%>
<%--<br>--%>
<%--<a href="index.jsp">include-week3 </a>--%>

    <h2>Welcome to my online shop home page</h2>
    <br>
    <form method="get" target='_blank' action="search">
        <input type="text" name="txt" size=30/>
        <select name="search">
            <option value="baidu">Baidu</option>
            <option value="bing">Bing</option>
            <option value="google">Google</option>
        </select>
        <input type="submit" value="Search"/>

    </form>

<%@include file="footer.jsp"%>
<%--</body>--%>
<%--</html>--%>