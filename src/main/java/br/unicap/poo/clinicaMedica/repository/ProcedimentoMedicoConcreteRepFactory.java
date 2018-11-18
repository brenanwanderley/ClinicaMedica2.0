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
public class ProcedimentoMedicoConcreteRepFactory extends ProcedimentoMedicoRepFactory {
    public ProcedimentoMedicoConcreteRepFactory(){
        super();
    }
    @Override
    public ProcedimentoMedicoRepBridge getInstance(){
        //1 - Memória
        //2 - Arquivo
        //3 - Banco de Dados
        //int opcao=1;
        ProcedimentoMedicoConfig config;
        try {
            config = new ProcedimentoMedicoConfig();
        } catch (IOException ex) {
            Logger.getLogger(ProcedimentoMedicoConcreteRepFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        config.load();
        ProcedimentoMedicoRepEnum procedimentoMedicoEnum = config.getNum();
        
        switch(procedimentoMedicoEnum){
            case MEMORIA:
                return ProcedimentoMedicoDAO.getInstance();
            case ARQUIVO:
                throw new UnsupportedOperationException("Não há suporte para arquivo");
            case BANCODEDADOS:
                throw new UnsupportedOperationException("Não há suporte para banco de dados");
            default:
                return null;
        }    
    }
    
    public void setConfig(ProcedimentoMedicoRepEnum procedimentoMedicoEnum) throws IOException{
        ProcedimentoMedicoConfig config = new ProcedimentoMedicoConfig();
        config.setNum(procedimentoMedicoEnum);
        config.save();       
    }
}
