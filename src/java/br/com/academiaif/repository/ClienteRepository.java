
package br.com.academiaif.repository;

import br.com.academiaif.dao.Conexao;
import br.com.academiaif.mapeamento.outros.PlanoMapeamento;
import br.com.academiaif.mapeamento.pessoa.ClienteMapeamento;
import java.util.List;

public class ClienteRepository extends Conexao{
    public void salvar(ClienteMapeamento plano){
        Conectar();
        getSession().save(plano);
        Fechar();
    }
    
    public List<ClienteMapeamento> buscarTodos(){
        List<ClienteMapeamento> listaDeClientes;
        Conectar();
        listaDeClientes = getSession().createQuery("from ClienteMapeamento").list();
        Fechar();
        return listaDeClientes;
    }
}
