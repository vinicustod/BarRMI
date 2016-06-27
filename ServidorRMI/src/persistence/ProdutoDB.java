/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import VO.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author viniciuscustodio
 */
public class ProdutoDB {

    public List<Produto> getProducts() {
        EntityManager em = DBEntityManager.getEntityFactory().createEntityManager();
        String qString = "SELECT p from Produto p";
        TypedQuery<Produto> q = em.createQuery(qString, Produto.class);
        List<Produto> results = null;
        System.out.println(qString);
        try {
            results = q.getResultList();
            System.out.println(results);
        } catch (NoResultException ex) {
            System.out.println("erro");
            return null;
        } finally {
            em.close();
        }
        return results;

    }

    public boolean registrarSaida(Produto produto) {
        EntityManager em = DBEntityManager.getEntityFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(produto);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            em.close();
        }
        return true;
    }
}
