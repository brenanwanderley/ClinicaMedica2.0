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
public class PacienteConcreteRepFactory extends PacienteRepFactory {
    public PacienteConcreteRepFactory(){
        super();
    }
    @Override
    public PacienteRepBridge getInstance(){
        //1 - Memória
        //2 - Arquivo
        //3 - Banco de Dados
        //int opcao=1;
        PacienteConfig config;
        try {
            config = new PacienteConfig();
        } catch (IOException ex) {
            Logger.getLogger(PacienteConcreteRepFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        config.load();
        PacienteRepEnum pacienteEnum = config.getNum();
        
        switch(pacienteEnum){
            case MEMORIA:
                return PacienteDAO.getInstance();
            case ARQUIVO:
                throw new UnsupportedOperationException("Não há suporte para arquivo");
            case BANCODEDADOS:
                throw new UnsupportedOperationException("Não há suporte para banco de dados");
            default:
                return null;
        }
    }
    public void setConfig(PacienteRepEnum pacienteEnum) throws IOException{
        PacienteConfig config = new PacienteConfig();
        config.setNum(pacienteEnum);
        config.save();       
    }
}
