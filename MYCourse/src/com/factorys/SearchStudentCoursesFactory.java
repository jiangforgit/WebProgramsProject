package com.factorys;

import com.interfaces.ISearchStudentCoursesProvider;
import com.impls.SearchStudentCourses;
import com.interfaces.ISearchStudentCourses;

public class SearchStudentCoursesFactory implements ISearchStudentCoursesProvider {

    @Override
    public ISearchStudentCourses produce() {
        return new SearchStudentCourses();
    }
}
