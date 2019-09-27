/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.service;


import com.acn.nemo.dto.UpdateDtoInput;

/**
 *
 * @author amedeo.feroce
 */
public interface UpdateService {
    public Boolean updateData(UpdateDtoInput updateDtoInput);
    
}
