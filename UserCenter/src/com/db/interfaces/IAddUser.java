package com.db.interfaces;

import com.db.entitys.UsersTbEntity;

public interface IAddUser {

    boolean createUser(UsersTbEntity usersEntity);
}
