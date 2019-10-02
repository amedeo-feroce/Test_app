/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.dao;

import com.acn.nemo.controller.LoginController;
import com.acn.nemo.dto.LoginDtoInput;
import com.acn.nemo.dto.LoginDtoOutput;
import com.acn.nemo.model.Login;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.log4j.Logger;


/**
 *
 * @author l
 */
public class LoginDao {

    private static final Logger logger = Logger.getLogger(LoginDao.class);

    private LoginDtoOutput loginDtoOutput;
    @PersistenceUnit
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("C3BO_MW");
    @PersistenceContext
    private EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    boolean trovato = false;
    boolean registrato = false;

    public LoginDao() {
        this.loginDtoOutput = new LoginDtoOutput();
    }

    public LoginDtoOutput checkLogin(LoginDtoInput loginDtoInput) {

        transaction.begin();
        
        List<Login> login = findUserExist(loginDtoInput);
        
       em.close();

        for (Login log : login) {
            if (!login.isEmpty()) {
                trovato = true;
                loginDtoOutput.setTrovato(trovato);
                loginDtoOutput.setUsername(loginDtoInput.getUsername());
                loginDtoOutput.setPassword(loginDtoInput.getPassword());
                logger.info("username : " + loginDtoInput.getUsername() + "password :" + loginDtoInput.getPassword());
            }
        }
        return loginDtoOutput;
    }

    public LoginDtoOutput insertLogin(LoginDtoInput loginDtoInput) {
        transaction.begin();

        List<Login> login = findUserExist(loginDtoInput);

        if (login.isEmpty()) {

            Query query2 = em.createNativeQuery("INSERT INTO LOGIN l(l.USERNAME,l.PASSWORD) VALUES (?, ?)");
            query2.setParameter(1, loginDtoInput.getUsername());
            query2.setParameter(2, loginDtoInput.getPassword());
            query2.executeUpdate();
            em.getTransaction().commit();
            em.close();
            registrato = true;
            loginDtoOutput.setRegistrato(registrato);
            loginDtoOutput.setUsername(loginDtoInput.getUsername());
            loginDtoOutput.setPassword(loginDtoInput.getPassword());
            logger.info("username : " + loginDtoOutput.getUsername() + "password :" + loginDtoOutput.getPassword());

        } else {
            trovato = true;
            loginDtoOutput.setTrovato(trovato);
        }
        return loginDtoOutput;

    }

    private List<Login> findUserExist(LoginDtoInput loginDtoInput) {

        TypedQuery<Login> query = em.createNamedQuery("Login.findByUsernameAndPassword", Login.class);
        query.setParameter("username", loginDtoInput.getUsername());
        query.setParameter("password", loginDtoInput.getPassword());
        List<Login> login = query.getResultList();
        
        return login;
    }
}
