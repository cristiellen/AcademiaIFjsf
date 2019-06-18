/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.acabemiaif.controller;

import br.com.academiaif.mapeamento.outros.PlanoMapeamento;
import br.com.academiaif.repository.PlanoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class PlanoController {
    private PlanoMapeamento planoMapeamento;
    private PlanoRepository planoRepository;
    private List<PlanoMapeamento> listaDePlanos;
    
    public PlanoController(){
        this.planoMapeamento = new PlanoMapeamento();
        this.planoRepository = new PlanoRepository();
        this.listaDePlanos = new ArrayList<>();
    }
    
    public void salvar(){
        this.planoRepository.salvar(planoMapeamento);
    }
    
    public void buscarTodos(){
        this.listaDePlanos = this.planoRepository.buscarTodos();
    }

    public PlanoMapeamento getPlanoMapeamento() {
        return planoMapeamento;
    }

    public void setPlanoMapeamento(PlanoMapeamento planoMapeamento) {
        this.planoMapeamento = planoMapeamento;
    }

    public PlanoRepository getPlanoRepository() {
        return planoRepository;
    }

    public void setPlanoRepository(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public List<PlanoMapeamento> getListaDePlanos() {
        return listaDePlanos;
    }

    public void setListaDePlanos(List<PlanoMapeamento> listaDePlanos) {
        this.listaDePlanos = listaDePlanos;
    }
    
    
}
