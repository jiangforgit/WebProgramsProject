package com.db.interfaces;

import com.db.entitys.FamilystudentTbEntity;
import com.db.entitys.StudentTbEntity;

public interface IFamilyStudentDbDeal {

    boolean addFamilyAndStudent(FamilystudentTbEntity familystudentTbEntity, StudentTbEntity studentTbEntity);
}
