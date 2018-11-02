/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.auxClasses;

/**
 *
 * @author Danilo
 */
public class HHMMTimeInterpretor extends TimeInterpretor {
    public HHMMTimeInterpretor(TimeContext context){
        super(context);
        String timeArray[] = context.getTimeString().split(":");
        this.hora=Integer.parseInt(timeArray[0]);
        this.minutos=Integer.parseInt(timeArray[1]);
    }
}
