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
public enum PacienteRepEnum implements Serializable{
    MEMORIA, ARQUIVO, BANCODEDADOS;

    @JsonCreator
    public static PacienteRepEnum toEnum(@JsonProperty("pacienteRepEnum")String pacienteRepEnum){
        if(pacienteRepEnum.equalsIgnoreCase("MEMORIA"))
            return PacienteRepEnum.MEMORIA;
        if(pacienteRepEnum.equalsIgnoreCase("ARQUIVO"))
            return PacienteRepEnum.ARQUIVO;
        if(pacienteRepEnum.equalsIgnoreCase("BANCODEDADOS"))
            return PacienteRepEnum.BANCODEDADOS;
        return null;
    }  
}
