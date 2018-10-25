/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author aluno
 */
public class PlanoDeSaude {
    private SeguradoraPlano seguradoraPlano;
    private String numeroCarteira;
    private Date dataValidade;

    public PlanoDeSaude() {

    }
    @JsonCreator
    public PlanoDeSaude(@JsonProperty("seguradoraPlano")SeguradoraPlano seguradoraPlano, @JsonProperty("numeroCarteira")String numeroCarteira, @JsonProperty("dataValidade")Date dataValidade){
        this.seguradoraPlano=seguradoraPlano;
        this.numeroCarteira=numeroCarteira;
        this.dataValidade=dataValidade;
    }

    public SeguradoraPlano getSeguradoraPlano() {
        return seguradoraPlano;
    }

    public void setSeguradoraPlano(SeguradoraPlano seguradoraPlano) {
        this.seguradoraPlano = seguradoraPlano;
    }

    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    public void setNumeroCarteira(String numeroCarteira) {
        this.numeroCarteira = numeroCarteira;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
    public void setAll(PlanoDeSaude planoDeSaude, SeguradoraPlano segPlanoRef){
        this.numeroCarteira=planoDeSaude.numeroCarteira;
        this.dataValidade=planoDeSaude.dataValidade;
        this.seguradoraPlano=segPlanoRef;
    }
    
    
}
