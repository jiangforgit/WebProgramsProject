<%@ page import="com.utils.PropertiesUtil" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/26 0026
  Time: 下午 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        body{text-align:center;background:url(../images/login/login_bg.jpg);background-size:cover;padding-top:100px}
        .div_login_bg{margin:0 auto;background:#000000;width:530px;height:336px;padding:10px;color:#F00;
            filter:alpha(Opacity=20);-moz-opacity:0.2;opacity:0.2;
            border-radius:3px 3px 1px 1px;border:2px solid #000000;}
        .div_margin{margin: 15px 15px 15px 15px;padding: 10px 10px 10px 10px}
    </style>
</head>
<body>
    <div class="div_login_bg">
        <form action = <%=PropertiesUtil.getPropertyByName2("properties/UserCenter.properties","RootUrl")+"/ValidateLoadUser"%>>
            <input type="text" name="username" value="name" class="div_margin"/><br/>
            <input type="password" name="password" value="password" class="div_margin"/><br/>
            <input type="submit" value="Login" class="div_margin"/><br/>
            <a style="color: blue" href = <%=PropertiesUtil.getPropertyByName2("properties/UserCenter.properties","RootUrl")+"/jsp/RegisterUser.jsp"%> class="div_margin">没有账号注册一个</a>
        </form>
    </div>
</body>
</html>
