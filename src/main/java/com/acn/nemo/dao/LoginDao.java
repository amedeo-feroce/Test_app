/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.dao;

import com.acn.nemo.dto.LoginDtoInput;
import com.acn.nemo.dto.LoginDtoOutput;
import com.acn.nemo.utils.DBConnectionUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author l
 */
public class LoginDao {

    private LoginDtoOutput loginDtoOutput;
    private PreparedStatement pstm;
    private ResultSet rs;
    private Connection connection;

    public LoginDao() {
        this.loginDtoOutput = new LoginDtoOutput();
    }

    public boolean checkUsers(String username) {
        boolean trovato = false;
        String query = "select * from utente where username=?";
        try {
            try {
                
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaDerbyTest");
                EntityManager em = emf.createEntityManager();

                EntityTransaction transaction = em.getTransaction();

                transaction.begin();
    
                connection = DBConnectionUtils.getdBConnectionUtils().getConnection();
                pstm = connection.prepareStatement(query);
                pstm.setString(1, username);
                rs = pstm.executeQuery();
                if (rs.first()) {

                    trovato = true;
                }
            } catch (ClassNotFoundException | IOException ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
                rs.close();
                try {
                    DBConnectionUtils.getdBConnectionUtils().closeConnection();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return trovato;
    }

    public boolean checkLogin(LoginDtoInput loginDtoInput) {
        boolean trovato = false;
        String query = "select * from utente where username=?";
        try {
            try {
                connection = DBConnectionUtils.getdBConnectionUtils().getConnection();
                pstm = connection.prepareStatement(query);
                pstm.setString(1, loginDtoInput.getUsername());
                rs = pstm.executeQuery();
                LoginDtoOutput loginDtoOut = new LoginDtoOutput();
            while (rs.next()) {
                
                loginDtoOut.setUsername(rs.getString("username"));
                loginDtoOut.setPassword(rs.getString("password"));

            }
            if (loginDtoOut.equals(loginDtoInput)) {
                trovato = true;
            } } 
            catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return trovato;
    }

}
