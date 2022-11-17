package com.impls;

import com.db.entitys.FamilystudentTbEntity;
import com.db.entitys.StudentTbEntity;
import com.db.factorys.DbFactory;
import com.interfaces.IAddFamilyStudentShip;

public class AddFamilyStudentShip implements IAddFamilyStudentShip {

    @Override
    public boolean createFamilyStudentSheep(FamilystudentTbEntity familystudentTbEntity, StudentTbEntity studentTbEntity) {
        return DbFactory.familyStudentDbDeal().addFamilyAndStudent(familystudentTbEntity,studentTbEntity);
    }
}
