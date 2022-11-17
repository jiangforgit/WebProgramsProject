package com.impls;

import com.db.factorys.DbFactory;
import com.interfaces.IRemoveScheduleTaskBus;

public class RemoveScheduleTaskBus implements IRemoveScheduleTaskBus {
    @Override
    public boolean deleteScheduleTaskById(int id) {
        return DbFactory.scheduleTaskDbDeal().deleteScheduleTaskById(id);
    }
}
