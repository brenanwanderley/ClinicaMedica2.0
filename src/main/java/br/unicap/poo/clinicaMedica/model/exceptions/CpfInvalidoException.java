/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model.exceptions;

/**
 *
 * @author aluno
 */
public class CpfInvalidoException extends PacienteException {
    public CpfInvalidoException(){
        super("CPF inválido");
    }
}
