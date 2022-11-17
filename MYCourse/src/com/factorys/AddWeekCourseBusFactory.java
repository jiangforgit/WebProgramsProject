package com.factorys;

import com.impls.AddWeekCourseBus;
import com.interfaces.IAddWeekCourseBus;
import com.interfaces.IAddWeekCourseBusProvider;

public class AddWeekCourseBusFactory implements IAddWeekCourseBusProvider {
    @Override
    public IAddWeekCourseBus produce() {
        return new AddWeekCourseBus();
    }
}
