package com.factorys;

import com.impls.RemoveScheduleTaskBus;
import com.interfaces.IRemoveScheduleTaskBus;
import com.interfaces.IRemoveScheduleTaskBusProvider;

public class RemoveScheduleTaskBusFactory implements IRemoveScheduleTaskBusProvider {
    @Override
    public IRemoveScheduleTaskBus produce() {
        return new RemoveScheduleTaskBus();
    }
}
