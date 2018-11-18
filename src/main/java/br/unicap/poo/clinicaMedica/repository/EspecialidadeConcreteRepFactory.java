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
public class EspecialidadeConcreteRepFactory extends EspecialidadeRepFactory{
    public EspecialidadeConcreteRepFactory(){
        super();
    }
    @Override
    public EspecialidadeRepBridge getInstance(){
        EspecialidadeConfig config;
        //1 - Memória
        //2 - Arquivo
        //3 - Banco de Dados
        //int opcao=1;
        try {
            config = new EspecialidadeConfig();
        } catch (IOException ex) {
            Logger.getLogger(ConsultaConcreteRepFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        config.load();
        EspecialidadeRepEnum especialidadeEnum = config.getNum();
        
        switch(especialidadeEnum){
            case MEMORIA:
                return EspecialidadeDAO.getInstance();
            case ARQUIVO:
                throw new UnsupportedOperationException("Não há suporte para arquivo");
            case BANCODEDADOS:
                throw new UnsupportedOperationException("Não há suporte para banco de dados");
            default:
                return null;
        }
    }
    
    public void setConfig(EspecialidadeRepEnum especialidadeEnum) throws IOException{
        EspecialidadeConfig config = new EspecialidadeConfig();
        config.setNum(especialidadeEnum);
        config.save();
    }
}
