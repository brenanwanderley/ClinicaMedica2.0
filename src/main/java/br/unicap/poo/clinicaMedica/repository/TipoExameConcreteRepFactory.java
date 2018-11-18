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
public class TipoExameConcreteRepFactory extends TipoExameRepFactory {
    public TipoExameConcreteRepFactory(){
        super();
    }
    @Override
    public TipoExameRepBridge getInstance(){
        TipoExameConfig config;
        
        try {
            config = new TipoExameConfig();
        } catch (IOException ex) {
            Logger.getLogger(TipoExameConcreteRepFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        config.load();
        TipoExameRepEnum tipoExameEnum = config.getNum();
        
        switch(tipoExameEnum){
            case MEMORIA:
                return TipoExameDAO.getInstance();
            case ARQUIVO:
                throw new UnsupportedOperationException("Não há suporte para arquivo");
            case BANCODEDADOS:
                throw new UnsupportedOperationException("Não há suporte para banco de dados");
            default:
                return null;
        }    
    }
    @Override
    public void setConfig(TipoExameRepEnum tipoExameEnum) throws IOException{
        TipoExameConfig config = new TipoExameConfig();
        config.setNum(tipoExameEnum);
        config.save();
    }
}
