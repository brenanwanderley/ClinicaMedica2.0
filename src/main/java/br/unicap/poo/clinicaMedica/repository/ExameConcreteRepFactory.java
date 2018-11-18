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
public class ExameConcreteRepFactory extends ExameRepFactory{
    public ExameConcreteRepFactory(){
        super();
    }
    @Override
    public ExameRepBridge getInstance(){
        //1 - Memória
        //2 - Arquivo
        //3 - Banco de Dados
        //int opcao=1;
        
        ExameConfig config;
        try {
            config = new ExameConfig();
        } catch (IOException ex) {
            Logger.getLogger(ConsultaConcreteRepFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        config.load();
        ExameRepEnum exameEnum = config.getNum();
        
        switch(exameEnum){
            case MEMORIA:
                return ExameDAO.getInstance();
            case ARQUIVO:
                throw new UnsupportedOperationException("Não há suporte para arquivo");
            case BANCODEDADOS:
                throw new UnsupportedOperationException("Não há suporte para banco de dados");
            default:
                return null;
        }    
    }
    
    public void setConfig(ExameRepEnum exameEnum) throws IOException{
        ExameConfig config = new ExameConfig();
        config.setNum(exameEnum);
        config.save();       
    }
}
