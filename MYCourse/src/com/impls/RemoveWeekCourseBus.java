package com.impls;

import com.db.factorys.DbFactory;
import com.interfaces.IRemoveWeekCourseBus;

public class RemoveWeekCourseBus implements IRemoveWeekCourseBus {
    @Override
    public boolean deleteWeekCourseWithId(int id) {
        return DbFactory.weekCourseDbDeal().deleteWeekCourseById(id);
    }
}
