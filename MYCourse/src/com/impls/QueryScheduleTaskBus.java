package com.impls;

import com.db.factorys.DbFactory;
import com.interfaces.IQueryScheduleTaskBus;

import java.util.ArrayList;

public class QueryScheduleTaskBus implements IQueryScheduleTaskBus {
    @Override
    public ArrayList getScheduleTasksByCreator(int userId) {
        return (ArrayList) DbFactory.scheduleTaskDbDeal().queryScheduleTasksByCreatorId(userId);
    }

    @Override
    public ArrayList getScheduleTasksWithSharer(int userId) {
        return (ArrayList) DbFactory.scheduleTaskDbDeal().queryScheduleTasksWithSharer(userId);
    }

    @Override
    public Object getScheduleTaskByTaskId(int taskId) {
        return DbFactory.scheduleTaskDbDeal().queryScheduleTasksByTaskId(taskId);
    }
}
