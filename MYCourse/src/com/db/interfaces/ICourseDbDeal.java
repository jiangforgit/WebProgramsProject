package com.db.interfaces;

import java.util.Collection;

public interface ICourseDbDeal {

    Collection queryCoursesBySchoolId(int schoolId);
}
