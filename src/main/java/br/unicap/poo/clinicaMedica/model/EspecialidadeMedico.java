/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.EspecialidadeMedicoNaoEncontradaException;
import br.unicap.poo.clinicaMedica.model.exceptions.EspecialidadeMedicoRepetidaException;
import br.unicap.poo.clinicaMedica.model.exceptions.MedicoSemEspecialidadeException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class EspecialidadeMedico {
    private ArrayList<Especialidade> especialidades;
    public EspecialidadeMedico(Especialidade especialidade){
        especialidades= new ArrayList<>();
        especialidades.add(especialidade);
    }
    private EspecialidadeMedico(EspecialidadeMedico especialidadeMedico){
        especialidades = new ArrayList<>();
        for(Especialidade item : especialidadeMedico.especialidades){
            especialidades.add(item);
        }
    }
    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }
    public void addEspecialidade(Especialidade especialidade) throws EspecialidadeMedicoRepetidaException{
        if(contemEspecialidade(especialidade)){
            throw new EspecialidadeMedicoRepetidaException();
        }else{
            especialidades.add(especialidade);
        }
    }
    private boolean contemEspecialidade(Especialidade item){
        for(Especialidade data : especialidades){
            if(item.getCodigo()==data.getCodigo()){
                return true;
            }else if(data.getCodigo()<item.getCodigo()){
                return false;
            }
        }
        return false;
    }
    public void removeEspecialidade(Especialidade especialidade) throws EspecialidadeMedicoNaoEncontradaException, MedicoSemEspecialidadeException{
        
        if(especialidades.size()==1){
            throw new MedicoSemEspecialidadeException();
        }
        
        for(int i=0; i<especialidades.size(); i++){
            if(especialidades.get(i).getCodigo()==especialidade.getCodigo()){
                especialidades.remove(i);
                return;
            }else if(especialidades.get(i).getCodigo()>especialidade.getCodigo()){
                throw new EspecialidadeMedicoNaoEncontradaException();
            }
        }
        throw new EspecialidadeMedicoNaoEncontradaException();

    }
    public EspecialidadeMedico clonar(){
        return new EspecialidadeMedico(this);
    }
    
    
}
