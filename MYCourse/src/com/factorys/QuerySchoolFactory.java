package com.factorys;

import com.impls.QuerySchool;
import com.interfaces.IQuerySchool;
import com.interfaces.IQuerySchoolProvider;

import java.util.ArrayList;

public class QuerySchoolFactory implements IQuerySchoolProvider {

    @Override
    public IQuerySchool produce() {
        return new QuerySchool();
    }
}
