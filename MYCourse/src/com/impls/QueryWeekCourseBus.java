package com.impls;

import com.db.factorys.DbFactory;
import com.interfaces.IQueryWeekCourseBus;

import java.util.ArrayList;

public class QueryWeekCourseBus implements IQueryWeekCourseBus {
    @Override
    public ArrayList getWeekCourseByStudent(int studentId) {
        return (ArrayList) DbFactory.weekCourseDbDeal().queryWeekCourseByStudentId(studentId);
    }
}
