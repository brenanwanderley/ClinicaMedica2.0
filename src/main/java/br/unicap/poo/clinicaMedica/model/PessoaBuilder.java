/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;

/**
 *
 * @author Lucas Soares
 */
public abstract class PessoaBuilder {
    protected Pessoa pessoa;
    
    protected PessoaBuilder(Pessoa pessoa){
        this.pessoa=pessoa;
    }
    public PessoaBuilder addNome(String nome){
        this.pessoa.setNome(nome);
        return this;
    }
    public PessoaBuilder addTelefone(String telefone) throws PessoaException{
        this.pessoa.setTelefone(telefone);
        return this;
    }
    public Pessoa build() throws PessoaException{
        if(pessoa.getNome()==null){
            throw new PessoaException("Pessoa sem nome");
        }
        if(pessoa.getTelefone()==null){
            throw new PessoaException("Pessoa sem telefone");
        }
        return pessoa;
    }
    
}
