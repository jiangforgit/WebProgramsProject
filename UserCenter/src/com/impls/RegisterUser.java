package com.impls;

import com.db.entitys.UserAuthsEntity;
import com.db.entitys.UsersEntity;
import com.db.factorys.DbFactory;
import com.interfaces.IRegisterUser;

public class RegisterUser implements IRegisterUser {
    @Override
    public boolean registerUser(UsersEntity usersEntity, UserAuthsEntity userAuthsEntity) {
        return DbFactory.addUser().createUser(usersEntity,userAuthsEntity);
    }
}
