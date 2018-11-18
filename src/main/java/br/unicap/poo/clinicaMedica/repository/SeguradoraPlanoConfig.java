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
public class SeguradoraPlanoConfig {
    private SeguradoraPlanoRepEnum seguradoraPlanoRepEnum;
    private FileConfigSerializable<SeguradoraPlanoRepEnum> config;
    
    public SeguradoraPlanoConfig() throws IOException{
        this.config = new FileConfigSerializable("seguradoraPlanoConfig");
    }
    public SeguradoraPlanoRepEnum getNum() {
        return seguradoraPlanoRepEnum;
    }

    public void setNum(SeguradoraPlanoRepEnum num) {
        this.seguradoraPlanoRepEnum=num;
    }
    
    public void load(){
        seguradoraPlanoRepEnum = config.Load();
        if(seguradoraPlanoRepEnum==null){
            seguradoraPlanoRepEnum =SeguradoraPlanoRepEnum.MEMORIA;
        }
    }
    
    public void save(){
        config.save(seguradoraPlanoRepEnum);
    }
}
