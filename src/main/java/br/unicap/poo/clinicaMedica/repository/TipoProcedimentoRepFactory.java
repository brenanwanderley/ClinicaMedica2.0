/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import java.io.IOException;

/**
 *
 * @author Danilo
 */
public abstract class TipoProcedimentoRepFactory {
    public abstract TipoProcedimentoRepBridge getInstance();
    public abstract void setConfig(TipoProcedimentoRepEnum tipoProcedimentoEnum) throws IOException;    

}
