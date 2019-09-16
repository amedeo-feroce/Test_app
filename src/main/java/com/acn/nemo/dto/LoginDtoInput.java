
package com.acn.nemo.dto;

import java.util.Objects;


public class LoginDtoInput {
    
    private String username;
    private String password;
    static boolean check = false;

    public LoginDtoInput() {
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
        int hash = 7;
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
        final LoginDtoInput other = (LoginDtoInput) obj;
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
        return "LoginDtoInput{" + "username=" + username + ", password=" + password + '}';
    }
    
    private static boolean validateDto(String username, String password) {
    return check;}
    
    
    
}
