/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 *
 * @author Brenan Wanderley
 */
public enum ProcedimentoMedicoRepEnum implements Serializable{
    MEMORIA, ARQUIVO, BANCODEDADOS;
    
    @JsonCreator
    public static ProcedimentoMedicoRepEnum toEnum(@JsonProperty("procedimentoMedicoRepEnum")String procedimentoMedicoRepEnum){
        if(procedimentoMedicoRepEnum.equalsIgnoreCase("MEMORIA"))
            return ProcedimentoMedicoRepEnum.MEMORIA;
        if(procedimentoMedicoRepEnum.equalsIgnoreCase("ARQUIVO"))
            return ProcedimentoMedicoRepEnum.ARQUIVO;
        if(procedimentoMedicoRepEnum.equalsIgnoreCase("BANCODEDADOS"))
            return ProcedimentoMedicoRepEnum.BANCODEDADOS;
        return null;
    }  
}
