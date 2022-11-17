package com.impls;

import com.db.entitys.FamilyuserTbEntity;
import com.db.factorys.DbFactory;
import com.interfaces.IQueryFamilyUserBus;

public class QueryFamilyUserBus implements IQueryFamilyUserBus {
    @Override
    public FamilyuserTbEntity getFamilyUser(int userId) {
        return DbFactory.familyUserDbDeal().getFamilyUserById(userId);
    }
}
