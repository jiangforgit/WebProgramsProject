package com.impls;

import com.db.factorys.DbFactory;
import com.interfaces.IQueryFamilyStudents;

import java.util.ArrayList;

public class QueryFamilyStudents implements IQueryFamilyStudents {

    @Override
    public ArrayList getFamilyStudents(int familyUerId) {
        return (ArrayList) DbFactory.familyStudentShip().queryFamilyStudentShips(familyUerId);
    }
}
