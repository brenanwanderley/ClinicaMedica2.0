/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model.exceptions;

/**
 *
 * @author Aluno
 */
public class HorarioMedicoInvalidoException extends MedicoException {
    public HorarioMedicoInvalidoException(){
        super("O Horário informado é inválido");
    }
}
