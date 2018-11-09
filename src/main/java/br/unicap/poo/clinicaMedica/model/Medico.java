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
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Medico extends Pessoa{
    private final int codigo;
    private EspecialidadeMedico especialidadeMedico;
    private PlanoSaudeMedico planoSaudeMedico;
    private HorarioMedico horarioMedico;
    
    public Medico(String nome, String telefone, Especialidade especialidade){
        this.codigo=0;
        this.planoSaudeMedico = new PlanoSaudeMedico(true);
        this.horarioMedico = new HorarioMedico();
        this.especialidadeMedico = new EspecialidadeMedico(especialidade);
    }
    private Medico(int codigo, Medico medico){
        super(medico);
        this.planoSaudeMedico = medico.planoSaudeMedico.clonar();
        this.especialidadeMedico = medico.especialidadeMedico.clonar();
        this.horarioMedico=medico.horarioMedico.clonar();
        this.codigo=codigo;
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
    public Medico clonar(int codigo){
        return new Medico(codigo, this);
    }
    @Override
    public void setAll(String jsonContent) throws PessoaException{
        super.setAll(jsonContent);
    }
}
