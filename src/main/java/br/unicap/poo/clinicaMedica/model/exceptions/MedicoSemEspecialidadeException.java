/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model.exceptions;

/**
 *
 * @author Danilo
 */
public class MedicoSemEspecialidadeException extends Exception {

    public MedicoSemEspecialidadeException() {
        super("O médico tem que ter pelo menos uma especialidade");
    }
    
}
