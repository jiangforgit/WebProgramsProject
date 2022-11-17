package com.impls;

import com.db.factorys.DbFactory;
import com.interfaces.IQueryCourses;

import java.util.ArrayList;

public class QueryCourses implements IQueryCourses {
    @Override
    public ArrayList getCoursesBySchoolId(int schoolId) {
        return (ArrayList) DbFactory.courseDbDeal().queryCoursesBySchoolId(schoolId);
    }
}
