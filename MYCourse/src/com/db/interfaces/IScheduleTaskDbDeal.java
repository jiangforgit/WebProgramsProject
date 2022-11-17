package com.db.interfaces;

import com.db.entitys.ScheduletaskTbEntity;
import com.db.entitys.SchoolTbEntity;

import java.util.Collection;

public interface IScheduleTaskDbDeal {

    boolean createScheduleTask(ScheduletaskTbEntity scheduletaskTbEntity);

    Collection queryScheduleTasksByCreatorId (int userId);

    Collection queryScheduleTasksWithSharer (int userId);

    Object queryScheduleTasksByTaskId(int taskId);

    boolean deleteScheduleTaskById(int id);
}
