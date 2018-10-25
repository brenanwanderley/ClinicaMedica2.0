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
public class EspecialidadeRepFactory {
    private EspecialidadeRepBridge instance;
    public EspecialidadeRepFactory(){
        instance = EspecialidadeDAO.getInstance();
    }
    public EspecialidadeRepBridge getInstance(){
        return instance;
    }
}
