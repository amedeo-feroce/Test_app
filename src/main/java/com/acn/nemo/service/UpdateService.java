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
    
     public boolean readCod ();
    public boolean readCod (int id);
    public Boolean updateData(UpdateDtoInput updateDtoInput);
    public Boolean deleteData (UpdateDtoInput updateDtoInput);
    
}
