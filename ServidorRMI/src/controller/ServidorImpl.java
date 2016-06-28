package controller;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */

// Classe responsável pela implementação dos métodos remotos definidos pela Interface
public class ServidorImpl extends UnicastRemoteObject implements ServidorInterface {
    
    public ServidorImpl( ) throws RemoteException {
        super();
    }

    // Método remoto implementado.
    @Override
    public void imprimirMensagem(String nickname, String mensagem) {
//        try {
            //ClienteInterface cliente = (ClienteInterface) Naming.lookup("rmi://localhost:1100/olaMundo");
            //cliente.imprimirMensagem(mensagem.toUpperCase());
            System.out.println(mensagem);
        //} catch (NotBoundException | MalformedURLException | RemoteException ex) {
          //  Logger.getLogger(ServidorImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }    
}
