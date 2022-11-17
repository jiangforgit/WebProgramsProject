package com.serverlets;

import com.alibaba.fastjson.JSON;
import com.db.entitys.FamilyuserTbEntity;
import com.factorys.QueryFamilyUserBusFactory;
import com.utils.LoadedUserUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryFamilyUserServerlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        String userId = req.getParameter("familyUserId");
        QueryFamilyUserBusFactory factory = new QueryFamilyUserBusFactory();
        FamilyuserTbEntity familyuserTbEntity = factory.produce().getFamilyUser(Integer.parseInt(userId));
        String familyUserJs = JSON.toJSONString(familyuserTbEntity);
//        System.out.println("familyUserJs="+familyUserJs);
        resp.getWriter().write(familyUserJs);
    }
}
