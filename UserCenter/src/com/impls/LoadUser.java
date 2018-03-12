package com.impls;

import com.db.factorys.DbFactory;
import com.interfaces.ILoadUser;

public class LoadUser implements ILoadUser {
    @Override
    public boolean verifyLoad(String identifier, String credential) {
        return DbFactory.verifyUser().verifyPassword(identifier,credential);
    }
}
