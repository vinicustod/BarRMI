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
public class ProdutoController{
    public List<Produto> getProducts(){
        List<Produto> produtos = null;
        try {
            ProdutoControllerInterface produto = (ProdutoControllerInterface) Naming.lookup("rmi://127.0.0.1:10000/produto");
            produtos = produto.getProducts();
        } catch (NotBoundException | MalformedURLException | RemoteException  ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return produtos;
    }
    
    public Produto getProduct(Long idProduto){
        Produto produtos = null;
        try {
            ProdutoControllerInterface produto = (ProdutoControllerInterface) Naming.lookup("rmi://127.0.0.1:10000/produto");
            produtos = produto.getProduct(idProduto);
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(ProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return produtos;
    }
}
