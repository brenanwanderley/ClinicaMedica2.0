/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

/**
 *
 * @author aluno
 */
import br.unicap.poo.clinicaMedica.model.exceptions.PessoaException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Medico extends Pessoa{
    private final int codigo;
    private EspecialidadeMedico especialidadeMedico;
    private PlanoSaudeMedico planoSaudeMedico;
    private HorarioMedico horarioMedico;
    
    @JsonCreator
    public Medico(@JsonProperty("codigo") int codigo,
                  @JsonProperty("nome") String nome, 
                  @JsonProperty("telefone") String telefone, 
                  @JsonProperty("especialidadeMedico") EspecialidadeMedico especialidadeMedico,
                  @JsonProperty("horarioMedico") HorarioMedico horarioMedico,
                  @JsonProperty("planoSaudeMedico")PlanoSaudeMedico planoSaudeMedico) throws PessoaException{
        super.setNome(nome);
        super.setTelefone(telefone);
        this.codigo=0;
        this.planoSaudeMedico = planoSaudeMedico;
        this.horarioMedico = horarioMedico;
        this.especialidadeMedico = especialidadeMedico;
    }
    public HorarioMedico getHorarioMedico(){
        return horarioMedico;
    }
    public PlanoSaudeMedico getPlanoSaudeMedico(){
        return planoSaudeMedico;
    }
    public EspecialidadeMedico getEspecialidadeMedico(){
        return especialidadeMedico;
    }
    public boolean atendePlanoSaude(SeguradoraPlano seguradoraPlano){
        return planoSaudeMedico.atendePlanoSaude(seguradoraPlano);
    }
    public boolean horarioDisponivel(Date data){
        return horarioMedico.horarioDisponivel(data);
    }
    public int getCodigo(){
        return codigo;
    }
    public boolean equals(Medico medico){
        return this.codigo==medico.codigo;
    }
}
