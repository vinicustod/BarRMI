package controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.rmi.registry.RegistryImpl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vinicius
 */
public class Servidor {
    RegistryImpl registryImpl = null;
    String ipServidor;
    int portaServidor;
    
    public Servidor(String ip, int porta) {
        this.portaServidor = porta;
        this.ipServidor = ip;
        try {
            registryImpl = new RegistryImpl(porta);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void instatiateServicos() {
        try {
            MesaControllerInterface servidor = new MesaController();
            Naming.rebind("rmi://" + ipServidor + ":" + portaServidor + "/" + "mesa", servidor);
            System.out.println("Serviço Mesa Registrado");
            
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
