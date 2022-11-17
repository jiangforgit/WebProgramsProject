package com.serverlets;

import com.alibaba.fastjson.JSON;
import com.factorys.QueryFamilyStudentsFactory;
import com.utils.LoadedUserUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class QueryFamilyStudentsServerlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        int familyUserId = LoadedUserUtil.getLoadedUserFamilyUserId();//req.getParameter("familyUserId");
        QueryFamilyStudentsFactory factory = new QueryFamilyStudentsFactory();

        ArrayList fsList = factory.produce().getFamilyStudents(familyUserId);
        String familyStudentsJson = JSON.toJSONString(fsList);
        resp.getWriter().write(familyStudentsJson);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
