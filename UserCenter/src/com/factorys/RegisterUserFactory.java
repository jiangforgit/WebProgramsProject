package com.factorys;

import com.impls.RegisterUser;
import com.interfaces.IRegisterUser;
import com.interfaces.IRegisterUserProvider;

public class RegisterUserFactory implements IRegisterUserProvider {

    @Override
    public IRegisterUser produce() {
        return new RegisterUser();
    }
}
