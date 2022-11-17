package com.serverlets;

import com.db.entitys.SchoolTbEntity;
import com.db.enums.EnumSchoolCreatorType;
import com.factorys.CreateSchoolFactory;
import com.utils.LoadedUserUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

public class CreateSchoolServerlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        String schoolName = req.getParameter("regist_schoolName");
        System.out.println("schoolName = "+schoolName);
        String schoolAddr = req.getParameter("regist_schoolAddr");
        System.out.println("schoolAddr = "+schoolAddr);
        String schoolType = req.getParameter("regist_schoolType");
        Byte schoolCreateType = (byte)EnumSchoolCreatorType.family_creator.ordinal();
        int schoolCreateUserId = LoadedUserUtil.getLoadedUserFamilyUserId();

        SchoolTbEntity schoolTbEntity = new SchoolTbEntity();
        schoolTbEntity.setSchoolName(schoolName);
        schoolTbEntity.setSchoolAddr(schoolAddr);
        schoolTbEntity.setSchoolType(Byte.parseByte(schoolType));
        schoolTbEntity.setSchoolCreatorType(schoolCreateType);
        schoolTbEntity.setSchoolCreatorUserId(schoolCreateUserId);
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        schoolTbEntity.setSchoolCreateTime(createTime);

        CreateSchoolFactory schoolFactory = new CreateSchoolFactory();
        if(schoolFactory.produce().createSchool(schoolTbEntity)){
            resp.getWriter().println("<script type=\"text/javascript\">alert(\"添加成功\");</script>");
            resp.sendRedirect("htmls/familyhome/index.jsp");
        }else {
            resp.getWriter().println("<script type=\"text/javascript\">alert(\"添加失败\");</script>");
            resp.sendRedirect("htmls/familyhome/index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
