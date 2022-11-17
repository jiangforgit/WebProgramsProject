package com.impls;

import com.db.entitys.UsersTbEntity;
import com.db.factorys.DbFactory;
import com.interfaces.IRegisterUser;

public class RegisterUser implements IRegisterUser {
    @Override
    public boolean registerUser(UsersTbEntity usersEntity) {
        return DbFactory.addUser().createUser(usersEntity);
    }
}
