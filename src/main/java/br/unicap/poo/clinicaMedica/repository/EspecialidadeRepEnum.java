
package br.unicap.poo.clinicaMedica.repository;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 *
 * @author Brenan Wanderley
 */
public enum EspecialidadeRepEnum implements Serializable{
    MEMORIA, ARQUIVO, BANCODEDADOS;
    
    @JsonCreator
    public static EspecialidadeRepEnum toEnum(@JsonProperty("especialidadeRepEnum")String especialidadeRepEnum){
        if(especialidadeRepEnum.equalsIgnoreCase("MEMORIA"))
            return EspecialidadeRepEnum.MEMORIA;
        if(especialidadeRepEnum.equalsIgnoreCase("ARQUIVO"))
            return EspecialidadeRepEnum.ARQUIVO;
        if(especialidadeRepEnum.equalsIgnoreCase("BANCODEDADOS"))
            return EspecialidadeRepEnum.BANCODEDADOS;
        return null;
    }
}
