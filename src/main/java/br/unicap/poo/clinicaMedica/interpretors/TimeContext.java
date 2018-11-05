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
public class TimeContext {
    private String timeString;
    private Date date;
    
    public TimeContext(String timeString){
        this.timeString=timeString;
        this.date = Calendar.getInstance().getTime();
    }
    public TimeContext(String timeString, Date date){
        this.timeString=timeString;
        this.date=date;
    }
    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
