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
public class EspecialidadeConfig {
    private EspecialidadeRepEnum especialidadeRepEnum;
    private FileConfigSerializable<EspecialidadeRepEnum> config;
    
    public EspecialidadeConfig() throws IOException{
        this.config = new FileConfigSerializable("especialidadeConfig");
    }
    public EspecialidadeRepEnum getNum() {
        return especialidadeRepEnum;
    }

    public void setNum(EspecialidadeRepEnum num) {
        this.especialidadeRepEnum=num;
    }
    
    public void load(){
        especialidadeRepEnum = config.Load();
        if(especialidadeRepEnum==null){
            especialidadeRepEnum = EspecialidadeRepEnum.MEMORIA;
        }
    }
    
    public void save(){
        config.save(especialidadeRepEnum);
    }
}
