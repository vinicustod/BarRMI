/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import VO.Pedido;
import VO.Produto;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.swing.JOptionPane;
import persistence.ProdutoDB;

/**
 *
 * @author viniciuscustodio
 */
public class ProdutoController extends UnicastRemoteObject implements ProdutoControllerInterface {

    public ProdutoController() throws RemoteException {
        super();
    }

    @Override
    public void imprimirMensagem(String nickname, String mensagem) throws RemoteException {
        System.out.println("talvez");
    }

    @Override
    public List<Produto> getProducts() throws RemoteException {
        System.out.println("chegou aqui");
        ProdutoDB persistence = new ProdutoDB();
        return persistence.getProducts();
    }

    @Override
    public boolean realizarPedido(List<Pedido> pedido) throws RemoteException{
        List<Produto> produtos = this.getProducts();
        for (Produto produtoBase : produtos) {
            for (Pedido p : pedido) {
                Produto produto = p.getProduto();
                if (produtoBase.getDescricao().equals(produto.getDescricao())) {
                    if (p.getQuantidade() > Integer.parseInt(produtoBase.getQuantidade())) {
                        return false;
                    }else{
                        int quantidadeBanco = (Integer.parseInt(produtoBase.getQuantidade()));
                        int quantidadePedido = p.getQuantidade();
                        int restante = quantidadeBanco - quantidadePedido;
                        produto.setQuantidade("" + restante);
                    }
                }
            }
        }
        ProdutoDB persistence = new ProdutoDB();
        for(Pedido p : pedido){
            Produto produto = p.getProduto();
            persistence.registrarSaida(produto);
        }
            
        
        return true;
    }

    @Override
    public Produto getProduct(Long idProduto) throws RemoteException {
        ProdutoDB persistence = new ProdutoDB();
        return persistence.getProduct(idProduto);
    }

}
