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
public enum TipoProcedimentoRepEnum implements Serializable{
    MEMORIA, ARQUIVO, BANCODEDADOS;
    
    @JsonCreator
    public static TipoProcedimentoRepEnum toEnum(@JsonProperty("tipoProcedimentoRepEnum")String tipoProcedimentoRepEnum){
        if(tipoProcedimentoRepEnum.equalsIgnoreCase("MEMORIA"))
            return TipoProcedimentoRepEnum.MEMORIA;
        if(tipoProcedimentoRepEnum.equalsIgnoreCase("ARQUIVO"))
            return TipoProcedimentoRepEnum.ARQUIVO;
        if(tipoProcedimentoRepEnum.equalsIgnoreCase("BANCODEDADOS"))
            return TipoProcedimentoRepEnum.BANCODEDADOS;
        return null;
    }
}
