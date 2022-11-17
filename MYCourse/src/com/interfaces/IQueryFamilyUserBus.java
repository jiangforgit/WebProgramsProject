package com.interfaces;

import com.db.entitys.FamilyuserTbEntity;

public interface IQueryFamilyUserBus {
    FamilyuserTbEntity getFamilyUser(int userId);
}
