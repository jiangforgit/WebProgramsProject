package com.impls;

import com.db.factorys.DbFactory;
import com.interfaces.ISearchStudentCourses;

import java.util.ArrayList;

public class SearchStudentCourses implements ISearchStudentCourses {

    @Override
    public ArrayList getFamilyStudentsCourses(int familyUserId)throws IllegalArgumentException {
        return (ArrayList) DbFactory.queryStudentCourses().queryJoinTbs(familyUserId);
    }

    @Override
    public ArrayList getCoursesByStudentId(int studentId) {
        return (ArrayList) DbFactory.courseStudentDbDeal().queryCoursesByStudentId(studentId);
    }
}
