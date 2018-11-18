package br.unicap.poo.clinicaMedica.repository;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 *
 * @author Brenan Wanderley
 */

public enum ConsultaRepEnum implements Serializable{
    MEMORIA, ARQUIVO, BANCODEDADOS;
    
    @JsonCreator
    public static ConsultaRepEnum toEnum(@JsonProperty("consultaRepEnum")String consultaRepEnum){
        if(consultaRepEnum.equalsIgnoreCase("MEMORIA"))
            return ConsultaRepEnum.MEMORIA;
        if(consultaRepEnum.equalsIgnoreCase("ARQUIVO"))
            return ConsultaRepEnum.ARQUIVO;
        if(consultaRepEnum.equalsIgnoreCase("BANCODEDADOS"))
            return ConsultaRepEnum.BANCODEDADOS;
        return null;
    }
}
 
