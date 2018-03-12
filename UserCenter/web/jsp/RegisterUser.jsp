<%@ page import="com.utils.PropertiesUtil" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/11 0011
  Time: 下午 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <form action = <%=PropertiesUtil.getPropertyByName2("properties/UserCenter.properties","RootUrl")+"/Register"%> method="post">
        <table style="border-collapse:separate; border-spacing:0px 10px;">
            <tr>
                <td>
                    用户名：
                </td>
                <td>
                    <input type="text" name="username"/>
                </td>
            </tr>
            <tr>
                <td>
                    密码：
                </td>
                <td>
                    <input type="password" name="password"/>
                </td>
            </tr>
            <tr>
                <input type="submit" value="提交">
            </tr>
        </table>
    </form>
</body>
</html>
