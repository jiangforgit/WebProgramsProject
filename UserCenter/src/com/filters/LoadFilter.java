package com.filters;

import com.utils.PropertiesUtil;
import org.hibernate.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoadFilter implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        // 从session里取员工工号信息
        String userName = (String) session.getAttribute("loaduser");
        // 登陆页面无需过滤
        String rootUrl = PropertiesUtil.getPropertyByName2("properties/UserCenter.properties","RootUrl");
        if(path.indexOf(rootUrl+"/jsp/login.jsp") > -1 ||
           path.indexOf(rootUrl+"/index.jsp") > -1 ||
           path.indexOf(rootUrl) > -1) {
            filterChain.doFilter(servletRequest, servletResponse);
             return;
         }

         // 判断如果没有取到员工信息,就跳转到登陆页面
         if (null == userName || "".equals(userName)) {
             // 跳转到登陆页面
             servletResponse.sendRedirect(rootUrl+"/jsp/login.jsp");
         } else {
             // 已经登陆,继续此次请求
             filterChain.doFilter(request, response);
         }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
