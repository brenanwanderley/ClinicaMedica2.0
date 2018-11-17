/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.ws.rs.PathParam;

/**
 *
 * @author Danilo
 */
public class AgendamentoListDateParam {
    private Date data;
    
    @JsonCreator
    public AgendamentoListDateParam(@PathParam("dia") String data) throws ParseException{
        this.setData(data);
    }
    private void setData(String data) throws ParseException{
        DateFormat df = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        this.data=df.parse(data);        
    }
    public Date getData(){
        return data;
    }
}
