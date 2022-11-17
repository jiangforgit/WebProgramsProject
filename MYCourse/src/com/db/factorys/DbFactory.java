package com.db.factorys;

import com.db.impls.*;
import com.db.interfaces.*;

public class DbFactory {

    public static IStudentDbDeal studentDbDeal(){
        return new StudentDbDeal();
    }

    public static IQueryStudentCourses queryStudentCourses(){return new QueryStudentCourses();}

    public static ISchoolDbDeal schoolDbDeal(){return new SchoolDbDeal();}

    public static IFamilyStudentDbDeal familyStudentDbDeal(){return new FamilyStudentDbDeal();}

    public static IQueryFamilyStudentShip familyStudentShip(){return new QueryFamilyStudentShips();}

    public static ICourseDbDeal courseDbDeal(){return new CourseDbDeal();}

    public static ICourseStudentDbDeal courseStudentDbDeal(){return new CourseStudentDbDeal();}

    public static IQuerySchoolCourse schoolCourseDeal(){return new QuerySchoolCourse();}

    public static IWeekCourseDbDeal weekCourseDbDeal(){return new WeekCourseDbDeal();}

    public static IScheduleTaskDbDeal scheduleTaskDbDeal(){return new ScheduleTaskDbDeal();}

    public static IFamilyUserDbDeal familyUserDbDeal(){return new FamilyUserDbDeal();}
}
