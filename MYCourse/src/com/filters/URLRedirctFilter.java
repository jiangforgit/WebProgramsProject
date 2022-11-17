package com.filters;

import com.utils.PropertiesUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class URLRedirctFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();

        String path = servletRequest.getRequestURI();
        String rootUrl = PropertiesUtil.getPropertyByLoader("properties/MYCourse.properties","RootUrl");
        System.out.println("path = "+path);
        System.out.println("rootUrl = "+rootUrl);
        if(path.indexOf(rootUrl+"/index.jsp") > -1 ||
                path.indexOf(rootUrl) > -1) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
