/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.dto;

import java.util.Date;
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
public class UpdateDtoOutput {
    private int cod_promo;
    private int pgr_promo;
    private int pgr_riga;
    private Date data_inizio_promo;
    private Date data_fine_promo;
    private String seg_cli;
    private int valore_tp;
    private int sconto_p;
    private int nro_volte;
    private String tipo;
    private String tipo_promo;
    private String descrizione;
    private String iniziativa;
    private int tipo_promo_vs;
    private String desc_tipo;
    private Date dt_mod;
    private boolean modificato;
    
}
