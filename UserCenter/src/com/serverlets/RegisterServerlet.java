package com.serverlets;

import com.db.entitys.UserAuthsEntity;
import com.db.entitys.UsersEntity;
import com.db.enums.EnumIdentityType;
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
import java.util.UUID;

@WebServlet(name = "RegisterServerlet")
public class RegisterServerlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        RegisterUserFactory factory = new RegisterUserFactory();
        IRegisterUser registerUser = factory.produce();
        System.out.println("username="+userName+",password="+password);
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(UUID.randomUUID().toString());
        usersEntity.setUserName(userName);
        usersEntity.setUserSex(EnumUserSex.m.toString());
        usersEntity.setUserLogo("logo");
        UserAuthsEntity authsEntity = new UserAuthsEntity();
        authsEntity.setId(UUID.randomUUID().toString());
        authsEntity.setIdentityType(EnumIdentityType.passwordlogin.ordinal());
        authsEntity.setIdentifier(userName);
        String credential = PasswordUtil.EncodeSHA(password);
//        System.out.println("credential="+credential);
//        System.out.println("verify="+PasswordUtil.verify(password,credential));
        authsEntity.setCredential(credential);
        authsEntity.setUserId(usersEntity.getId());
        if(registerUser.registerUser(usersEntity,authsEntity)){
            response.getWriter().println("alert(\"注册成功\")");
            response.sendRedirect(PropertiesUtil.getPropertyByName2("properties/UserCenter.properties","RootUrl")+"/jsp/login.jsp");
        }else {
            response.getWriter().println("alert(\"注册失败\")");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
