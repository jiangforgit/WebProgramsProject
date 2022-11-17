package com.serverlets;

import com.db.entitys.CourseTbEntity;
import com.db.entitys.CoursestudentTbEntity;
import com.factorys.AddCourseStudentShipFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

public class AddStudentCourseServerlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        //添加新课程
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        String regist_courseName = req.getParameter("regist_courseName");
        String regist_courseDes = req.getParameter("regist_courseDes");
        String regist_schoolSelect = req.getParameter("regist_schoolSelect");
        String regist_studentSelect = req.getParameter("regist_studentSelect");
        //选修已有课程
        String regist_studentSelect_exists = req.getParameter("regist_studentSelect_exists");
        String regist_schoolSelect_exists = req.getParameter("regist_schoolSelect_exists");
        String regist_courseId_exists = req.getParameter("regist_courseId_exists");

//        System.out.println("regist_courseName="+regist_courseName+",regist_courseDes="+regist_courseDes+",regist_schoolSelect="+regist_schoolSelect+",regist_studentSelect="+regist_studentSelect+",regist_studentSelect_exists="+regist_studentSelect_exists+",regist_schoolSelect_exists="+regist_schoolSelect_exists+",regist_courseId_exists="+regist_courseId_exists);
        if(null != regist_courseName && null != regist_schoolSelect && null != regist_studentSelect){
            CourseTbEntity courseTbEntity = new CourseTbEntity();
            courseTbEntity.setCourseName(regist_courseName);
            courseTbEntity.setCourseDescribe(regist_courseDes);
            courseTbEntity.setCourseSchoolId(Integer.parseInt(regist_schoolSelect));
            courseTbEntity.setCourseCreateTime(createTime);

            CoursestudentTbEntity coursestudentTbEntity = new CoursestudentTbEntity();
            coursestudentTbEntity.setCourseStudentSId(Integer.parseInt(regist_studentSelect));
            coursestudentTbEntity.setCourseStudentCreateTime(createTime);

            addNewStudentCourse(resp,courseTbEntity,coursestudentTbEntity);
        }else if(null != regist_courseId_exists && null != regist_schoolSelect_exists && null != regist_studentSelect_exists){
            CoursestudentTbEntity coursestudentTbEntity = new CoursestudentTbEntity();
            coursestudentTbEntity.setCourseStudentCId(Integer.parseInt(regist_courseId_exists));
            coursestudentTbEntity.setCourseStudentSId(Integer.parseInt(regist_studentSelect_exists));
            coursestudentTbEntity.setCourseStudentCreateTime(createTime);

            joinExistsStudentCourse(resp,coursestudentTbEntity);
        }else {
            studentCourseParamsError(resp);
        }

    }

    private void addNewStudentCourse(HttpServletResponse resp,CourseTbEntity courseTbEntity,CoursestudentTbEntity coursestudentTbEntity) throws IOException{
        AddCourseStudentShipFactory factory = new AddCourseStudentShipFactory();
        if(factory.produce().createCourseStudentShip(coursestudentTbEntity,courseTbEntity)){
            resp.getWriter().println("<script type=\"text/javascript\">alert(\"添加成功\");</script>");
            resp.sendRedirect("htmls/familyhome/index.jsp");
        }else {
            resp.getWriter().println("<script type=\"text/javascript\">alert(\"添加失败\");</script>");
            resp.sendRedirect("htmls/familyhome/index.jsp");
        }
    }

    private void joinExistsStudentCourse(HttpServletResponse resp,CoursestudentTbEntity coursestudentTbEntity)throws IOException{
        AddCourseStudentShipFactory factory = new AddCourseStudentShipFactory();
        if(factory.produce().joinExistsStudentCourse(coursestudentTbEntity)){
            resp.getWriter().println("<script type=\"text/javascript\">alert(\"选修成功\");</script>");
            resp.sendRedirect("htmls/familyhome/index.jsp");
        }else {
            resp.getWriter().println("<script type=\"text/javascript\">alert(\"选修失败\");</script>");
            resp.sendRedirect("htmls/familyhome/index.jsp");
        }
    }

    private void studentCourseParamsError(HttpServletResponse resp)throws IOException{
        resp.getWriter().println("<script type=\"text/javascript\">alert(\"提交的参数有误\");</script>");
//        resp.sendRedirect("htmls/familyhome/index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


}
