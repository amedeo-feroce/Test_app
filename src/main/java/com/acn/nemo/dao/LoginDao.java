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

    private static final Logger logger = Logger.getLogger(LoginController.class);

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

        TypedQuery<Login> query = em.createNamedQuery("Login.findByUsernameAndPassword", Login.class);
        query.setParameter("username", loginDtoInput.getUsername());
        query.setParameter("password", loginDtoInput.getPassword());
        List<Login> login = query.getResultList();

        em.close();

        for (Login log : login) {
            if (!login.isEmpty()) {
                trovato=true;
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

        TypedQuery<Login> query1 = em.createNamedQuery("Login.findByUsernameAndPassword", Login.class);
        query1.setParameter("username", loginDtoInput.getUsername());
        query1.setParameter("password", loginDtoInput.getPassword());
        List<Login> login1 = query1.getResultList();

        if (login1.isEmpty()) {
            
        
            Query query2 = em.createNativeQuery("INSERT INTO Login l(l.username,l.password) VALUES (:username,:password)");
            query2.setParameter("username", loginDtoInput.getUsername());
            query2.setParameter("password", loginDtoInput.getPassword());
            query2.executeUpdate();
            em.getTransaction().commit();
            em.close();
            registrato = true;
            loginDtoOutput.setRegistrato(registrato);
            loginDtoOutput.setUsername(loginDtoInput.getUsername());
            loginDtoOutput.setPassword(loginDtoInput.getPassword());
            logger.info("username : " + loginDtoOutput.getUsername() + "password :" + loginDtoOutput.getPassword());
           
        }else{
            trovato=true;
            loginDtoOutput.setTrovato(trovato);
        }
        return loginDtoOutput ;
        
    }

    
}


