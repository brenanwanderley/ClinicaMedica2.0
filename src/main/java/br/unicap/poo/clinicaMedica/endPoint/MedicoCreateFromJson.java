/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;


import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.MedicoBuilder;
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Danilo
 */
@ApplicationScoped
public class MedicoCreateFromJson {
    private Medico instance;
    
    @JsonCreator
    public MedicoCreateFromJson(@JsonProperty("nome") String nome,
                  @JsonProperty("telefone") String telefone,
                  @JsonProperty("especialidadeID") int especialidadeID) throws PessoaException {
        
        EspecialidadeService espService = new EspecialidadeService();
        Especialidade especialidade = espService.selecionar(especialidadeID);
        MedicoBuilder builder = new MedicoBuilder();
        instance = builder.addNome(nome)
                            .addTelefone(telefone)
                            .addEspecialidade(especialidade)
                            .build();
    }
    public Medico getInstance(){
        return instance;
    }
}
