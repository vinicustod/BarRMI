/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import VO.Mesa;
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

/**
 *
 * @author viniciuscustodio
 */
public class TerminalController {

    public List<Pedido> buscarProdutosTerminal(Mesa mesa) {
        try {
            TerminalControllerInterface produto = (TerminalControllerInterface) Naming.lookup("rmi://127.0.0.1:" +mesa.getPortaMesa()+"/mesa" + mesa.getMesa());
            return produto.buscarProdutos();
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            return null;
        }
    }

    public void finalizarMesa(Mesa mesa) {
        try {
            TerminalControllerInterface produto = (TerminalControllerInterface) Naming.lookup("rmi://127.0.0.1:" +mesa.getPortaMesa()+"/mesa" + mesa.getMesa());
            produto.finalizarMesa();
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            System.out.println("ERRO NA FINALIZACAO");
        }    
    }
}
