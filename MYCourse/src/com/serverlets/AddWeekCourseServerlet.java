package com.serverlets;

import com.db.entitys.WeekcourseTbEntity;
import com.factorys.AddWeekCourseBusFactory;
import com.interfaces.IAddWeekCourseBusProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class AddWeekCourseServerlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        Timestamp createTime = new Timestamp(System.currentTimeMillis());

        String addWeekCourse_course_student = req.getParameter("addWeekCourse_course_student");
        String addWeekCourse_courseType = req.getParameter("addWeekCourse_courseType");
        String addWeekCourse_course = req.getParameter("addWeekCourse_course");
        String addWeekCourse_start = req.getParameter("addWeekCourse_start");
        String addWeekCourse_end = req.getParameter("addWeekCourse_end");

//        System.out.println("addWeekCourse_course_student="+addWeekCourse_course_student+",addWeekCourse_courseType="+addWeekCourse_courseType+",addWeekCourse_course="+addWeekCourse_course+",addWeekCourse_start="+addWeekCourse_start+",addWeekCourse_end="+addWeekCourse_end);

        WeekcourseTbEntity weekcourseTbEntity = new WeekcourseTbEntity();
        weekcourseTbEntity.setWeekCourseCId(Integer.parseInt(addWeekCourse_course));
        weekcourseTbEntity.setWeekCourseSId(Integer.parseInt(addWeekCourse_course_student));
        weekcourseTbEntity.setWeekCourseType(Byte.parseByte(addWeekCourse_courseType));

        String sdateTime[] = addWeekCourse_start.split("T");//2022-10-26T22:50

        String sDate[] = sdateTime[0].split("-");
        Date sdate = new Date(Integer.parseInt(sDate[0])-1900,Integer.parseInt(sDate[1])-1,Integer.parseInt(sDate[2]));
        weekcourseTbEntity.setWeekCourseStartDate(sdate);
        weekcourseTbEntity.setWeekCourseWeekDay((byte) sdate.getDay());

        String sTime[] = sdateTime[1].split(":");
        Time stime = new Time(Integer.parseInt(sTime[0]),Integer.parseInt(sTime[1]),0);
        weekcourseTbEntity.setWeekCourseStartTime(stime);

        String edateTime[] = addWeekCourse_end.split("T");

        String eDate[] = edateTime[0].split("-");
        Date edate = new Date(Integer.parseInt(eDate[0])-1900,Integer.parseInt(eDate[1])-1,Integer.parseInt(eDate[2]));
        weekcourseTbEntity.setWeekCourseEndDate(edate);

        String eTime[] = edateTime[1].split(":");
        Time etime = new Time(Integer.parseInt(eTime[0]),Integer.parseInt(eTime[1]),0);
        weekcourseTbEntity.setWeekCourseEndTime(etime);

        weekcourseTbEntity.setWeekCourseCreateTime(createTime);

        AddWeekCourseBusFactory factory = new AddWeekCourseBusFactory();
        if(factory.produce().createWeekCourse(weekcourseTbEntity)){
            resp.sendRedirect("htmls/public_resource/fullcalendar/weekcourse_calendar.html");
            resp.getWriter().println("<script type=\"text/javascript\">alert(\"添加成功\");</script>");
        }else {
            resp.sendRedirect("htmls/public_resource/fullcalendar/weekcourse_calendar.html");
            resp.getWriter().println("<script type=\"text/javascript\">alert(\"添加失败\");</script>");
        }
    }
}
