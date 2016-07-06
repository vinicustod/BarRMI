/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

import java.io.Serializable;

/**
 *
 * @author viniciuscustodio
 */
public class Pedido implements Serializable{
    private Produto produto;
    private int quantidade;

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public Pedido clone(){
        Pedido pedido = new Pedido();
        Produto novoProduto = new Produto();
        
        pedido.setQuantidade(this.getQuantidade());
        novoProduto.setDescricao(produto.getDescricao());
        novoProduto.setIdProduto(produto.getIdProduto());
        novoProduto.setPreco(produto.getPreco());
        novoProduto.setQuantidade(produto.getQuantidade());
        
        pedido.setProduto(novoProduto);
        return pedido;
    }
}
