package com.serverlets;

import com.db.entitys.ScheduletaskTbEntity;
import com.factorys.AddScheduleTaskBusFactory;
import com.utils.LoadedUserUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class AddScheduleTaskServerlet extends HttpServlet {
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
        ScheduletaskTbEntity scheduletaskTbEntity = new ScheduletaskTbEntity();

        String scheduleTaskTitle = req.getParameter("addScheduleTask_title");
        scheduletaskTbEntity.setScheduleTaskTitle(scheduleTaskTitle);
        String scheduleTaskContent = req.getParameter("addScheduleTask_content");
        if(null != scheduleTaskContent){
            scheduletaskTbEntity.setScheduleTaskContent(scheduleTaskContent);
        }
        String scheduleTaskPicPath = req.getParameter("addScheduleTask_picture");
        if(null != scheduleTaskPicPath){
            scheduletaskTbEntity.setScheduleTaskPicPath(scheduleTaskPicPath);
        }
        String scheduleTaskAudioPath = req.getParameter("addScheduleTask_audio");
        if(null != scheduleTaskAudioPath){
            scheduletaskTbEntity.setScheduleTaskAudioPath(scheduleTaskAudioPath);
        }
        scheduletaskTbEntity.setScheduleTaskStatus((byte) 0);
        String scheduleTaskFullShare = req.getParameter("addScheduleTask_fullshare");
        if(null != scheduleTaskFullShare){
            if("on".equalsIgnoreCase(scheduleTaskFullShare)){
                scheduletaskTbEntity.setScheduleTaskFullShare((byte)1);
            }
        }

        String scheduleTaskStartTime = req.getParameter("addScheduleTask_start");
        String scheduleTaskEndTime = req.getParameter("addScheduleTask_end");

        String sdateTime[] = scheduleTaskStartTime.split("T");//2022-10-26T22:50

        String sDate[] = sdateTime[0].split("-");
        Date sdate = new Date(Integer.parseInt(sDate[0])-1900,Integer.parseInt(sDate[1])-1,Integer.parseInt(sDate[2]));
        scheduletaskTbEntity.setScheduleTaskStartDate(sdate);

        String sTime[] = sdateTime[1].split(":");
        Time stime = new Time(Integer.parseInt(sTime[0]),Integer.parseInt(sTime[1]),0);
        scheduletaskTbEntity.setScheduleTaskStartTime(stime);

        String edateTime[] = scheduleTaskEndTime.split("T");

        String eDate[] = edateTime[0].split("-");
        Date edate = new Date(Integer.parseInt(eDate[0])-1900,Integer.parseInt(eDate[1])-1,Integer.parseInt(eDate[2]));
        scheduletaskTbEntity.setScheduleTaskEndDate(edate);

        String eTime[] = edateTime[1].split(":");
        Time etime = new Time(Integer.parseInt(eTime[0]),Integer.parseInt(eTime[1]),0);
        scheduletaskTbEntity.setScheduleTaskEndTime(etime);

        String scheduleTaskRemindTime = req.getParameter("addScheduleTask_reminder");
        if(null != scheduleTaskRemindTime){
            scheduletaskTbEntity.setScheduleTaskRemindTime(Integer.parseInt(scheduleTaskRemindTime));
        }else {
            scheduletaskTbEntity.setScheduleTaskRemindTime(40);
        }
        scheduletaskTbEntity.setScheduleTaskIsReminded((byte)0);
        String scheduleTaskType = req.getParameter("addScheduleTask_scheduletasktype");
        if(null != scheduleTaskType){
            scheduletaskTbEntity.setScheduleTaskType(Byte.parseByte(scheduleTaskType));
        }else {
            scheduletaskTbEntity.setScheduleTaskType((byte) 0);
        }
        scheduletaskTbEntity.setScheduleTaskCreator(LoadedUserUtil.getLoadedUserFamilyUserId());
        scheduletaskTbEntity.setScheduleTaskCreateTime(createTime);

        AddScheduleTaskBusFactory factory = new AddScheduleTaskBusFactory();
        if(factory.produce().createScheduleTask(scheduletaskTbEntity)){
            resp.sendRedirect("htmls/public_resource/fullcalendar/scheduletask_calendar.html");
            resp.getWriter().println("<script type=\"text/javascript\">alert(\"添加成功\");</script>");
        }else {
            resp.sendRedirect("htmls/public_resource/fullcalendar/scheduletask_calendar.html");
            resp.getWriter().println("<script type=\"text/javascript\">alert(\"添加失败\");</script>");
        }
    }
}
