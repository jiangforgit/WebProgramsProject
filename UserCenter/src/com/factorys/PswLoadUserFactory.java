package com.factorys;

import com.impls.LoadUser;
import com.interfaces.ILoadUser;
import com.interfaces.ILoadUserProvider;

public class PswLoadUserFactory implements ILoadUserProvider {
    @Override
    public ILoadUser produce() {
        return new LoadUser();
    }
}
