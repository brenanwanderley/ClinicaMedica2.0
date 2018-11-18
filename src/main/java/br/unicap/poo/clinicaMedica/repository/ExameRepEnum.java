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
public enum ExameRepEnum implements Serializable{
    MEMORIA, ARQUIVO, BANCODEDADOS;
    
    @JsonCreator
    public static ExameRepEnum toEnum(@JsonProperty("exameRepEnum")String exameRepEnum){
        if(exameRepEnum.equalsIgnoreCase("MEMORIA"))
            return ExameRepEnum.MEMORIA;
        if(exameRepEnum.equalsIgnoreCase("ARQUIVO"))
            return ExameRepEnum.ARQUIVO;
        if(exameRepEnum.equalsIgnoreCase("BANCODEDADOS"))
            return ExameRepEnum.BANCODEDADOS;
        return null;
    }
}
