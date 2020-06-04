package com.znwhahaha;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = { "/logup"})
public class register extends HttpServlet {

    //判断Email合法性
    public static boolean isEmail(String email) {
        if (email == null)
            return false;
        String rule = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        Pattern pattern;

        Matcher matcher;
        pattern = Pattern.compile(rule);
        matcher = pattern.matcher(email);
        if (matcher.matches())
            return true;
        else
            return false;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        
        //获得请求过来的资源
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        String sex = req.getParameter("sex");
        String country = req.getParameter("country");
        String email = req.getParameter("email");



        //判断信息是否填写
        if (userName == null || password == null || repassword == null || sex == null || country == null) {
            resp.getWriter().write("所有的数据都不能为空，请重新<a href = '/logup'>填写</a>");
            return;
        }
        //判断两次密码是否一致
        if (!password.equals(repassword)) {
            resp.getWriter().write("两次密码输入不一致，请重新<a href = '/logup'>填写</a>");
            return;
        }
        if (isEmail(email) == false) {
            resp.getWriter().write("邮箱不符合规范，请重新<a href = '/logup'>填写</a>");
            return;
        }

        try {
            //加载MySQL的数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //链接数据库
            String url = "jdbc:mysql://localhost:3306/znwhahaha";
            //默认系统管理员的账户
            String user = "root";
            //数据库密码
            String passw = "znw159357";
            //获取到数据库的连接
            Connection connection = DriverManager.getConnection(url, user, passw);
            //获取到执行器
            Statement stmt = connection.createStatement();
            //判断用户名是否存在
            String sql1 = "select * from Users where userName = '"+userName+"'";
            Statement stmt1 = connection.createStatement();
            ResultSet rs1 = stmt1.executeQuery(sql1);
            if (rs1.next()){
                resp.getWriter().write("用户名已存在，请重新<a href = '/logup'>填写</a>");
                return;
            }
            //sql语句
            String sql = "INSERT INTO Users VALUES (null,'"+userName+"','"+password+"','"+sex+"','"+country+"','"+email+"')";
            
            System.out.println(sql);
            //执行sql语句
            int i = stmt.executeUpdate(sql);

            if (i == 1) {
                resp.getWriter().write("注册成功，请<a href = '/JavaWeb_Login/index.jsp'>登录</a>");
            } else {
                resp.getWriter().write("注册失败，请返回重新<a href = '/JavaWeb_Login/logup.jsp'>注册</a>");
            }
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
