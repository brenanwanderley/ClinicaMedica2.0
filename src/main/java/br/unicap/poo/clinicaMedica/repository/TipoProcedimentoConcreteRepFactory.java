/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brenan Wanderley
 */
public class TipoProcedimentoConcreteRepFactory extends TipoProcedimentoRepFactory {
    public TipoProcedimentoConcreteRepFactory(){
        super();
    }
    @Override
    public TipoProcedimentoRepBridge getInstance(){
        TipoProcedimentoConfig config;

        try {
            config = new TipoProcedimentoConfig();
        } catch (IOException ex) {
            Logger.getLogger(TipoProcedimentoConcreteRepFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        config.load();
        TipoProcedimentoRepEnum tipoProcedimentoEnum = config.getNum();
        
        switch(tipoProcedimentoEnum){
            case MEMORIA:
                return TipoProcedimentoDAO.getInstance();
            case ARQUIVO:
                throw new UnsupportedOperationException("Não há suporte para arquivo");
            case BANCODEDADOS:
                throw new UnsupportedOperationException("Não há suporte para banco de dados");
            default:
                return null;
        }
    }
    
    public void setConfig(TipoProcedimentoRepEnum tipoProcedimentoEnum) throws IOException{
        TipoProcedimentoConfig config = new TipoProcedimentoConfig();
        config.setNum(tipoProcedimentoEnum);
        config.save();
    }
}
