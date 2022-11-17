package com.db.interfaces;

import com.db.entitys.SchoolTbEntity;

import java.util.Collection;

public interface ISchoolDbDeal {

    boolean createSchool(SchoolTbEntity schoolTbEntity);

    Collection querySchoolByUserId (byte creatorType, int userId);
}
