/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

import br.unicap.poo.clinicaMedica.repository.ConsultaRepEnum.consultarRep;
/**
 *
 * @author Aluno
 */
public class ConsultaConcreteRepFactory extends ConsultaRepFactory{
    
    consultarRep rapEnum;
    
    public ConsultaConcreteRepFactory(){
        super();
    }
    @Override
    public ConsultaRepBridge getInstance(){
        //1 - Memória
        //2 - Arquivo
        //3 - Banco de Dados
        int opcao=1;
        
        switch(rapEnum){
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
