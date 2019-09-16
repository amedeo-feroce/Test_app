/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author l
 */
public class DBConnectionUtils {
    private static Connection connection;

    private static DBConnectionUtils dBConnectionUtils;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/Connection.properties");
            Properties prop = new Properties();
            prop.load(fis);
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            String driver = prop.getProperty("driver");
            Class.forName(driver);

            connection = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            Logger.getLogger(DBConnectionUtils.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private DBConnectionUtils() {
    }

    /**
     *
     * @return @throws SQLException
     * @throws ClassNotFoundException
     */
    public static synchronized DBConnectionUtils getdBConnectionUtils() throws SQLException, ClassNotFoundException, IOException {
        if (dBConnectionUtils == null) {
            dBConnectionUtils = new DBConnectionUtils();
        }
        return dBConnectionUtils;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
//        if( connection == null){
//           Class.forName(driver);
//           connection = DriverManager.getConnection(url, username, password);
//        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public boolean checkConnection() throws SQLException {
        return connection.isClosed();

    }

    
}
