<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2025/3/4
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HW-week1</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- 引入自定义的验证脚本 -->
<%--    <script src="re.js"></script>--%>
    <style>
        body{
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
            text-align: center;
        }
        #biaodan{
            background-color: rgba(206, 145, 120);
            width: 300px;
            height: 280px;
            position: absolute; left: 50%; top: 50%;
            margin-top: -140px;
            margin-left: -150px;
            border-radius: 5px;
        }

    </style>
</head>
<body>
    <dlv id="biaodan" >
        <form method="post" action="register">
            <h2> New User Registration!</h2>
            <input type="text" name="username" placeholder="Username"><br><br>
            <input type="password" name="pwd" placeholder="Password"><br><br>
            <input type="text" name="email" placeholder="Email" ><br><br>
            <label >Gender</label>
            <input type="radio" name="gender" value="male"> Male
            <input type="radio" name="gender" value="female"> Female
            <input type="text" name="day" placeholder="date of Birth(yyyy-mm-dd)" ><br>
            <input type="submit" value="Register" >
        </form>
    </dlv>
</body>
</html>
