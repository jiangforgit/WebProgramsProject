package com.serverlets;

import com.alibaba.fastjson.JSON;
import com.factorys.QueryCoursesFactory;
import com.factorys.SearchStudentCoursesFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class QueryCoursesServerlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        String schoolId = req.getParameter("schoolId");
        String studentId = req.getParameter("studentId");
        if(null !=schoolId){
            QueryCoursesFactory factory = new QueryCoursesFactory();
            ArrayList courses = factory.produce().getCoursesBySchoolId(Integer.parseInt(schoolId));
            String coursesJson = JSON.toJSONString(courses);
            resp.getWriter().write(coursesJson);
        }else if(null != studentId){
            SearchStudentCoursesFactory factory = new SearchStudentCoursesFactory();
            ArrayList courses = factory.produce().getCoursesByStudentId(Integer.parseInt(studentId));
            String coursesJson = JSON.toJSONString(courses);
//            System.out.println("coursesJson="+coursesJson);
            resp.getWriter().write(coursesJson);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
