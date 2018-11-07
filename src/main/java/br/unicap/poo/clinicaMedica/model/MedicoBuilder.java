/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.MedicoException;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;

/**
 *
 * @author Lucas Soares
 */
public class MedicoBuilder{
    private Medico medico;
    public MedicoBuilder(){
        medico = new Medico();
    }
    public MedicoBuilder addNome(String nome){
        this.medico.setNome(nome);
        return this;
    }
    public MedicoBuilder addTelefone(String telefone) throws PessoaException{
        this.medico.setTelefone(telefone);
        return this;
    }
    public MedicoBuilder addEspecialidade(Especialidade especialidade) throws MedicoException{
        Medico item = (Medico)this.medico;
        item.getEspecialidadeMedico().addEspecialidade(especialidade);
        return this;
    }
    public Medico build() throws PessoaException{
        if(medico.getNome()==null){
            throw new PessoaException("Médico sem nome");
        }
        if(medico.getTelefone()==null){
            throw new PessoaException("Médico sem telefone");
        }
        if(medico.getEspecialidadeMedico().getEspecialidades().isEmpty()){
            throw new MedicoException("Médico sem especialidade");
        }
        
        return medico;
    }
}
