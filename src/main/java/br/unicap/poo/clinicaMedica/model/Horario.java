/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.HorarioChegadaInvalidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.HorarioSaidaInvalidoException;

/**
 *
 * @author Danilo
 */
public class Horario {
    private final int codigo;
    private DiaSemana diaSemana;
    private int chegada;
    private int saida;
    
    public Horario(){
        this.diaSemana=diaSemana.SEGUNDA;
        this.chegada=0;
        this.saida=23;
        this.codigo=0;
    }
    private Horario(Horario horario){
        this.diaSemana=horario.diaSemana;
        this.chegada=horario.chegada;
        this.saida=horario.saida;
        this.codigo=horario.codigo;
    }
    private Horario(int codigo, Horario horario){
        this.codigo=codigo;
        this.chegada=horario.chegada;
        this.saida=horario.saida;
        this.diaSemana=horario.diaSemana;
    }
    public int getCodigo(){
        return codigo;
    }
    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana){
        this.diaSemana=diaSemana;
 
    }

    public int getChegada() {
        return chegada;
    }

    public void setChegada(int chegada) throws HorarioChegadaInvalidoException {
        if(chegada>saida){
            throw new HorarioChegadaInvalidoException();
        }else{
            this.chegada=chegada;
        }
    }

    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) throws HorarioSaidaInvalidoException {
        if(saida<chegada){
            throw new HorarioSaidaInvalidoException();
        }else{
            this.saida=saida;
        }
    }
    public boolean horarioValido(int diaSemana, int hora){
        return diaSemana==this.diaSemana.getValorDiaSemana() && hora > chegada && hora < saida;
    }
    @Override
    public boolean equals(Object horario){
        Horario objeto = (Horario)horario;
        
        return objeto.diaSemana==this.diaSemana && objeto.chegada==this.chegada && objeto.saida==this.saida;
    }
    public Horario clonar(){
        return new Horario(this);
    }
    public Horario clonar(int codigo){
        return new Horario(codigo, this);
    }
    
}
