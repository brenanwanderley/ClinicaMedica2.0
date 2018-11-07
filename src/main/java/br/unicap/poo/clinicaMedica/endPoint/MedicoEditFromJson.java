/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Lucas Soares
 */
public class MedicoEditFromJson {
    private Medico edit;
    @JsonCreator
    public MedicoEditFromJson(@JsonProperty("id") int id,
                              @JsonProperty("nome") String nome,
                              @JsonProperty("telefone") String telefone) throws PessoaException{
        MedicoService service = new MedicoService();
        edit = service.selecionar(id);
        edit.setNome(nome);
        edit.setTelefone(telefone);
    }
    public Medico getEdit(){
        return edit;
    }
}
