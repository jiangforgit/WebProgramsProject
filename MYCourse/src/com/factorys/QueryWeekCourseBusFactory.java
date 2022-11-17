package com.factorys;

import com.impls.QueryWeekCourseBus;
import com.interfaces.IQueryWeekCourseBus;
import com.interfaces.IQueryWeekCourseBusProvider;

public class QueryWeekCourseBusFactory implements IQueryWeekCourseBusProvider {
    @Override
    public IQueryWeekCourseBus produce() {
        return new QueryWeekCourseBus();
    }
}
