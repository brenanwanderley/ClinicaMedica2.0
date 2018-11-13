/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Danilo
 */
@ApplicationScoped
public class ConsultaListDateMedicoParam {
    private Date data;
    private Medico medico;
    
    @JsonCreator
    public ConsultaListDateMedicoParam(@JsonProperty("data") String data,
                             @JsonProperty("medico") int medicoId) throws ParseException{
        this.setData(data);
        this.setMedico(medicoId);
    }
    private void setData(String data) throws ParseException{
        DateFormat df = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        this.data=df.parse(data);
    }
    private void setMedico(int medicoId){
        MedicoService medService = new MedicoService();
        this.medico=medService.selecionar(medicoId);
    }
    
    public Date getData(){
        return data;
    }
    public Medico getMedico(){
        return medico;
    }
}
