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
public class PacienteConfig {
    private PacienteRepEnum pacienteRepEnum;
    private FileConfigSerializable<PacienteRepEnum> config;
    
    public PacienteConfig() throws IOException{
        this.config = new FileConfigSerializable("pacienteConfig");
    }
    public PacienteRepEnum getNum() {
        return pacienteRepEnum;
    }

    public void setNum(PacienteRepEnum num) {
        this.pacienteRepEnum=num;
    }
    
    public void load(){
        pacienteRepEnum = config.Load();
        if(pacienteRepEnum==null){
            pacienteRepEnum = PacienteRepEnum.MEMORIA;
        }
    }
    
    public void save(){
        config.save(pacienteRepEnum);
    }
}
