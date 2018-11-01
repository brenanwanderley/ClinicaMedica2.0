package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.auxClasses.JsonProcessor;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.enterprise.context.ApplicationScoped;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
@ApplicationScoped
public class SeguradoraPlano {
    private final int codigo;
    private String descricao;

    @JsonCreator
    public SeguradoraPlano(@JsonProperty("descricao") String descricao){
        this.descricao=descricao;
        this.codigo=0;
    }
    public SeguradoraPlano() {
        this.codigo = 0;
    }
    private SeguradoraPlano(int codigo, SeguradoraPlano seguradoraPlano){
        this.codigo=codigo;
        this.descricao=seguradoraPlano.descricao;
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
    public SeguradoraPlano clonar(int codigo){
        return new SeguradoraPlano(codigo, this);
    }
    public void setAll(String jsonContent){
        JsonProcessor json = new JsonProcessor(jsonContent);
        setDescricao(json.getJsonParam("descricao"));
    }
}
