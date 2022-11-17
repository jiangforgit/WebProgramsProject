package com.interfaces;

import com.db.entitys.WeekcourseTbEntity;

public interface IAddWeekCourseBus {
    boolean createWeekCourse(WeekcourseTbEntity weekcourseTbEntity);
}
