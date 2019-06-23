package br.com.academiaif.repository;

import br.com.academiaif.dao.Conexao;
import br.com.academiaif.mapeamento.outros.PlanoMapeamento;
import br.com.academiaif.mapeamento.pessoa.ClienteMapeamento;
import java.util.List;

public class ClienteRepository extends Conexao {

    public void salvar(ClienteMapeamento plano) {
        Conectar();
        getSession().save(plano);
        Fechar();
    }

    public List<ClienteMapeamento> buscarTodos() {
        List<ClienteMapeamento> listaDeClientes;
        Conectar();
        listaDeClientes = getSession().createQuery("from ClienteMapeamento").list();
        Fechar();
        return listaDeClientes;
    }

    public PlanoMapeamento buscarPorId(Long id) {
        Conectar();
        PlanoMapeamento planoMapeamento = (PlanoMapeamento) getSession()
                .createQuery("from PlanoMapeamento where id= :idPlano")
                .setParameter("idPlano", id)
                .setMaxResults(1).uniqueResult();
        Fechar();
        return planoMapeamento;
    }

    public void excluir(ClienteMapeamento cliente) {
        Conectar();
        getSession().delete(cliente);
        Fechar();

    }
      public void atualizar(ClienteMapeamento cliente) {
        Conectar();
        getSession().update(cliente);
        Fechar();
    }

}
