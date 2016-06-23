/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import VO.Produto;
import java.rmi.RemoteException;
import java.util.List;
import persistence.ProdutoDB;

/**
 *
 * @author viniciuscustodio
 */
public class ProdutoController extends ServidorImpl implements ProdutoControllerInterface {

    public ProdutoController() throws RemoteException {
        super();
    }

    @Override
    public List<Produto> getProducts() throws RemoteException{
        ProdutoDB persistence = new ProdutoDB();
        return persistence.getProducts();
    }

}
