package com.serverlets;

import com.db.entitys.UsersTbEntity;
import com.db.enums.EnumUserSex;
import com.factorys.RegisterUserFactory;
import com.interfaces.IRegisterUser;
import com.utils.PasswordUtil;
import com.utils.PropertiesUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Timestamp;

@WebServlet(name = "RegisterServerlet")
public class RegisterServerlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("regist_userName");
        String userSex = request.getParameter("regist_sex");
        String userEmail = request.getParameter("regist_email");
        String password = request.getParameter("regist_password");

        RegisterUserFactory factory = new RegisterUserFactory();
        IRegisterUser registerUser = factory.produce();
        UsersTbEntity usersEntity = new UsersTbEntity();
        usersEntity.setUserName(userName);
        try {
            usersEntity.setUserSex(EnumUserSex.valueOf(userSex).ordinal());
        }catch (IllegalArgumentException ie){
            throw new RuntimeException(ie);
        }

        usersEntity.setUserEmail(userEmail);
        try {
            String saltAndPsd = PasswordUtil.getSaltPsdByPBKDF2(password);
            usersEntity.setUserPassword(saltAndPsd);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        usersEntity.setUserCreateTime(createTime);
        if(registerUser.registerUser(usersEntity)){
            response.sendRedirect(PropertiesUtil.getPropertyByLoader("properties/UserCenter.properties","RootUrl")+"/jsp/UserRegisterLoad.jsp");
        }else {
            response.getWriter().println("alert(\"注册失败\")");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
