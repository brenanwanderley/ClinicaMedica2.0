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
public class ExameRepFactory {
    private ExameRepBridge instance;
    public ExameRepFactory(){
        instance = ExameDAO.getInstance();
    }
    public ExameRepBridge getInstance(){
        return instance;
    }
}
