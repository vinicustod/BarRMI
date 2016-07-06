/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author viniciuscustodio
 */
public class Mesa {
    private int mesa;
    private String nomeCliente;
    private String disponibilidade;
    private String portaMesa;
    /**
     * @return the mesa
     */
    public int getMesa() {
        return mesa;
    }

    /**
     * @param mesa the mesa to set
     */
    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the disponibilidade
     */
    public String getDisponibilidade() {
        return disponibilidade;
    }

    /**
     * @param disponibilidade the disponibilidade to set
     */
    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    /**
     * @return the portaMesa
     */
    public String getPortaMesa() {
        return portaMesa;
    }

    /**
     * @param portaMesa the portaMesa to set
     */
    public void setPortaMesa(String portaMesa) {
        this.portaMesa = portaMesa;
    }
}
