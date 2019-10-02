/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 *
 * @author amedeo.feroce
 */
public class UpdateDtoInput {
    
    private short cod_promo;
    private short pgr_promo;
    private short pgr_riga;
    private int sconto_p;
    private String tipo_promo;
    private String descrizione;
    private String desc_tipo;
    private int id;
    
   
    
}
