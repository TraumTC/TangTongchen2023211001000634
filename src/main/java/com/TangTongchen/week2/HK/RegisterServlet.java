package com.TangTongchen.week2.HK;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/register"}
)

public class RegisterServlet extends HttpServlet {

    private Connection con;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");


        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->con:"+con);
        }catch(ClassNotFoundException |SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    public void destroy() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username= request.getParameter("username");
//        String password= request.getParameter("pwd");
//        String emali= request.getParameter("emali");
//        String gender= request.getParameter("gender");
//        String Birthdate= request.getParameter("day");
//
//        PrintWriter writer = response.getWriter();
//        writer.println("<br>username:"+username);
//        writer.println("<br>password:"+password);
//        writer.println("<br>emali:"+emali);
//        writer.println("<br>gender:"+gender);
//        writer.println("<br>Birthdate:"+Birthdate);
//        writer.close();
        //jdbc
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8"); // 设置请求编码

        // 获取表单数据（假设表单字段名与表字段匹配）
        String userName = request.getParameter("username");
        String password = request.getParameter("pwd");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("day");

        // 插入数据
        String insertSql = "INSERT INTO usertable (username, password, email, gender, birthdate) VALUES (?,?,?,?,?)";
        try (PreparedStatement insertStmt = con.prepareStatement(insertSql)) {
            insertStmt.setString(1, userName);
            insertStmt.setString(2, password);
            insertStmt.setString(3, email);
            insertStmt.setString(4, gender);
            insertStmt.setDate(5, Date.valueOf(birthdate));
            insertStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>数据插入失败</h2>");
            out.println(e.getMessage());
            return;
        }

        // 查询并展示所有数据
        String selectSql = "SELECT * FROM usertable";
        try (PreparedStatement selectStmt = con.prepareStatement(selectSql);
             ResultSet rs = selectStmt.executeQuery()) {
            out.println("<html><body>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>UserName</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th></tr>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("ID") + "</td>");
                out.println("<td>" + rs.getString("UserName") + "</td>");
                out.println("<td>" + rs.getString("Password") + "</td>");
                out.println("<td>" + rs.getString("Email") + "</td>");
                out.println("<td>" + rs.getString("Gender") + "</td>");
                out.println("<td>" + rs.getString("Birthdate") + "</td>");
                out.println("</tr>");
            }
            out.println("</table></body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>数据查询失败</h2>");
        }
    }

}
