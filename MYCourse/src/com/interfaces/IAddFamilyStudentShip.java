package com.interfaces;

import com.db.entitys.FamilystudentTbEntity;
import com.db.entitys.StudentTbEntity;

public interface IAddFamilyStudentShip {

    boolean createFamilyStudentSheep(FamilystudentTbEntity familystudentTbEntity, StudentTbEntity studentTbEntity);
}
