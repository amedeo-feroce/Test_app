/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acn.nemo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author amedeo.feroce
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FARMA_PROMO_TEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FarmaPromoTest.findAll", query = "SELECT f FROM FarmaPromoTest f")
    , @NamedQuery(name = "FarmaPromoTest.findByCodPromo", query = "SELECT f FROM FarmaPromoTest f WHERE f.codPromo = :codPromo")
    , @NamedQuery(name = "FarmaPromoTest.findByPgrPromo", query = "SELECT f FROM FarmaPromoTest f WHERE f.pgrPromo = :pgrPromo")
    , @NamedQuery(name = "FarmaPromoTest.findByPgrRiga", query = "SELECT f FROM FarmaPromoTest f WHERE f.pgrRiga = :pgrRiga")
    , @NamedQuery(name = "FarmaPromoTest.findByScontoP", query = "SELECT f FROM FarmaPromoTest f WHERE f.scontoP = :scontoP")
    , @NamedQuery(name = "FarmaPromoTest.findByTipoPromo", query = "SELECT f FROM FarmaPromoTest f WHERE f.tipoPromo = :tipoPromo")
    , @NamedQuery(name = "FarmaPromoTest.findByDescrizione", query = "SELECT f FROM FarmaPromoTest f WHERE f.descrizione = :descrizione")
    , @NamedQuery(name = "FarmaPromoTest.findByDescTipo", query = "SELECT f FROM FarmaPromoTest f WHERE f.descTipo = :descTipo")
    , @NamedQuery(name = "FarmaPromoTest.findById", query = "SELECT f FROM FarmaPromoTest f WHERE f.id = :id")})
public class FarmaPromoTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PROMO")
    private short codPromo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PGR_PROMO")
    private short pgrPromo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PGR_RIGA")
    private short pgrRiga;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SCONTO_P")
    private BigDecimal scontoP;
    @Size(max = 3)
    @Column(name = "TIPO_PROMO")
    private String tipoPromo;
    @Size(max = 271)
    @Column(name = "DESCRIZIONE")
    private String descrizione;
    @Size(max = 18)
    @Column(name = "DESC_TIPO")
    private String descTipo;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;

   
}
