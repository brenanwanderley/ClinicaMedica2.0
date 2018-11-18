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
public class TipoExameConfig {
    
    private TipoExameRepEnum tipoExameRepEnum;
    private FileConfigSerializable<TipoExameRepEnum> config;
    
    public TipoExameConfig() throws IOException{
        this.config = new FileConfigSerializable("tipoExameConfig");
    }
    public TipoExameRepEnum getNum() {
        return tipoExameRepEnum;
    }

    public void setNum(TipoExameRepEnum num) {
        this.tipoExameRepEnum=num;
    }
    
    public void load(){
        tipoExameRepEnum = config.Load();
        if(tipoExameRepEnum==null){
            tipoExameRepEnum = TipoExameRepEnum.MEMORIA;
        }
    }
    
    public void save(){
        config.save(tipoExameRepEnum);
    }
}
