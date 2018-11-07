/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Endereco;
import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import br.unicap.poo.clinicaMedica.service.PacienteService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Lucas Soares
 */
public class PacienteEditFromJson {
    private Paciente edit;
    
    @JsonCreator
    public PacienteEditFromJson(@JsonProperty("cpf") String cpf,
                                @JsonProperty("nome") String nome,
                                @JsonProperty("telefone") String telefone,
                                @JsonProperty("endereco") Endereco endereco,
                                @JsonProperty("planoDeSaude") PlanoDeSaudeCreateFromJson planoDeSaudeJson,
                                @JsonProperty("dataNasc") String dataNasc) throws PessoaException{
        PacienteService service = new PacienteService();
        edit = service.selecionar(cpf);
        edit.setNome(nome);
        edit.setTelefone(telefone);
        edit.setEndereco(endereco);
        edit.setPlanoDeSaude(planoDeSaudeJson.getPlanodeSaude());
        edit.setDataNasc(dataNasc);
    }
}
