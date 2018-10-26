/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author aluno
 */
@ApplicationScoped
public class PlanoDeSaude {
    private SeguradoraPlano seguradoraPlano;
    private String numeroCarteira;
    private Date dataValidade;

    public PlanoDeSaude() {

    }
    @JsonCreator
    public PlanoDeSaude(@JsonProperty("seguradoraPlano")SeguradoraPlano seguradoraPlano, 
                        @JsonProperty("numeroCarteira")String numeroCarteira,
                        @JsonProperty("dataValidade")String dataValidade){
        this.seguradoraPlano=seguradoraPlano;
        this.numeroCarteira=numeroCarteira;
        setDataValidade(dataValidade);        
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

    public String getDataValidade() {
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(this.dataValidade);
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        return df.format(calendar.getTime());
    }

    public void setDataValidade(String dataValidade) {
        DateProcessor dateProcessor = new DateProcessor(dataValidade);
        this.dataValidade=dateProcessor.getDate();
    }
    public void setAll(PlanoDeSaude planoDeSaude, SeguradoraPlano segPlanoRef){
        this.numeroCarteira=planoDeSaude.numeroCarteira;
        this.dataValidade=planoDeSaude.dataValidade;
        this.seguradoraPlano=segPlanoRef;
    }
    
    
}
