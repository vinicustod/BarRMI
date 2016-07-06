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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viniciuscustodio
 */
public class MesaController {

    public String registrarMesa(int porta) {
        String nomeMesa = null;
        try {
            MesaControllerInterface produto = (MesaControllerInterface) Naming.lookup("rmi://127.0.0.1:10001/mesa");
            nomeMesa = produto.registrarMesa(""+porta);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(MesaController.class.getName()).log(Level.SEVERE, null, ex);
            return "erro";
        }
        return nomeMesa;
    }

    public boolean registrarEntrada(int idMesa, String nome) {
        try {
            MesaControllerInterface mesa = (MesaControllerInterface) Naming.lookup("rmi://127.0.0.1:10001/mesa");
            return mesa.registrarEntrada(idMesa, nome);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(MesaController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
