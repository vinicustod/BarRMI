/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import VO.Movimentacao;
import VO.Pedido;
import VO.Produto;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.swing.JOptionPane;
import persistence.ProdutoDB;
import view.FormServidor;

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
    public List<Produto> getProducts(String cliente) throws RemoteException {
        if (!cliente.equals("self"))
            FormServidor.servidor.novaMovimentacao(new Movimentacao("Busca Todos Produto", cliente ));
        ProdutoDB persistence = new ProdutoDB();
        return persistence.getProducts();
    }

    @Override
    public boolean realizarPedido(String cliente, List<Pedido> pedido) throws RemoteException{
        List<Produto> produtos = this.getProducts("self");
        FormServidor.servidor.novaMovimentacao(new Movimentacao("Pedido", cliente));
        
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
    public Produto getProduct(String cliente, Long idProduto) throws RemoteException {
        FormServidor.servidor.novaMovimentacao(new Movimentacao("Busca Produto com id " + idProduto, cliente));
        ProdutoDB persistence = new ProdutoDB();
        return persistence.getProduct(idProduto);
    }

    @Override
    public boolean cadastrarProduto(String cliente, Produto produto, boolean cadastrar) throws RemoteException {
        ProdutoDB p = new ProdutoDB();
        try {
            if (cadastrar) {
                return p.registrarEntrada(produto);
            }else{
                return p.registrarSaida(produto);
            }            
        } catch (Exception e) {
            return false;
        }        
    }

    @Override
    public boolean excluirProduto(String cliente, Produto produto) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
