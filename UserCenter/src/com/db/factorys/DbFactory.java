package com.db.factorys;

import com.db.impls.AddUser;
import com.db.impls.VerifyUser;
import com.db.interfaces.IAddUser;
import com.db.interfaces.IVerifyUser;

public class DbFactory {

    public static IVerifyUser verifyUser(){
        return new VerifyUser();
    }

    public static IAddUser addUser(){
        return new AddUser();
    }
}
