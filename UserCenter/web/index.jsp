<%@ page import="com.utils.PropertiesUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>用户中心</title>
      <style>
          a{text-decoration: none}
          .loadUserContainer{ width: 150px; float: right;}
          .loadUser{ width: 100px; height: 40px; text-align: center;line-height: 40px;  }
          .loadUser a{color: royalblue;}
          li a{color: #333333;}
          .loadUserMenu{ width: 100px; height: 200px; display: none; /*visibility: hidden;*/ }
          ul{ list-style: none; margin-left: -40px; }  ul li{ line-height: 40px; display: block;width: 100px; text-align: center; }
          .loadUserContainer:hover{ cursor: pointer; } .loadUserContainer:hover .loadUserMenu{ display: block; }
          .loadUserContainer:hover .loadUser a{ color: green; }
          li:hover{ background-color: #f6f5f7;} li:hover a{color: green;}
      </style>
  </head>

  <body style="background-image: url(images/main/main_bg.jpg);background-size:cover;">
  <%
      Object username = request.getSession().getAttribute("loginUser");
      if(null == username){
          String subUrl = PropertiesUtil.getPropertyByLoader("properties/UserCenter.properties","RootUrl")+"/jsp/UserRegisterLoad.jsp";
          response.sendRedirect(subUrl);
      }
  %>
        <div class="loadUserContainer">
            <div class="loadUser"><a href="index.jsp"><%=username%></a></div>
            <div class="loadUserMenu">
               <ul>
                   <li><a>个人中心</a></li>
                   <li><a>权限管理</a></li>
                   <li><a>我的认证</a></li>
                   <li><a href="LogoutUser">注销登陆</a></li>
              </ul>
          </div>
        </div>
  </body>
</html>
