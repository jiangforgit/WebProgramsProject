<%@ page import="com.utils.PropertiesUtil" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/17 0017
  Time: 下午 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户中心</title>
  </head>
  <body style="background-image: url(images/main/main_bg.jpg);background-size:cover;">

    <% Object username = request.getSession().getAttribute("loaduser");
        if(null == username){
            String subUrl = PropertiesUtil.getPropertyByName2("properties/UserCenter.properties","RootUrl")+"/jsp/login.jsp";
           response.getWriter().println("<a href=\""+subUrl+"\">登陆</a>");
        }else {
            response.getWriter().println(username.toString());
        }
    %>
  </body>
</html>
