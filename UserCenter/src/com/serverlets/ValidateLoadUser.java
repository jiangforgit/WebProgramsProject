package com.serverlets;

import com.factorys.PswLoadUserFactory;
import com.interfaces.ILoadUser;
import com.interfaces.ILoadUserProvider;
import com.utils.PasswordUtil;
import com.utils.PropertiesUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidateLoadUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        ILoadUserProvider provider = new PswLoadUserFactory();
        ILoadUser loadUser = provider.produce();
        if(loadUser.verifyLoad(username, PasswordUtil.EncodeSHA(password))){
            req.getSession().setAttribute("loaduser",username);
            resp.sendRedirect(PropertiesUtil.getPropertyByName2("properties/UserCenter.properties","RootUrl")+"/index.jsp");
        }else {
            resp.sendRedirect(PropertiesUtil.getPropertyByName2("properties/UserCenter.properties","RootUrl")+"/jsp/LoadFail.jsp");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
