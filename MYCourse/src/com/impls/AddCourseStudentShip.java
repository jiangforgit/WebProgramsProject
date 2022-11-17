package com.impls;

import com.db.entitys.CourseTbEntity;
import com.db.entitys.CoursestudentTbEntity;
import com.db.factorys.DbFactory;
import com.interfaces.IAddCourseStudentShip;

public class AddCourseStudentShip implements IAddCourseStudentShip {
    @Override
    public boolean createCourseStudentShip(CoursestudentTbEntity coursestudentTbEntity, CourseTbEntity courseTbEntity) {
        return DbFactory.courseStudentDbDeal().createStudentCourse(coursestudentTbEntity,courseTbEntity);
    }

    @Override
    public boolean joinExistsStudentCourse(CoursestudentTbEntity coursestudentTbEntity) {
        return DbFactory.courseStudentDbDeal().joinExistsStudentCourse(coursestudentTbEntity);
    }
}
