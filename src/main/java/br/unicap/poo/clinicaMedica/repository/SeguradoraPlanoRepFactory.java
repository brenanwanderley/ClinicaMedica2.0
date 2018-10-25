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
public class SeguradoraPlanoRepFactory {
    private SeguradoraPlanoRepBridge instance;
    public SeguradoraPlanoRepFactory(){
        instance = SeguradoraPlanoDAO.getInstance();
    }
    public SeguradoraPlanoRepBridge getInstance(){
        return instance;
    }
}
