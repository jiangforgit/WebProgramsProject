package com.db.interfaces;

import com.db.entitys.UserAuthsEntity;
import com.db.entitys.UsersEntity;

public interface IAddUser {

    boolean createUser(UsersEntity usersEntity, UserAuthsEntity userAuthsEntity);
}
