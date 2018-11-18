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
public enum TipoExameRepEnum implements Serializable{
    MEMORIA, ARQUIVO, BANCODEDADOS;
    
    @JsonCreator
    public static TipoExameRepEnum toEnum(@JsonProperty("tipoExameRepEnum")String tipoExameRepEnum){
        if(tipoExameRepEnum.equalsIgnoreCase("MEMORIA"))
            return TipoExameRepEnum.MEMORIA;
        if(tipoExameRepEnum.equalsIgnoreCase("ARQUIVO"))
            return TipoExameRepEnum.ARQUIVO;
        if(tipoExameRepEnum.equalsIgnoreCase("BANCODEDADOS"))
            return TipoExameRepEnum.BANCODEDADOS;
        return null;
    }
}
