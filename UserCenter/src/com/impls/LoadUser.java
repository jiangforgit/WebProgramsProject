package com.impls;

import com.db.factorys.DbFactory;
import com.interfaces.ILoadUser;

public class LoadUser implements ILoadUser {
    @Override
    public boolean verifyLoad(String userName, String password) {
        return DbFactory.verifyUser().verifyPassword(userName,password);
    }
}
