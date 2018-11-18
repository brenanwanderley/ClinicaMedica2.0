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
public class TipoProcedimentoConfig {
    
    private TipoProcedimentoRepEnum tipoProcedimentoRepEnum;
    private FileConfigSerializable<TipoProcedimentoRepEnum> config;
    
    public TipoProcedimentoConfig() throws IOException{
        this.config = new FileConfigSerializable("tipoProcedimentoConfig");
    }
    public TipoProcedimentoRepEnum getNum() {
        return tipoProcedimentoRepEnum;
    }

    public void setNum(TipoProcedimentoRepEnum num) {
        this.tipoProcedimentoRepEnum=num;
    }
    
    public void load(){
        tipoProcedimentoRepEnum = config.Load();
        if(tipoProcedimentoRepEnum==null){
            tipoProcedimentoRepEnum = TipoProcedimentoRepEnum.MEMORIA;
        }
    }
    
    public void save(){
        config.save(tipoProcedimentoRepEnum);
    }
}
