package com.db.interfaces;

import com.db.entitys.CourseTbEntity;
import com.db.entitys.CoursestudentTbEntity;
import javafx.print.Collation;

import java.util.Collection;

public interface ICourseStudentDbDeal {

    boolean createStudentCourse(CoursestudentTbEntity coursestudentTbEntity, CourseTbEntity courseTbEntity);

    boolean joinExistsStudentCourse(CoursestudentTbEntity coursestudentTbEntity);

    Collection queryCoursesByStudentId(int studentId);
}
