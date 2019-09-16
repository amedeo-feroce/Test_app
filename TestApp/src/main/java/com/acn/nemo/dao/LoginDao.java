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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author l
 */
public class LoginDao {

    private LoginDtoOutput loginDtoOutput;
    private List<LoginDtoOutput> listDtoOutput = new ArrayList<>();
    private PreparedStatement pstm;
    private ResultSet rs;
    private Connection connection;

    public LoginDao() {
        this.loginDtoOutput = new LoginDtoOutput();
    }

    public boolean checkUsers(String username) {
        boolean trovato = false;
        String query = "select * from users where username=?";
        try {
            try {
                connection = DBConnectionUtils.getdBConnectionUtils().getConnection();
                pstm = connection.prepareStatement(query);
                pstm.setString(1,username);
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
		boolean trovato=false;
		PreparedStatement stm=null;
		ResultSet rs=null;
		String query="select * from utente where username=?";
		try {
			stm=connection.prepareStatement(query);
			stm.setString(1, loginDtoInput.getUsername());
			rs=stm.executeQuery();
			while(rs.next()) {
				loginDtoOutput.setUsername(rs.getString("username"));
				loginDtoOutput.setPassword(rs.getString("password"));
				
			}
			if(loginDtoOutput.equals(loginDtoInput)) {
				trovato=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stm.close();
				rs.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return trovato;		
	}

}
