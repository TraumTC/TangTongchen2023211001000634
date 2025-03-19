package com.TangTongchen.week3.HK;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()-->con:" + con);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        Statement st = null;
        String selectSql = "SELECT * FROM usertable where  username='" + username + "' and password='" + password + "'";
        try {
            String sql = selectSql;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);


            if (rs.next()) {
                request.setAttribute("id", rs.getString("id"));
                request.setAttribute("username", rs.getString("username"));
                request.setAttribute("password", rs.getString("password"));
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("gender", rs.getString("gender"));
                request.setAttribute("birthdate", rs.getString("birthdate"));

                request.getRequestDispatcher("userinfo.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "username or password Error!!!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }


//            out.println("<html><body>");
//            out.println("<table border='1'>");
//            out.println("<tr><th>ID</th><th>UserName</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th></tr>");
//            while (rs.next()) {
//                out.println("<tr>");
//                out.println("<td>" + rs.getInt("ID") + "</td>");
//                out.println("<td>" + rs.getString("UserName") + "</td>");
//                out.println("<td>" + rs.getString("Password") + "</td>");
//                out.println("<td>" + rs.getString("Email") + "</td>");
//                out.println("<td>" + rs.getString("Gender") + "</td>");
//                out.println("<td>" + rs.getString("Birthdate") + "</td>");
//                out.println("</tr>");
//            }
//            response.sendRedirect("login.jsp");
//            out.println("</table></body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>数据查询失败</h2>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}