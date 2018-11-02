/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.auxClasses;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Danilo
 */
public abstract class TimeInterpretor {
    protected int hora;
    protected int minutos;
    private Calendar calendar;
    protected TimeContext context;

    public TimeInterpretor(TimeContext context) {
        this.context=context;
        this.calendar=Calendar.getInstance();
        calendar.setTime(context.getDate());
    }
    public void interpretador(){
        calendar.set(Calendar.HOUR, hora);
        calendar.set(Calendar.MINUTE, minutos);     
        context.setDate(calendar.getTime());
    }
}
