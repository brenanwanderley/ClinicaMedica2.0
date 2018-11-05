/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.interpretors;

/**
 *
 * @author Danilo
 */
public class DDMMYYYDateInterpretor extends DateInterpretor{
    public DDMMYYYDateInterpretor(DateContext context){
        super(context);
        String[] dataArray = context.getDataString().split(context.getDelimitor());
        this.dia=Integer.parseInt(dataArray[0]);
        this.mes=Integer.parseInt(dataArray[1]);
        this.ano=Integer.parseInt(dataArray[2]);
    }
}
