package com.factorys;

import com.impls.QueryCourses;
import com.interfaces.IQueryCourses;
import com.interfaces.IQueryCoursesProvider;

public class QueryCoursesFactory implements IQueryCoursesProvider {
    @Override
    public IQueryCourses produce() {
        return new QueryCourses();
    }
}
