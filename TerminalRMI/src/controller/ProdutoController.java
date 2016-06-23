/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class ProdutoController{
    public List<Produto> getProducts(){
        List produtos = null;
        try {
            File arq = new File("");
            System.out.println(arq.getAbsolutePath());
            ProdutoControllerInterface produto = (ProdutoControllerInterface) Naming.lookup("rmi://127.0.0.1:10000/produto");
            System.out.println(produtos);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return produtos;
    }
}
