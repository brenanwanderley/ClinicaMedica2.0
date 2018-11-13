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
public class TipoProcedimento{
    private final int codigo;
    private String descricao;

    public TipoProcedimento() {
        this.codigo = 0;
    }
    @JsonCreator
    public TipoProcedimento(@JsonProperty("descricao")String descricao){
        this.descricao=descricao;
        this.codigo=0;
    }
    private TipoProcedimento(int codigo, TipoProcedimento tipoProcedimento){
        this.codigo=codigo;
        this.descricao=tipoProcedimento.descricao;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public TipoProcedimento clonar(int codigo){
        return new TipoProcedimento(codigo, this);
    }
}
