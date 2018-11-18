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
public class SeguradoraPlanoConcreteRepFactory extends SeguradoraPlanoRepFactory {
    public SeguradoraPlanoConcreteRepFactory(){
        super();
    }
    @Override
    public SeguradoraPlanoRepBridge getInstance(){
        //1 - Memória
        //2 - Arquivo
        //3 - Banco de Dados
        //int opcao=1;
        SeguradoraPlanoConfig config;
        try {
            config = new SeguradoraPlanoConfig();
        } catch (IOException ex) {
            Logger.getLogger(SeguradoraPlanoConcreteRepFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        config.load();
        SeguradoraPlanoRepEnum seguradoraPlanoEnum = config.getNum();
        
        switch(seguradoraPlanoEnum){
            case MEMORIA:
                return SeguradoraPlanoDAO.getInstance();
            case ARQUIVO:
                throw new UnsupportedOperationException("Não há suporte para arquivo");
            case BANCODEDADOS:
                throw new UnsupportedOperationException("Não há suporte para banco de dados");
            default:
                return null;
        }    
    }
    
    public void setConfig(SeguradoraPlanoRepEnum seguradoraPlanoEnum) throws IOException{
        SeguradoraPlanoConfig config = new SeguradoraPlanoConfig();
        config.setNum(seguradoraPlanoEnum);
        config.save();       
    }
}
