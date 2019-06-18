/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiaif.repository;

import br.com.academiaif.mapeamento.outros.PlanoMapeamento;
import br.com.academiaif.dao.Conexao;
import java.util.List;

/**
 *
 * @author Frank
 */
public class PlanoRepository extends Conexao{
    
    public void salvar(PlanoMapeamento plano){
        Conectar();
        getSession().save(plano);
        Fechar();
    }
    
    public List<PlanoMapeamento> buscarTodos(){
        List<PlanoMapeamento> listaDePlanos;
        Conectar();
        listaDePlanos = getSession().createQuery("from PlanoMapeamento").list();
        Fechar();
        return listaDePlanos;
    }
      public List<PlanoMapeamento> buscarPorId(PlanoMapeamento planoId){
        List<PlanoMapeamento> listaDePlanos;
        Conectar();
        listaDePlanos = getSession().createQuery("from PlanoMapeamento").list();
        Fechar();
        return listaDePlanos;
    }
}
