package com.factorys;

import com.impls.RemoveWeekCourseBus;
import com.interfaces.IRemoveWeekCourseBus;
import com.interfaces.IRemoveWeekCourseBusProvider;

public class RemoveWeekCourseBusFactory implements IRemoveWeekCourseBusProvider {
    @Override
    public IRemoveWeekCourseBus produce() {
        return new RemoveWeekCourseBus();
    }
}
