package com.interfaces;

import com.db.entitys.UserAuthsEntity;
import com.db.entitys.UsersEntity;

public interface IRegisterUser {

    boolean registerUser(UsersEntity usersEntity, UserAuthsEntity userAuthsEntity);
}
