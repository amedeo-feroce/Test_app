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

    public LoginDao() {
        this.loginDtoOutput = new LoginDtoOutput();
    }

    public boolean checkLogin(LoginDtoInput loginDtoInput) {

        transaction.begin();

        TypedQuery<Login> query = em.createNamedQuery("Login.findByUsernameAndPassword", Login.class);
        query.setParameter("username", loginDtoInput.getUsername());
        query.setParameter("password", loginDtoInput.getPassword());
        List<Login> login = query.getResultList();
        
        em.close();

        for (Login login1 : login) {
            if (!login.isEmpty()) {
                trovato = true;
                logger.info("username : " + loginDtoInput.getUsername() + "password :" + loginDtoInput.getPassword());
            }
        }
        return trovato;
    }

}
