/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiaif.mapeamento.outros;

import br.com.academiaif.mapeamento.pessoa.FuncionarioMapeamento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Frank
 */
@Entity
@Table(name = "cargos")
public class CargoMapeamento implements Serializable{
    @Id
    @GeneratedValue
    private long idCargo;
    @Column(length = 30, nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private double salario;
    @OneToMany(mappedBy = "cargoMapeamento", fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private List<FuncionarioMapeamento> listaDeFuncionarios;
    
    public long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(long id) {
        this.idCargo = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<FuncionarioMapeamento> getListaDeFuncionarios() {
        return listaDeFuncionarios;
    }

    public void setListaDeFuncionarios(List<FuncionarioMapeamento> listaDeFuncionarios) {
        this.listaDeFuncionarios = listaDeFuncionarios;
    }
    
}
