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
 * @author Aluno
 */
public class ConsultaConcreteRepFactory extends ConsultaRepFactory{
    
    
    public ConsultaConcreteRepFactory(){
        super();
    }
    @Override
    public ConsultaRepBridge getInstance(){
        ConsultaConfig config;
        try {
            config = new ConsultaConfig();
        } catch (IOException ex) {
            Logger.getLogger(ConsultaConcreteRepFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        config.load();
        ConsultaRepEnum consultaEnum = config.getNum();
        
        switch(consultaEnum){
            case MEMORIA:
                return ConsultaDAO.getInstance();
            case ARQUIVO:
                throw new UnsupportedOperationException("Não há suporte para arquivo");
            case BANCODEDADOS:
                throw new UnsupportedOperationException("Não há suporte para banco de dados");
            default:
                return null;
        }
    }
}
