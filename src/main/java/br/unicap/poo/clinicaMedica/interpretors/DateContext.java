/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.interpretors;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Danilo
 */
public class DateContext {
    private String dataString;
    private Date data;
    private String delimitor;
    
    public DateContext(String dataString, String delimitor){
        this.dataString=dataString;
        this.delimitor=delimitor;
        this.data = Calendar.getInstance().getTime();
    }
    public DateContext(String dataString, String delimitor, Date data){
        this.dataString=dataString;
        this.delimitor=delimitor;
        this.data=data;    
    }
    public String getDataString(){
        return dataString;
    }
    public void setDataString(String dataString){
        this.dataString=dataString;
    }
    public Date getData(){
        return data;
    }
    public void setData(Date data){
        this.data=data;
    }
    public String getDelimitor(){
        return delimitor;
    }
    public void setDelimitor(String delimitor){
        this.delimitor=delimitor;
    }
    
    
}
