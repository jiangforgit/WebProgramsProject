package com.factorys;

import com.impls.AddCourseStudentShip;
import com.interfaces.IAddCourseStudentShip;
import com.interfaces.IAddCourseStudentShipProvider;

public class AddCourseStudentShipFactory implements IAddCourseStudentShipProvider {
    @Override
    public IAddCourseStudentShip produce() {
        return new AddCourseStudentShip();
    }
}
