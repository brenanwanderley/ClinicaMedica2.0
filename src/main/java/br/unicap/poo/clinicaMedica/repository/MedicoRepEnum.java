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
public enum MedicoRepEnum implements Serializable{
    MEMORIA, ARQUIVO, BANCODEDADOS;
    
    @JsonCreator
    public static MedicoRepEnum toEnum(@JsonProperty("medicoRepEnum")String medicoRepEnum){
        if(medicoRepEnum.equalsIgnoreCase("MEMORIA"))
            return MedicoRepEnum.MEMORIA;
        if(medicoRepEnum.equalsIgnoreCase("ARQUIVO"))
            return MedicoRepEnum.ARQUIVO;
        if(medicoRepEnum.equalsIgnoreCase("BANCODEDADOS"))
            return MedicoRepEnum.BANCODEDADOS;
        return null;
    }    
}
