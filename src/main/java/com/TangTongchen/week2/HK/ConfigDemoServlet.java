package com.TangTongchen.week2.HK;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name = "name1",value = "TangTongchen"),
                @WebInitParam(name = "studentId1" , value = "2023211001000634")
        }
)

public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter writer = response.getWriter();
//        String name=getServletConfig().getInitParameter("name");
//        String studentId=getServletConfig().getInitParameter("studentId");
        String name1=getServletConfig().getInitParameter("name1");
        String studentId1=getServletConfig().getInitParameter("studentId1");
        writer.println("<html><body>");
//        writer.println("<h2>Task 1-Get init parameters from web.xml</h2>");
//        writer.println("<p>name:"+name+"</p>");
//        writer.println("<p>studentid:"+studentId+"</p>");
//        writer.println("<br><br>");
        writer.println("<h2>Task 2-Get init parameters from @WebServlet</h2>");
        writer.println("<p>name:"+name1+"</p>");
        writer.println("<p>studentid:"+studentId1+"</p>");

        writer.println("</html></body>");

    }




}

