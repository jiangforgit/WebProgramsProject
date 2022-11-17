package com.factorys;

import com.impls.QuerySchoolCourse;
import com.interfaces.IQuerySchoolCourse;
import com.interfaces.IQuerySchoolCourseProvider;

public class QuerySchoolCourseFactory implements IQuerySchoolCourseProvider {
    @Override
    public IQuerySchoolCourse produce() {
        return new QuerySchoolCourse();
    }
}
