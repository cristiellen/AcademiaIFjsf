/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiaif.repository;

import br.com.academiaif.mapeamento.outros.PlanoMapeamento;
import br.com.academiaif.dao.Conexao;
import br.com.academiaif.mapeamento.pessoa.ClienteMapeamento;
import java.util.List;

/**
 *
 * @author Frank
 */
public class PlanoRepository extends Conexao {

    public void salvar(PlanoMapeamento plano) {
        Conectar();
        getSession().save(plano);
        Fechar();
    }

    public List<PlanoMapeamento> buscarTodos() {
        List<PlanoMapeamento> listaDePlanos;
        Conectar();
        listaDePlanos = getSession().createQuery("from PlanoMapeamento").list();
        Fechar();
        return listaDePlanos;
    }

    public PlanoMapeamento buscarPorId(long id) {
        PlanoMapeamento plano;
        List<PlanoMapeamento> list;
        Conectar();
        list = getSession().createQuery("from PlanoMapeamento WHERE id = " + id).list();
        plano = list.get(0);
        Fechar();
        return plano;
    }

    public void excluir(PlanoMapeamento plano) {
        Conectar();

        PlanoMapeamento parent = (PlanoMapeamento) getSession().get(PlanoMapeamento.class, plano.getIdPlano());
        List<ClienteMapeamento> lista = parent.getListaDeClientes();
        for (ClienteMapeamento lista1 : lista) {
            System.out.println("------");
            lista1.setPlanoMapeamento(null);
        }

        parent.setListaDeClientes(lista);
        getSession().delete(parent);
        Fechar();
    }
}
