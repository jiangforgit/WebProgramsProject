package com.factorys;

import com.impls.QueryFamilyUserBus;
import com.interfaces.IQueryFamilyUserBus;
import com.interfaces.IQueryFamilyUserBusProvider;

public class QueryFamilyUserBusFactory implements IQueryFamilyUserBusProvider {
    @Override
    public IQueryFamilyUserBus produce() {
        return new QueryFamilyUserBus();
    }
}
