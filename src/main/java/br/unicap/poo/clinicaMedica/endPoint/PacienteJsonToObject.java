/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Danilo
 */
@ApplicationScoped
public class PacienteJsonToObject {
    private Paciente instance;
    @JsonCreator
    public PacienteJsonToObject(@JsonProperty("nome") String nome,
                    @JsonProperty("telefone") String telefone, 
                    @JsonProperty("cpf") String cpf) throws PessoaException
    {
        instance = new Paciente(cpf, nome, telefone);

    } 
    public Paciente getInstance(){
        return instance;
    }
}
