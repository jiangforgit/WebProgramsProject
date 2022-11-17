package com.factorys;

import com.impls.QueryScheduleTaskBus;
import com.interfaces.IQueryScheduleTaskBus;
import com.interfaces.IQueryScheduleTaskBusProvider;

public class QueryScheduleTaskBusFactory implements IQueryScheduleTaskBusProvider {
    @Override
    public IQueryScheduleTaskBus produce() {
        return new QueryScheduleTaskBus();
    }
}
