package com.db.interfaces;

import com.db.entitys.WeekcourseTbEntity;

import java.util.Collection;

public interface IWeekCourseDbDeal {

    boolean createWeekCourse(WeekcourseTbEntity weekcourseTbEntity);

    Collection queryWeekCourseByStudentId(int studentId);

    Collection queryWeekCourseByCourseId(int studentId);

    boolean deleteWeekCourseById(int weekCourseId);
}
