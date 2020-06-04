package com.znwhahaha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = { "/index"})
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        try {
            //获取用户输入的用户名
            String name = req.getParameter("user");
            //获取用户输入的密码
            String pwd = req.getParameter("password");

            int flag = run(name,pwd);
            if (flag == 1){
                //System.out.print("用户名：" + rs.getString("userName") + "\t");
                resp.getWriter().write("对不起你帐号名有误，请<a href='/logup'>注册</a>");
            }
            //密码判断
            if(flag == 0){
                resp.getWriter().write("登录成功，点击跳转<a href='http://www.baidu.com'>首页</a>");
                //System.out.print("密码：" + rs.getString("password") + "\t");
            }else if(flag == 2){
                resp.getWriter().write("对不起你密码有误");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int run(String name, String pwd) throws SQLException, ClassNotFoundException {

        //加载数据库
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/znwhahaha?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        String user = "root";
        String password = "znw159357";
        String sql = "select * from Users where userName = '"+name+"'";
        String sql2 = "select * from Users where password = '"+pwd+"'";
        Connection conn = DriverManager.getConnection(url, user, password);
        //通过2个执行器避免异常
        Statement stmt = conn.createStatement();
        Statement stmt2 =conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ResultSet rs2 = stmt2.executeQuery(sql2);
        //判断用户输入的帐号是否在数据库中
        if (rs.next()){
            //System.out.print("用户名：" + rs.getString("userName") + "\t");
        }else{
            return 1;
        }
        //密码判断
        if(rs2.next()){
            return 0;
        }else{
            return 2;
        }
    }
    
}
