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
public class MedicoConfig {
    
    private MedicoRepEnum medicoRepEnum;
    private FileConfigSerializable<MedicoRepEnum> config;
    
    public MedicoConfig() throws IOException{
        this.config = new FileConfigSerializable("medicoConfig");
    }
    public MedicoRepEnum getNum() {
        return medicoRepEnum;
    }

    public void setNum(MedicoRepEnum num) {
        this.medicoRepEnum=num;
    }
    
    public void load(){
        medicoRepEnum = config.Load();
        if(medicoRepEnum==null){
            medicoRepEnum = MedicoRepEnum.MEMORIA;
        }
    }
    
    public void save(){
        config.save(medicoRepEnum);
    }
}
