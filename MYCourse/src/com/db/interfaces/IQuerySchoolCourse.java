package com.db.interfaces;

import com.db.enums.EnumSchoolCreatorType;

import java.util.Collection;

public interface IQuerySchoolCourse {
    Collection querySchoolCourses(EnumSchoolCreatorType creatorType,int ID);
}
