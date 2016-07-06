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
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.FormCaixa;

/**
 *
 * @author viniciuscustodio
 */
public class MesaController extends UnicastRemoteObject implements MesaControllerInterface {

    public MesaController() throws RemoteException {
        super();
    }

    public String registrarMesa() throws RemoteException {
        int newMesa = 0;
        int atIndex = 0;
        ArrayList<Mesa> mesas = FormCaixa.caixa.mesas;
        for (Mesa mesa : mesas) {
            int testing = mesa.getMesa();
            Mesa m = new Mesa();
            m.setMesa(testing + 1);
            if (mesas.indexOf(m) == -1) {
                newMesa = testing + 1;
                atIndex = mesas.indexOf(mesa) + 1;
            }
        }
        Mesa m = new Mesa();
        m.setMesa(newMesa);
        m.setDisponibilidade("Livre");
        FormCaixa.caixa.mesas.add(atIndex, m);
        FormCaixa.caixa.fillTableMesas();

        return "" + m.getMesa();
    }

    @Override
    public boolean registrarEntrada(int idMesa, String nomeCliente) throws RemoteException {
        try {
            Mesa mesa = new Mesa();
            mesa.setMesa(idMesa);
            mesa.setDisponibilidade("Livre");
            ArrayList mesas = FormCaixa.caixa.mesas;

            Mesa selecionada = (Mesa) mesas.get(idMesa);
            selecionada.setMesa(idMesa);
            selecionada.setNomeCliente(nomeCliente);
            selecionada.setDisponibilidade("Ocupada");
            FormCaixa.caixa.fillTableMesas();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(MesaController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
