<%--
  Created by IntelliJ IDEA.
  User: znw_mac
  Date: 2020/5/15
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<fieldset id="">
    <legend>注册页面</legend>
    <form action="logup"  method="post" id="form">
    <table>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="userName" /><span id="span1"></span></td>
        </tr>
        <tr>
            <td>
                密码：
            </td>
            <td>
                <input type="password" name="password" />
            </td>
        </tr>
        <tr>
            <td>
                确认密码：
            </td>
            <td>
                <input type="password" name="repassword" />
                <span id="span2"></span>
            </td>

        </tr>
        <tr>
            <td>
                邮箱：
            </td>
            <td>
                <input type="email" name="email" />
                <span id="span4"></span>
            </td>

        </tr>
        <tr id="tr4">
            <td>
                性别：
            </td>
            <td>
                <input type="radio" name="sex" value="男" />男
                <input type="radio" name="sex" value="女" />女
                <span id="span3"></span>
            </td>
        </tr>
        <tr>
            <td>国籍：</td>
            <td>
                <select name="country" id="country">
                    <option value="none">--请选择国籍--</option>
                    <option value="中国">中国</option>
                    <option value="韩国">韩国</option>
                    <option value="日本">日本</option>
                    <option value="美国">美国</option>
                </select>
                <span id="span5"></span>
            </td>
        </tr>

    </table>
    <input type="submit" id="btn" value="提交" />
    </form>

</fieldset>
</body>

</html>
