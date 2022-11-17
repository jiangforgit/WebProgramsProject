package com.serverlets;

import com.db.entitys.FamilystudentTbEntity;
import com.db.entitys.StudentTbEntity;
import com.db.enums.EnumFamilyStudentRelateType;
import com.db.enums.EnumUserSex;
import com.factorys.AddFamilyStudentShipFactory;
import com.utils.LoadedUserUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

public class AddFamilyStudentShipServerlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type","text/html;charset=UTF-8");

        Timestamp createTime = new Timestamp(System.currentTimeMillis());

        String regist_studentName = req.getParameter("regist_studentName");
        String regist_studentInterest = req.getParameter("regist_studentInterest");
        String regist_studentMotto = req.getParameter("regist_studentMotto");
        String regist_studentbirdth_year = req.getParameter("regist_studentbirdth_year");
        String regist_studentbirdth_month = req.getParameter("regist_studentbirdth_month");
        String regist_studentbirdth_day = req.getParameter("regist_studentbirdth_day");
        String regist_studentSex = req.getParameter("regist_studentSex");

        StudentTbEntity studentTbEntity = new StudentTbEntity();
        studentTbEntity.setStudentName(regist_studentName);
        studentTbEntity.setStudentSex((byte) EnumUserSex.valueOf(regist_studentSex).ordinal());
        studentTbEntity.setStudentInterest(regist_studentInterest);
        studentTbEntity.setStudentMotto(regist_studentMotto);
        studentTbEntity.setStudentBirth(Timestamp.valueOf(regist_studentbirdth_year+"-"+regist_studentbirdth_month+"-"+regist_studentbirdth_day+" 00:00:00"));
        studentTbEntity.setStudentCreateTime(createTime);

        FamilystudentTbEntity familystudentTbEntity = new FamilystudentTbEntity();
        familystudentTbEntity.setFamilyStudentFId(LoadedUserUtil.getLoadedUserFamilyUserId());
        familystudentTbEntity.setFamilyStudentRelateType((byte) EnumFamilyStudentRelateType.father_sun.ordinal());
        familystudentTbEntity.setFamilyStudentCreateTime(createTime);

        AddFamilyStudentShipFactory familyStudentSheepFactory = new AddFamilyStudentShipFactory();

        if(familyStudentSheepFactory.produce().createFamilyStudentSheep(familystudentTbEntity,studentTbEntity)){
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
