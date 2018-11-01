/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.auxClasses.TimeProcessor;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.ConsultaException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Brenan Wanderley
 */
@ApplicationScoped
public class Consulta extends Agendamento{
    private Medico medico;
    private ArrayList<Exame> exames;
    private ArrayList<ProcedimentoMedico> procedimentos;
    private Paciente paciente;
    
    private Consulta(int codigo, Consulta consulta){
        super(codigo, consulta);
        this.medico=consulta.medico;
        this.exames= new ArrayList();
        for(Exame item : consulta.exames){
            exames.add(item);
        }
        this.procedimentos = new ArrayList();
        for(ProcedimentoMedico item : consulta.procedimentos){
            procedimentos.add(item);
        }
        this.paciente=consulta.paciente;
    }
    public Consulta(String data, String hora, Medico medico, Paciente paciente) throws AgendamentoException{
        super(data);
        this.setHora(hora);
        if(medico.horarioDisponivel(super.getData())){
            this.medico=medico;
        }else{
            throw new ConsultaException("O médico não tem horário disponível");
        }
        this.paciente=paciente;
        exames = new ArrayList();
        procedimentos = new ArrayList();
    }

    @Override
    public Medico getMedico() {
        return medico;
    }

    public ArrayList<Exame> getExames() {
        return exames;
    }

    public ArrayList<ProcedimentoMedico> getProcedimentos() {
        return procedimentos;
    }
    @Override
    public Paciente getPaciente() {
        return paciente;
    }
    public void addExame(Exame exame){
        exames.add(exame);
    }
    public void addProcedimento(ProcedimentoMedico procedimento){
        procedimentos.add(procedimento);
    }
    public void removeExame(Exame exame){
        int cont=0;
        for(Exame item : exames){
            if(item.getCodigo()==exame.getCodigo()){
                exames.remove(cont);
                return;
            }else if(item.getCodigo()>exame.getCodigo()){
                return;
            }
            cont++;
        }
    }
    public void removeProcedimento(ProcedimentoMedico procedimento){
        int cont=0;
        for(ProcedimentoMedico item : procedimentos){
            if(item.getCodigo()==procedimento.getCodigo()){
                procedimentos.remove(cont);
                return;
            }else if(item.getCodigo()>procedimento.getCodigo()){
                return;
            }
            cont++;
        }
    }
    @Override
    public Agendamento clonar(int codigo){
        return new Consulta(codigo, this);
    }
    @Override
    public void setStatus(Status status){
        super.setStatus(status);
        paciente.increaseNumeroVisitas();
    }
    public void setHora(String hora) throws DataInvalidaException{
        TimeProcessor timeProcessor = new TimeProcessor(this.getData(), hora);
        super.setData(timeProcessor.getDate());
    }
    @Override
    public void setAll(String jsonContent) throws AgendamentoException{
        super.setAll(jsonContent);
    }
}
