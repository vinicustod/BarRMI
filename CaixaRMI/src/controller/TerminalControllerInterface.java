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
public interface TerminalControllerInterface extends Remote {


    public List<Pedido> buscarProdutos() throws RemoteException;

    public void finalizarMesa()  throws RemoteException;

}
