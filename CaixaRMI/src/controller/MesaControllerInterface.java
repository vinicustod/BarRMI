/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import VO.Pedido;
import VO.Produto;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author viniciuscustodio
 */
public interface MesaControllerInterface extends Remote {

    public String registrarMesa() throws RemoteException;
    public boolean registrarEntrada(int idMesa, String nomeCliente) throws RemoteException;

}
