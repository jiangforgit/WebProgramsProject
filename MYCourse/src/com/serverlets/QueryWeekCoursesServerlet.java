package com.serverlets;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.db.enums.EnumWeekCourseType;
import com.factorys.QueryFamilyStudentsFactory;
import com.factorys.QueryWeekCourseBusFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryWeekCoursesServerlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        String studentId = req.getParameter("studentId");
        QueryWeekCourseBusFactory factory = new QueryWeekCourseBusFactory();

        String isWeekCourseTypeReq = req.getParameter("isWeekCourseTypeReq");

        if(null != studentId){
            ArrayList weekcourseList = factory.produce().getWeekCourseByStudent(Integer.parseInt(studentId));
            String weekCoursesJson = JSON.toJSONString(weekcourseList,SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
//            System.out.println("weekCoursesJson="+weekCoursesJson);
            resp.getWriter().write(weekCoursesJson);
        }else if(null != isWeekCourseTypeReq){
            if("true".equalsIgnoreCase(isWeekCourseTypeReq)){
                List<HashMap<String, String>> list = new ArrayList<>();
                for(EnumWeekCourseType type : EnumWeekCourseType.values()){
                    HashMap<String,String> map = new HashMap<>();
                    map.put("type",String.valueOf(type.getType()));
                    map.put("typeDes",type.getTypeDes());
                    list.add(map);
                }
                String weekCourseTypeJs = JSON.toJSONString(list);
//                System.out.println("weekCourseTypeJs="+weekCourseTypeJs);
                resp.getWriter().write(weekCourseTypeJs);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
