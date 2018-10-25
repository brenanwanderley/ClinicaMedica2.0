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
public class ProcedimentoMedicoRepFactory {
    private ProcedimentoMedicoRepBridge instance;
    public ProcedimentoMedicoRepFactory(){
        instance = ProcedimentoMedicoDAO.getInstance();
    }
    public ProcedimentoMedicoRepBridge getInstance(){
        return instance;
    }
}
