package com.factorys;

import com.impls.AddFamilyStudentShip;
import com.interfaces.IAddFamilyStudentShip;
import com.interfaces.IAddFamilyStudentShipProvider;

public class AddFamilyStudentShipFactory implements IAddFamilyStudentShipProvider {
    @Override
    public IAddFamilyStudentShip produce() {
        return new AddFamilyStudentShip();
    }
}
