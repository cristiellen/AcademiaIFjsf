/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.acabemiaif.controller;

import br.com.academiaif.mapeamento.pessoa.ClienteMapeamento;
import br.com.academiaif.repository.ClienteRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;


@ManagedBean

public class ClienteController {
    private ClienteMapeamento clienteMapeamento;
    private ClienteRepository clienteRepository;
    private List<ClienteMapeamento> listaDeClientes;
    
    public ClienteController(){
        this.clienteMapeamento = new ClienteMapeamento();
        this.clienteRepository = new ClienteRepository();
        //this.listaDePlanos = new ArrayList<>();
    }
    
    public void salvar(){
        this.clienteRepository.salvar(clienteMapeamento);
    }
    
    public void buscarTodos(){
        this.listaDeClientes = this.clienteRepository.buscarTodos();
    }

    public ClienteMapeamento getClienteMapeamento() {
        return clienteMapeamento;
    }

    public void setClienteMapeamento(ClienteMapeamento clienteMapeamento) {
        this.clienteMapeamento = clienteMapeamento;
    }

    public ClienteRepository getClienteRepository() {
        return clienteRepository;
    }

    public void setClienteRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteMapeamento> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeClientes(List<ClienteMapeamento> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }
    
    
}
