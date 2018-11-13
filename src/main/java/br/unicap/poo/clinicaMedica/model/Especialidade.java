/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.enterprise.context.ApplicationScoped;



/**
 *
 * @author aluno
 */
@ApplicationScoped
public class Especialidade{
    private final int codigo;
    private String descricao;

    @JsonCreator
    public Especialidade(@JsonProperty("descricao") String descricao){
        this.descricao=descricao;
        this.codigo=0;
    }
    public Especialidade() {
        this.codigo = 0;
    }
    private Especialidade(int codigo, Especialidade especialidade){
        this.codigo=codigo;
        this.descricao=especialidade.descricao;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }
    public Especialidade clonar(int codigo){
        return new Especialidade(codigo, this);
    }
}
