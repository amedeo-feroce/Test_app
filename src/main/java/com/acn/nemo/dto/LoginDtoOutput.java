/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.dto;

import java.util.Objects;
import javax.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 *
 * @author l
 */
public class LoginDtoOutput {

    private String username;
    private String password;
    private boolean trovato;
    private boolean registrato;

}
