package com.impls;

import com.db.enums.EnumSchoolCreatorType;
import com.db.factorys.DbFactory;
import com.interfaces.IQuerySchoolCourse;

import java.util.ArrayList;

public class QuerySchoolCourse implements IQuerySchoolCourse {
    @Override
    public ArrayList getSchCoursesByFamilyUser(EnumSchoolCreatorType creatorType, int ID) {
        return (ArrayList) DbFactory.schoolCourseDeal().querySchoolCourses(creatorType,ID);
    }
}
