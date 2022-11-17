package com.factorys;

import com.impls.AddScheduleTaskBus;
import com.interfaces.IAddScheduleTaskBus;
import com.interfaces.IAddScheduleTaskBusProvider;

public class AddScheduleTaskBusFactory implements IAddScheduleTaskBusProvider {
    @Override
    public IAddScheduleTaskBus produce() {
        return new AddScheduleTaskBus();
    }
}
