<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$MYCourse$</title>
  </head>
  <body>
  $MYCourse$
  <%
    //管理
//    response.sendRedirect("htmls/managerhome/index.jsp");

    //教师
//    response.sendRedirect("htmls/teacherhome/index.jsp");

    //家长
    response.sendRedirect("htmls/familyhome/index.jsp");
  %>
  </body>
</html>
