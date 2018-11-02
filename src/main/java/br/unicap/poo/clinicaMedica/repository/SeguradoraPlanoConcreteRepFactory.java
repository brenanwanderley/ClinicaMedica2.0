/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.repository;

/**
 *
 * @author Aluno
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
        int opcao=1;
        
        switch(opcao){
            case 1:
                return SeguradoraPlanoDAO.getInstance();
            case 2:
                throw new UnsupportedOperationException("Não há suporte para arquivo");
            case 3:
                throw new UnsupportedOperationException("Não há suporte para banco de dados");
            default:
                return null;
        }    
    }
}
