package com.interfaces;

import java.util.ArrayList;

public interface IQueryScheduleTaskBus {

    ArrayList getScheduleTasksByCreator(int userId);

    ArrayList getScheduleTasksWithSharer(int userId);

    Object getScheduleTaskByTaskId(int taskId);

}
