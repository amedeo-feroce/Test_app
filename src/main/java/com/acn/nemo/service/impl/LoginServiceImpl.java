/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.service.impl;

import com.acn.nemo.dao.LoginDao;
import com.acn.nemo.dto.LoginDtoInput;
import com.acn.nemo.dto.LoginDtoOutput;
import com.acn.nemo.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author l
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginServiceImpl implements LoginService {

    private LoginDtoOutput loginDtoOutput;
    private LoginDao loginDao =new LoginDao();
    private boolean result = false;

  

    /**
     *
     * @param loginDtoInput
     * @return
     */
    @Override
    public Boolean checkLogin(LoginDtoInput loginDtoInput) {

        loginDtoOutput = loginDao.checkLogin(loginDtoInput);
        
        if (loginDtoOutput.isTrovato() && !loginDtoOutput.isRegistrato()) {
            result = true;
        }

        return result;
    }

    
    @Override
    /**
     * Il metodo verifica se utente già registrato
     * @param loginDtoInput
     * @return true-false
     */
    public Boolean insertLogin(LoginDtoInput loginDtoInput) {

        loginDtoOutput = loginDao.insertLogin(loginDtoInput);
        if (loginDtoOutput.isRegistrato() && !loginDtoOutput.isTrovato()) {
            result = true;
        }
        return result;
    }

}
