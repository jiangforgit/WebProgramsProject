package com.impls;

import com.db.entitys.WeekcourseTbEntity;
import com.db.factorys.DbFactory;
import com.interfaces.IAddWeekCourseBus;

public class AddWeekCourseBus implements IAddWeekCourseBus {
    @Override
    public boolean createWeekCourse(WeekcourseTbEntity weekcourseTbEntity) {
        return DbFactory.weekCourseDbDeal().createWeekCourse(weekcourseTbEntity);
    }
}
