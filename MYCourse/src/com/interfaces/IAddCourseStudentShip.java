package com.interfaces;

import com.db.entitys.CourseTbEntity;
import com.db.entitys.CoursestudentTbEntity;

public interface IAddCourseStudentShip {
    boolean createCourseStudentShip(CoursestudentTbEntity coursestudentTbEntity, CourseTbEntity courseTbEntity);

    boolean joinExistsStudentCourse(CoursestudentTbEntity coursestudentTbEntity);
}
