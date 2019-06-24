/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.acabemiaif.controller;

import br.com.academiaif.mapeamento.outros.PlanoMapeamento;
import br.com.academiaif.mapeamento.pessoa.ClienteMapeamento;
import br.com.academiaif.repository.ClienteRepository;
import br.com.academiaif.repository.PlanoRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean

public class ClienteController {

    private ClienteMapeamento clienteMapeamento;
    private PlanoMapeamento planoMapeamento;
    private ClienteRepository clienteRepository;
    private List<ClienteMapeamento> listaDeClientes;
    private List<PlanoMapeamento> listaDePlanos;
    private PlanoRepository planoRepo;

    public ClienteController() {
        this.clienteMapeamento = new ClienteMapeamento();
        this.planoMapeamento = new PlanoMapeamento();
        this.clienteRepository = new ClienteRepository();
        this.planoRepo = new PlanoRepository();
        this.listaDePlanos = planoRepo.buscarTodos();

    }

    public void salvar() {
        PlanoMapeamento plano = this.clienteRepository.buscarPorId(clienteMapeamento.getIdPlano());
        this.clienteMapeamento.setPlanoMapeamento(plano);
        this.clienteRepository.salvar(clienteMapeamento);
    }

    public void excluir(ClienteMapeamento cliente) {
        this.clienteRepository.excluir(cliente);
    }

    public String atualizar(){
        this.planoMapeamento= this.planoRepo.buscarPorId(clienteMapeamento.getIdPlano());
        this.clienteMapeamento.setPlanoMapeamento(planoMapeamento);
        this.clienteRepository.atualizar(clienteMapeamento);
        return "/cliente/BuscarCliente.xhtml";
    }
    

    public void buscarTodos() {
        this.listaDeClientes = this.clienteRepository.buscarTodos();
    }

    public String editar(ClienteMapeamento cliente) {
        this.clienteMapeamento = cliente;
        return "/cliente/EditarCliente.xhtml";

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

    public List<PlanoMapeamento> getListaDePlanos() {
        return listaDePlanos;
    }

    public void setListaDePlanos(List<PlanoMapeamento> listaDePlanos) {
        this.listaDePlanos = listaDePlanos;
    }

    public PlanoRepository getPlanoRepo() {
        return planoRepo;
    }

    public void setPlanoRepo(PlanoRepository planoRepo) {
        this.planoRepo = planoRepo;
    }

}
