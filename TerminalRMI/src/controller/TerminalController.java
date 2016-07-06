/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import VO.Pedido;
import VO.Produto;
import java.io.BufferedReader;
import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.FormMenu;

/**
 *
 * @author viniciuscustodio
 */
public class TerminalController  extends UnicastRemoteObject implements TerminalControllerInterface {
    
    public TerminalController() throws RemoteException {
        super();
    }

    public List<Pedido> buscarProdutos() throws RemoteException {
        return FormMenu.menu.pedidos;
    }

    @Override
    public void finalizarMesa() throws RemoteException {
        FormMenu.menu.limparMesa();
    }
}
