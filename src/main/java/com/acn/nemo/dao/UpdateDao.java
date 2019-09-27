/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.dao;

import com.acn.nemo.controller.LoginController;
import com.acn.nemo.dto.UpdateDtoInput;
import com.acn.nemo.dto.UpdateDtoOutput;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author amedeo.feroce
 */
public class UpdateDao {

    private static final Logger logger = Logger.getLogger(LoginController.class);

    private UpdateDtoOutput updateDtoOutput;
    @PersistenceUnit
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("C3BO_MW");
    @PersistenceContext
    private EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    boolean modificato = false;

    public UpdateDao(UpdateDtoOutput updateDtoOutput) {
        this.updateDtoOutput = updateDtoOutput;
    }

    public UpdateDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public UpdateDtoOutput updateData(UpdateDtoInput updateDtoInput) {
        transaction.begin();
        Query query = em.createNativeQuery("update FARMA_PROMO_DEF fpd set fpd.cod_promo =:cod_promo, ");
        query.setParameter(1, updateDtoInput.getCod_promo());
        query.setParameter(2, updateDtoInput.getPgr_promo());
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();

        return updateDtoOutput;
    }

}
