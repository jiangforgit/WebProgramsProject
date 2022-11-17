package com.factorys;

import com.impls.CreateSchool;
import com.interfaces.ICreateSchoolProvider;
import com.interfaces.ICreateSchool;

public class CreateSchoolFactory implements ICreateSchoolProvider {
    @Override
    public ICreateSchool produce() {
        return new CreateSchool();
    }
}
