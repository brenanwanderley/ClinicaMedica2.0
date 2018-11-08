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
public abstract class DateInterpretor {
    protected int dia;
    protected int mes;
    protected int ano;
    private Calendar calendar;
    protected DateContext context;
    
    public DateInterpretor(DateContext context){
        calendar = Calendar.getInstance();
        this.context=context;
        calendar.setTime(this.context.getData());
    }
    public void interpretar(){
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes-1);
        calendar.set(Calendar.YEAR, ano);
        
        this.context.setData(calendar.getTime());
    }

}
