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
public class DateProcessor {
    private int dia;
    private int mes;
    private int ano;
    private Calendar calendar;
    
    public DateProcessor(String data){
        String[] dataArray = data.split("/");
        dia = Integer.parseInt(dataArray[0]);
        mes = Integer.parseInt(dataArray[1]);
        ano = Integer.parseInt(dataArray[2]);
        calendar = Calendar.getInstance();
    }
    public DateProcessor(Date date, String data){
        String[] dataArray = data.split("/");
        dia = Integer.parseInt(dataArray[0]);
        mes = Integer.parseInt(dataArray[1]);
        ano = Integer.parseInt(dataArray[2]);
        calendar = Calendar.getInstance();
        calendar.setTime(date);
    }
    public Date getDate(){
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes-1);
        calendar.set(Calendar.YEAR, ano);
        
        return calendar.getTime();
    }

}
