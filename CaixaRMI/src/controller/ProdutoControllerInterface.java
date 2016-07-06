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
public interface ProdutoControllerInterface extends Remote{
    public List<Produto> getProducts() throws RemoteException;
    public void imprimirMensagem(String nickname, String mensagem) throws RemoteException;
    public boolean realizarPedido(List<Pedido> pedido) throws RemoteException;
    public Produto getProduct(Long idProduto) throws RemoteException;
    //Esse método vai receber o produto e se esse produto será cadastrado -1 ou editado -0
    //se for para cadastrar ele chama o método de inserção de novo item, se for edição, chama o de atualização
    public boolean cadastrarProduto(Produto produto, boolean cadastrar) throws RemoteException;
    public boolean excluirProduto(Produto produto) throws RemoteException;

}
