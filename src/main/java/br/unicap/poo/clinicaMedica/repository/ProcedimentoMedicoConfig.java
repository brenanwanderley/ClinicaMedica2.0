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
public class ProcedimentoMedicoConfig {
    
    private ProcedimentoMedicoRepEnum procedimentoMedicoRepEnum;
    private FileConfigSerializable<ProcedimentoMedicoRepEnum> config;
    
    public ProcedimentoMedicoConfig() throws IOException{
        this.config = new FileConfigSerializable("procedimentoMedicoConfig");
    }
    public ProcedimentoMedicoRepEnum getNum() {
        return procedimentoMedicoRepEnum;
    }

    public void setNum(ProcedimentoMedicoRepEnum num) {
        this.procedimentoMedicoRepEnum=num;
    }
    
    public void load(){
        procedimentoMedicoRepEnum = config.Load();
        if(procedimentoMedicoRepEnum==null){
            procedimentoMedicoRepEnum = ProcedimentoMedicoRepEnum.MEMORIA;
        }
    }
    
    public void save(){
        config.save(procedimentoMedicoRepEnum);
    }
}
