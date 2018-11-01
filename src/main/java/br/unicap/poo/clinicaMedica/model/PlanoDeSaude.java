/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;
import br.unicap.poo.clinicaMedica.auxClasses.DateProcessor;
import br.unicap.poo.clinicaMedica.auxClasses.JsonProcessor;
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

    PlanoDeSaude(){
        
    }
    
    public PlanoDeSaude(SeguradoraPlano seguradoraPlano, 
                        String numeroCarteira,
                        String dataValidade){
        this.seguradoraPlano=seguradoraPlano;
        this.numeroCarteira=numeroCarteira;
        setDataValidade(dataValidade);       
    }

    public SeguradoraPlano getSeguradoraPlano() {
        return seguradoraPlano;
    }

    public void setSeguradoraPlano(SeguradoraPlano seguradoraPlano) {
        this.seguradoraPlano=seguradoraPlano;
    }

    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    public void setNumeroCarteira(String numeroCarteira) {
        this.numeroCarteira = numeroCarteira;
    }

    public String getDataValidade() {
        if(this.dataValidade!=null){
            Calendar calendar = Calendar.getInstance(); 
            calendar.setTime(this.dataValidade);
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            return df.format(calendar.getTime());
        }
        return "";
    }

    public void setDataValidade(String dataValidade) {
        DateProcessor dateProcessor = new DateProcessor(dataValidade);
        this.dataValidade=dateProcessor.getDate();
    }
    public void setAll(String jsonContent, SeguradoraPlano segPlanoRef){
        JsonProcessor json = new JsonProcessor(jsonContent);
        setNumeroCarteira(json.getJsonParam("numeroCarteira"));
        setDataValidade(json.getJsonParam("dataValidade"));
        this.seguradoraPlano=segPlanoRef;
    }
    
    
}
