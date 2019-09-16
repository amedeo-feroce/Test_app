/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.service.impl;

import com.acn.nemo.dao.LoginDao;
import com.acn.nemo.dto.LoginDtoInput;
import com.acn.nemo.service.LoginService;

/**
 *
 * @author l
 */
public class LoginServiceImpl implements LoginService {

    private boolean loginDtoOutput;
    private LoginDao loginDao;

    public LoginServiceImpl() {

    }

    @Override
    public boolean checkUsers(String username) {

         loginDao = new LoginDao();
        loginDtoOutput = loginDao.checkUsers(username);

        return loginDtoOutput;
    }

    @Override
    public boolean checkLogin(LoginDtoInput loginDtoInput) {

         loginDao = new LoginDao();
        loginDtoOutput = loginDao.checkLogin(loginDtoInput);

        return loginDtoOutput;
    }
}
