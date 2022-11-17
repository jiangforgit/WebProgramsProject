package com.impls;

import com.db.entitys.SchoolTbEntity;
import com.db.factorys.DbFactory;
import com.interfaces.ICreateSchool;

public class CreateSchool implements ICreateSchool {
    @Override
    public boolean createSchool(SchoolTbEntity schoolTbEntity) {
        return DbFactory.schoolDbDeal().createSchool(schoolTbEntity);
    }
}
