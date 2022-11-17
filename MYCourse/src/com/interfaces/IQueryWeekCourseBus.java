package com.interfaces;

import com.db.entitys.WeekcourseTbEntity;

import java.util.ArrayList;

public interface IQueryWeekCourseBus {

    ArrayList getWeekCourseByStudent(int studentId);

}
