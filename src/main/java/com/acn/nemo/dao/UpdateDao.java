/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.dao;

import com.acn.nemo.dto.UpdateDtoInput;
import com.acn.nemo.dto.UpdateDtoOutput;
import com.acn.nemo.model.FarmaPromoTest;
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
 * @author amedeo.feroce
 */
public class UpdateDao {
    
    private static final Logger logger = Logger.getLogger(UpdateDao.class);
    
    private UpdateDtoOutput updateDtoOutput;
    @PersistenceUnit
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("C3BO_MW");
    @PersistenceContext
    private EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    boolean trovato = false;
    boolean modificato = false;
    boolean eliminato = false;
    
    public UpdateDao(UpdateDtoOutput updateDtoOutput) {
        
    }
    
    public UpdateDao(int id) {
        this.updateDtoOutput = updateDtoOutput;
    }
    
    public UpdateDao() {
        this.updateDtoOutput = new UpdateDtoOutput();
    }
    
    public UpdateDtoOutput readCod(int id) {
        
        transaction.begin();
        TypedQuery<FarmaPromoTest> query = em.createNamedQuery("FarmaPromoTest.findById", FarmaPromoTest.class);
        query.setParameter("id", id);
        
        List<FarmaPromoTest> farma_promo_test = query.getResultList();
        
        em.close();
        
        for (FarmaPromoTest farma : farma_promo_test) {
            if (!farma_promo_test.isEmpty()) {
                trovato = true;
                updateDtoOutput.setTrovato(trovato);
                updateDtoOutput.setId(id);
                
                logger.info("id : " + id);
                
            }
        }
        return updateDtoOutput;
    }
    
    public UpdateDtoOutput updateData(UpdateDtoInput updateDtoInput) {
        transaction.begin();
        Query query = em.createQuery("UPDATE FarmaPromoTest f SET f.codPromo = :codPromo, f.pgrPromo = :pgrPromo, f.pgrRiga = :pgrRiga, f.scontoP = :scontoP, f.tipoPromo = :tipoPromo, f.descrizione = :descrizione, f.descTipo = :descTipo WHERE f.id = :id");
        
        query.setParameter("id", updateDtoInput.getId());
        query.setParameter("codPromo", updateDtoInput.getCod_promo());
        query.setParameter("pgrPromo", updateDtoInput.getPgr_promo());
        query.setParameter("pgrRiga", updateDtoInput.getPgr_riga());
        query.setParameter("scontoP", updateDtoInput.getSconto_p());
        query.setParameter("tipoPromo", updateDtoInput.getTipo_promo());
        query.setParameter("descrizione", updateDtoInput.getDescrizione());
        query.setParameter("descTipo", updateDtoInput.getDesc_tipo());
        
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        emf.close();
        modificato = true;
        updateDtoOutput.setModificato(modificato);
        
        return updateDtoOutput;
    }
    
    public UpdateDtoOutput deleteData(UpdateDtoInput updateDtoInput) {
        transaction.begin();
        
        Query query = em.createQuery("DELETE FROM FarmaPromoTest f WHERE f.id = :id");
        query.setParameter("id", updateDtoInput.getId());
        
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        emf.close();
        eliminato = true;
        updateDtoOutput.setEliminato(eliminato);
        
        return this.updateDtoOutput;
    }
    
}
