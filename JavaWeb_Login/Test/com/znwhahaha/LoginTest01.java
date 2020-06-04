package com.znwhahaha;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.*;
import static org.junit.Assert.assertEquals;



class LoginTest01 {

    @Test
    void Logintest() throws SQLException, IOException, ClassNotFoundException {
        String name;
        String pwd;

        //输入为正确用户名，正确密码
        name = "ZNWhahaha";
        pwd = "znw111111";
        assertEquals( 0,Login.run(name,pwd));

        //输入为正确用户名，错误密码
        name = "ZNWhahaha";
        pwd = "znw";
        assertEquals( 2,Login.run(name,pwd));

        //输入为错误用户名，正确密码
        name = "ZNWhaha";
        pwd = "znw111111";
        assertEquals(1,Login.run(name,pwd));

        //输入为不存在用户名，正确密码
        name = " ";
        pwd = "znw111111";
        assertEquals(1,Login.run(name,pwd));


    }
}