package com.db.interfaces;

import com.db.entitys.StudentTbEntity;

public interface IStudentDbDeal {

    boolean createStudent(StudentTbEntity studentTbEntity);

    StudentTbEntity queryStudentById(int id);
}
