/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author viniciuscustodio
 */
@Entity
public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int idMovimentacao;
    private String tipoMovimentacao;
    private String cliente;
    private Date dataMovimentacao;
    private Time horaMovimentacao;

    public Movimentacao(String tipo){
        this.tipoMovimentacao = tipo;
    }

    public Movimentacao(String tipo, String cliente) {
        this.tipoMovimentacao = tipo;
        this.cliente = cliente;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VO.Movimentacao[ id=" + id + " ]";
    }

    /**
     * @return the idMovimentacao
     */
    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    /**
     * @param idMovimentacao the idMovimentacao to set
     */
    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the dataMovimentacao
     */
    public Date getDataMovimentacao() {
        return dataMovimentacao;
    }

    /**
     * @param dataMovimentacao the dataMovimentacao to set
     */
    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    /**
     * @return the horaMovimentacao
     */
    public Time getHoraMovimentacao() {
        return horaMovimentacao;
    }

    /**
     * @param horaMovimentacao the horaMovimentacao to set
     */
    public void setHoraMovimentacao(Time horaMovimentacao) {
        this.horaMovimentacao = horaMovimentacao;
    }

    /**
     * @return the tipoMovimentacao
     */
    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    /**
     * @param tipoMovimentacao the tipoMovimentacao to set
     */
    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
    
}
