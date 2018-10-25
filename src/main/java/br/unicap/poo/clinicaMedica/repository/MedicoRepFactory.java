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
public class MedicoRepFactory {
    private MedicoRepBridge instance;
    public MedicoRepFactory(){
        instance = MedicoDAO.getInstance();
    }
    public MedicoRepBridge getInstance(){
        return instance;
    }
}
