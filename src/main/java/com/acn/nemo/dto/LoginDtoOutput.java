/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.dto;

import java.util.Objects;
import javax.persistence.EntityManager;

/**
 *
 * @author l
 */
public class LoginDtoOutput {

    private String username;
    private String password;
    private boolean trovato;
    

    public LoginDtoOutput() {
    }

    public LoginDtoOutput(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isTrovato() {
        return trovato;
    }

    public void setTrovato(boolean trovato) {
        this.trovato = trovato;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoginDtoOutput other = (LoginDtoOutput) obj;
        if (this.trovato != other.trovato) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LoginDtoOutput{" + "username=" + username + ", password=" + password + ", trovato=" + trovato + '}';
    }

    
    

}
