package com.impls;

import com.db.enums.EnumFamilyStudentRelateType;
import com.db.enums.EnumSchoolCreatorType;
import com.db.factorys.DbFactory;
import com.interfaces.IQuerySchool;

import java.util.ArrayList;

public class QuerySchool implements IQuerySchool {
    @Override
    public ArrayList querySchoolByFamilyUserId(int id) {
        return (ArrayList) DbFactory.schoolDbDeal().querySchoolByUserId((byte)EnumSchoolCreatorType.family_creator.ordinal(),id);
    }
}
