/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import VO.Pedido;
import VO.Produto;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author viniciuscustodio
 */
public interface ProdutoControllerInterface extends Remote {

    public List<Produto> getProducts() throws RemoteException;
    public void imprimirMensagem(String nickname, String mensagem) throws RemoteException;

    public boolean realizarPedido(List<Pedido> pedido) throws RemoteException;
    public Produto getProduct(Long idProduto) throws RemoteException;

}
