package com.TangTongchen.week3.HK;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="RedirectServlet", value = "/redirect")

public class RedirectServlet extends HttpServlet {

    @Override
    protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    response.sendRedirect("index.jsp");

//    response.sendRedirect("/index.jsp");

//    response.sendRedirect("https://www.baidu.com/");
        System.out.println("before redirect");
        response.sendRedirect("index.jsp");
        System.out.println("after redirect");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
