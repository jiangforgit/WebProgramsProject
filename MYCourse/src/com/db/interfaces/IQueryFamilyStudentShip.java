package com.db.interfaces;

import java.util.Collection;

public interface IQueryFamilyStudentShip extends IQueryJoinTbs{

    Collection queryFamilyStudentShips(int familyUserId);
}
