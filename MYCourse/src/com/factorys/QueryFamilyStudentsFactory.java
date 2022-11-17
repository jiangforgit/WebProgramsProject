package com.factorys;

import com.impls.QueryFamilyStudents;
import com.interfaces.IQueryFamilyStudents;
import com.interfaces.IQueryFamilyStudentsProvider;

public class QueryFamilyStudentsFactory implements IQueryFamilyStudentsProvider {

    @Override
    public IQueryFamilyStudents produce() {
        return new QueryFamilyStudents();
    }
}
