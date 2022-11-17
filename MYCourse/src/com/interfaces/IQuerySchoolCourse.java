package com.interfaces;

import com.db.enums.EnumSchoolCreatorType;

import java.util.ArrayList;

public interface IQuerySchoolCourse {
    ArrayList getSchCoursesByFamilyUser(EnumSchoolCreatorType creatorType, int ID);
}
