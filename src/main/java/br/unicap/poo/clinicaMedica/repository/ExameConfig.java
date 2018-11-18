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
public class ExameConfig {
    
    private ExameRepEnum exameRepEnum;
    private FileConfigSerializable<ExameRepEnum> config;
    
    public ExameConfig() throws IOException{
        this.config = new FileConfigSerializable("exameConfig");
    }
    public ExameRepEnum getNum() {
        return exameRepEnum;
    }

    public void setNum(ExameRepEnum num) {
        this.exameRepEnum=num;
    }
    
    public void load(){
        exameRepEnum = config.Load();
        if(exameRepEnum==null){
            exameRepEnum = ExameRepEnum.MEMORIA;
        }
    }
    
    public void save(){
        config.save(exameRepEnum);
    }
}
