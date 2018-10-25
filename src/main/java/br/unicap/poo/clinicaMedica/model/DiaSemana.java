/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

/**
 *
 * @author Danilo
 */
public enum DiaSemana {
    DOMINGO(1),
    SEGUNDA(2),
    TERCA(3),
    QUARTA(4),
    QUINTA(5),
    SEXTA(6),
    SABADO(7);
    
    private final int diaSemana;
    
    DiaSemana(int diaSemana){
        this.diaSemana=diaSemana;
    }
    
    public int getValorDiaSemana(){
        return diaSemana;
    }
}
