package com.db.interfaces;

import java.util.Collection;

public interface IQueryStudentCourses extends IQueryJoinTbs{
    Collection queryJoinTbs(int familyUserId);
}
