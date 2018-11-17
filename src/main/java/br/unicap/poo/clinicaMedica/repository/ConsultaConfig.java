/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import java.io.IOException;

/**
 *
 * @author Brenan Wanderley
 */
public class ConsultaConfig{

    private ConsultaRepEnum consultaRepEnum;
    private FileConfigSerializable<ConsultaRepEnum> config;
    
    public ConsultaConfig() throws IOException{
        this.config = new FileConfigSerializable("consultaConfig");
    }
    public ConsultaRepEnum getNum() {
        return consultaRepEnum;
    }

    public void setNum(ConsultaRepEnum num) {
        this.consultaRepEnum=num;
    }
    
    public void load(){
        consultaRepEnum = config.Load();
        if(consultaRepEnum==null){
            consultaRepEnum = ConsultaRepEnum.MEMORIA;
        }
    }
    
    public void save(){
        config.save(consultaRepEnum);
    }
}
