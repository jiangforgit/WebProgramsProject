package com.serverlets;

import com.alibaba.fastjson.JSONObject;
import com.factorys.RemoveScheduleTaskBusFactory;
import com.utils.LoadedUserUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveScheduleTaskServerlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        String scheduleTaskCreatorId = req.getParameter("scheduleTaskCreatorId");
        String scheduleTaskId = req.getParameter("scheduleTaskId");
        if(null != scheduleTaskCreatorId && null != scheduleTaskId){
            if(LoadedUserUtil.getLoadedUserFamilyUserId() == Integer.parseInt(scheduleTaskCreatorId)){
                RemoveScheduleTaskBusFactory factory = new RemoveScheduleTaskBusFactory();
                if(factory.produce().deleteScheduleTaskById(Integer.parseInt(scheduleTaskId))){
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("resultcode",1);
                    jsonObject.put("resultdes","删除成功");
                    resp.getWriter().write(jsonObject.toJSONString());
                }else {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("resultcode",0);
                    jsonObject.put("resultdes","删除失败");
                    resp.getWriter().write(jsonObject.toJSONString());
                }
            }else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("resultcode",-1);
                jsonObject.put("resultdes","您不是该记录创建者无法执行删除操作。");
                resp.getWriter().write(jsonObject.toJSONString());
            }
        }else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("resultcode",-2);
            jsonObject.put("resultdes","参数有误");
            resp.getWriter().write(jsonObject.toJSONString());
        }
    }
}
