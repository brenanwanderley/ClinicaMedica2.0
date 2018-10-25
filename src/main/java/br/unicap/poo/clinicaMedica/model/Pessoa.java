/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.TelefoneInvalidoException;


/**
 *
 * @author Brenan Wanderley
 */
public abstract class Pessoa{
    private String nome;
    private String telefone;

    public Pessoa(){
        
    }
    protected Pessoa(Pessoa pessoa){
        this.nome=pessoa.nome;
        this.telefone=pessoa.telefone;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws TelefoneInvalidoException {
        if(!telefone.matches("^([0-9]{2})([0-9]{8}|[0-9]{9})")){
             throw new TelefoneInvalidoException();   
        }else{
            this.telefone = telefone;
        }
    }
}
