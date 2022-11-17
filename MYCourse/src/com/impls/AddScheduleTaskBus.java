package com.impls;

import com.db.entitys.ScheduletaskTbEntity;
import com.db.factorys.DbFactory;
import com.interfaces.IAddScheduleTaskBus;

public class AddScheduleTaskBus implements IAddScheduleTaskBus {
    @Override
    public boolean createScheduleTask(ScheduletaskTbEntity scheduletaskTbEntity) {
        return DbFactory.scheduleTaskDbDeal().createScheduleTask(scheduletaskTbEntity);
    }
}
