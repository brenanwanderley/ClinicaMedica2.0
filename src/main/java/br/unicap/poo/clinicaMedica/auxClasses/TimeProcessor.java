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
public class TimeProcessor {
    private int hora;
    private int minutos;
    private Calendar calendar;

    public TimeProcessor(String hora) {
        String[] horaArray = hora.split(":");
        this.minutos = Integer.parseInt(horaArray[0]);
        this.hora = Integer.parseInt(horaArray[0]);
        calendar = Calendar.getInstance();

    }
    public TimeProcessor(Date data, String hora){
        String[] horaArray = hora.split(":");
        this.minutos = Integer.parseInt(horaArray[0]);
        this.hora = Integer.parseInt(horaArray[0]);
        calendar = Calendar.getInstance();
        calendar.setTime(data);
    }
    public Date getDate(){
        calendar.set(Calendar.HOUR, hora);
        calendar.set(Calendar.MINUTE, minutos);     
        return calendar.getTime();
    }
}
