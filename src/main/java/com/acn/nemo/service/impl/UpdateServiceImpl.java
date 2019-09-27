/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.service.impl;

import com.acn.nemo.dao.UpdateDao;
import com.acn.nemo.dto.UpdateDtoInput;
import com.acn.nemo.dto.UpdateDtoOutput;
import com.acn.nemo.service.UpdateService;

/**
 *
 * @author amedeo.feroce
 */
public class UpdateServiceImpl implements UpdateService {

    private UpdateDtoOutput updateDtoOutput;
    private UpdateDao updateDao = new UpdateDao();
    private boolean result = false;

    @Override
    public Boolean updateData(UpdateDtoInput updateDtoInput) {
        
        updateDtoOutput = updateDao.updateData(updateDtoInput);

        if (updateDtoOutput.isModificato()) {
            result = true;
        }

        return result;
    }

   
}
