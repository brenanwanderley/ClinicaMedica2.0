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
public enum SeguradoraPlanoRepEnum implements Serializable{
    MEMORIA, ARQUIVO, BANCODEDADOS;
    
    @JsonCreator
    public static SeguradoraPlanoRepEnum toEnum(@JsonProperty("seguradoraPlanoRepEnum")String seguradoraPlanoRepEnum){
        if(seguradoraPlanoRepEnum.equalsIgnoreCase("MEMORIA"))
            return SeguradoraPlanoRepEnum.MEMORIA;
        if(seguradoraPlanoRepEnum.equalsIgnoreCase("ARQUIVO"))
            return SeguradoraPlanoRepEnum.ARQUIVO;
        if(seguradoraPlanoRepEnum.equalsIgnoreCase("BANCODEDADOS"))
            return SeguradoraPlanoRepEnum.BANCODEDADOS;
        return null;
    }
}
