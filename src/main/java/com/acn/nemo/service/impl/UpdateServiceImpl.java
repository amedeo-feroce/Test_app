/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.service.impl;

import com.acn.nemo.dao.UpdateDao;
import com.acn.nemo.dto.UpdateDtoInput;
import com.acn.nemo.dto.UpdateDtoOutput;
import com.acn.nemo.model.Farma_promo_def;
import com.acn.nemo.service.UpdateService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author amedeo.feroce
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UpdateServiceImpl implements UpdateService {

    private UpdateDtoOutput updateDtoOutput;
    private UpdateDao updateDao;
    private boolean result = false;

    @Override
    public boolean readCod() {

        return true;
    }

    @Override
    public boolean readCod(int id) {
        updateDao = new UpdateDao();
        updateDtoOutput = updateDao.readCod(id);
        if (updateDtoOutput.isTrovato()) {
            result = true;
        }
        return result;
    }

    @Override
    public Boolean updateData(UpdateDtoInput updateDtoInput) {
        updateDao = new UpdateDao();

        updateDtoOutput = updateDao.updateData(updateDtoInput);

        if (updateDtoOutput.isModificato()) {
            result = true;
        }

        return result;
    }

    @Override
    public Boolean deleteData(UpdateDtoInput updateDtoInput) {
        updateDao = new UpdateDao();

        updateDtoOutput = updateDao.deleteData(updateDtoInput);

        if (updateDtoOutput.isEliminato()) {
            result = true;
        }
        return result;
    }

}
