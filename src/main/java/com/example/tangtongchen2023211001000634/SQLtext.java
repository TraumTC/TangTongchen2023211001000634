//package com.example.tangtongchen2023211001000634;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.swing.*;
//import java.io.IOException;
//import java.sql.*;
//
//public class SQLtext extends HelloServlet{
//    Connection con =null;
//    @Override
//    public void init() throws SecurityException {
//         ServletConfig config = getServletConfig();
//         String driver=config.getInitParameter("driver");
//         String url=config.getInitParameter("url");
//         String user=config.getInitParameter("username");
//         String password=config.getInitParameter("password");
//
//         try  {
//             Class.forName(driver);
//             con  =  DriverManager.getConnection(url,user,password);
//             System.out.println("Connected to database successfully");
//         } catch (ClassNotFoundException  |SQLException e) {
//             e.printStackTrace();
//         }
//    }
//
//}
//
