/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.model;

import br.unicap.poo.clinicaMedica.model.exceptions.MedicoSemPlanoSaudeAtendidoException;
import br.unicap.poo.clinicaMedica.model.exceptions.SeguradoraPlanoSaudeMedicoRepetidaException;
import br.unicap.poo.clinicaMedica.model.exceptions.SeguradoraPlanoSaudeMedicoNaoEncontradaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class PlanoSaudeMedico {
    private ArrayList<SeguradoraPlano> seguradorasPlano;
    private boolean atendePrivado;
    
    public PlanoSaudeMedico(boolean atendePrivado){
        this.atendePrivado=atendePrivado;
        seguradorasPlano = new ArrayList<>();
    }
    private PlanoSaudeMedico(PlanoSaudeMedico planoSaudeMedico){
        this.atendePrivado=planoSaudeMedico.atendePrivado;
        seguradorasPlano = new ArrayList();
        for(SeguradoraPlano item : planoSaudeMedico.seguradorasPlano){
            this.seguradorasPlano.add(item);
        }
    }
    
    public boolean isAtendePrivado(){
        return atendePrivado;
    }
    public void setAtendePrivado(boolean atendePrivado) throws MedicoSemPlanoSaudeAtendidoException{
        if(seguradorasPlano.isEmpty()){
            throw new MedicoSemPlanoSaudeAtendidoException();
        }else{
            this.atendePrivado=atendePrivado;
        }
    }
    public List<SeguradoraPlano> getSeguradorasPlano(){
        return seguradorasPlano;
    }
    public boolean atendePlanoSaude(SeguradoraPlano seguradoraPlano){
        if(seguradoraPlano==null){
            return atendePrivado;
        }else{
            return contemSeguradora(seguradoraPlano);
        }
    }
    private boolean contemSeguradora(SeguradoraPlano item){
        for(SeguradoraPlano data : seguradorasPlano){
            if(item.getCodigo()==data.getCodigo()){
                return true;
            }else if(data.getCodigo()>item.getCodigo()){
                return false;
            }
        }
        return false;
    }
    public void adicionarSeguradora(SeguradoraPlano seguradora) throws SeguradoraPlanoSaudeMedicoRepetidaException{
        if(!contemSeguradora(seguradora)){
            seguradorasPlano.add(seguradora);
        }else{
            throw new SeguradoraPlanoSaudeMedicoRepetidaException();
        }
    }
    public void removerSeguradora(SeguradoraPlano seguradora) throws SeguradoraPlanoSaudeMedicoNaoEncontradaException, MedicoSemPlanoSaudeAtendidoException{
        int cont=0;
        if(seguradorasPlano.size()==1 && atendePrivado==false){
            throw new MedicoSemPlanoSaudeAtendidoException();
        }
        
        for(SeguradoraPlano item : seguradorasPlano){
            if(item.getCodigo()==seguradora.getCodigo()){
                seguradorasPlano.remove(cont);
            }
            if(item.getCodigo()>seguradora.getCodigo()){
                throw new SeguradoraPlanoSaudeMedicoNaoEncontradaException();
            }
            cont++;
        }
        throw new SeguradoraPlanoSaudeMedicoNaoEncontradaException();
    }
    public PlanoSaudeMedico clonar(){
        return new PlanoSaudeMedico(this);
    }
}
