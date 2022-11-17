package com.interfaces;

import com.db.entitys.ScheduletaskTbEntity;

public interface IAddScheduleTaskBus {
    boolean createScheduleTask(ScheduletaskTbEntity scheduletaskTbEntity);
}
