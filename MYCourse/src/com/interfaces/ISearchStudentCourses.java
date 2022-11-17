package com.interfaces;

import java.util.ArrayList;

public interface ISearchStudentCourses {

    ArrayList getFamilyStudentsCourses(int familyUserId);

    ArrayList getCoursesByStudentId(int studentId);
}
