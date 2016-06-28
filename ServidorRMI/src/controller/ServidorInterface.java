package controller;


import java.rmi.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius
 */

// Interface responsável por conter as assinaturas dos métodos remotos.
// Obrigatóriamente esta interface deve herdar da classe Remote, esta do pacote RMI do Java.
public interface ServidorInterface extends Remote {
    void imprimirMensagem(String nickname, String mensagem) throws RemoteException;
}
