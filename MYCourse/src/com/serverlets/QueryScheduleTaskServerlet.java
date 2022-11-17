package com.serverlets;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.db.enums.EnumScheduleTaskType;
import com.db.enums.EnumWeekCourseType;
import com.factorys.QueryScheduleTaskBusFactory;
import com.utils.LoadedUserUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QueryScheduleTaskServerlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        String isScheduleTaskTypeReq = req.getParameter("isScheduleTaskTypeReq");
        String isUserSelfOnly = req.getParameter("isUserSelfOnly");//仅获取登录者自身创建的日程事务
        String isUserSelfAndSharer = req.getParameter("isUserSelfAndSharer");//获取登录者及家庭共享的日程事务
        String isReqByTaskId = req.getParameter("isReqByTaskId");//通过TaskId获取登录者及家庭共享的某一条日程事务
        String taskId = req.getParameter("taskId");
//        System.out.println("isScheduleTaskTypeReq="+isScheduleTaskTypeReq+",isUserSelfOnly="+isUserSelfOnly+",isUserSelfAndSharer="+isUserSelfAndSharer);
        if(null != isScheduleTaskTypeReq){
            if("true".equalsIgnoreCase(isScheduleTaskTypeReq)){
                List<HashMap<String, String>> list = new ArrayList<>();
                for(EnumScheduleTaskType type : EnumScheduleTaskType.values()){
                    HashMap<String,String> map = new HashMap<>();
                    map.put("type",String.valueOf(type.getType()));
                    map.put("typeDes",type.getTypeDes());
                    list.add(map);
                }
                String scheduleTaskTypeJs = JSON.toJSONString(list);
//                System.out.println("scheduleTaskTypeJs="+scheduleTaskTypeJs);
                resp.getWriter().write(scheduleTaskTypeJs);
            }
        }else if(null != isUserSelfOnly) {
            if("true".equalsIgnoreCase(isUserSelfOnly)){
                int familyUserId = LoadedUserUtil.getLoadedUserFamilyUserId();//req.getParameter("familyUserId");
                QueryScheduleTaskBusFactory factory = new QueryScheduleTaskBusFactory();
                ArrayList scheduleTaskList = factory.produce().getScheduleTasksByCreator(familyUserId);
                String scheduleTasksJson = JSON.toJSONString(scheduleTaskList, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
//            System.out.println("scheduleTasksJson="+scheduleTasksJson);
                resp.getWriter().write(scheduleTasksJson);
            }
        } else if (null != isUserSelfAndSharer) {
            if("true".equalsIgnoreCase(isUserSelfAndSharer)){
                int familyUserId = LoadedUserUtil.getLoadedUserFamilyUserId();//req.getParameter("familyUserId");
                QueryScheduleTaskBusFactory factory = new QueryScheduleTaskBusFactory();
                ArrayList scheduleTaskList = factory.produce().getScheduleTasksWithSharer(familyUserId);
                String scheduleTasksJson = JSON.toJSONString(scheduleTaskList, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
//            System.out.println("scheduleTasksJson="+scheduleTasksJson);
                resp.getWriter().write(scheduleTasksJson);
            }
        }else if(null != isReqByTaskId && null != taskId){
            if("true".equalsIgnoreCase(isReqByTaskId) && !"".equalsIgnoreCase(taskId)){
                QueryScheduleTaskBusFactory factory = new QueryScheduleTaskBusFactory();
                Object resultObj = factory.produce().getScheduleTaskByTaskId(Integer.parseInt(taskId));
                String resultObjJson = JSON.toJSONString(resultObj, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
//                System.out.println("resultObjJson="+resultObjJson);
                resp.getWriter().write(resultObjJson);
            }
        }
    }
}
