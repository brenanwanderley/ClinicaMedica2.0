/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.Especialidade;
import br.unicap.poo.clinicaMedica.repository.EspecialidadeRepBridge;
import br.unicap.poo.clinicaMedica.repository.EspecialidadeConcreteRepFactory;
import br.unicap.poo.clinicaMedica.repository.EspecialidadeRepFactory;
import br.unicap.poo.clinicaMedica.repository.Iterador;
/**
 *
 * @author Danilo
 */
public class EspecialidadeService {
    private EspecialidadeRepBridge especialidades;
    
    public EspecialidadeService(){
        EspecialidadeRepFactory instance = new EspecialidadeConcreteRepFactory();
        especialidades = instance.getInstance();
    }
    public void inserirEspecialidade(Especialidade item){
        especialidades.inserir(item);
    } 
    
    public void alterarEspecialidade(Especialidade item){
        especialidades.alterar(item);
    }
    
    public void removerEspecialidade(Especialidade item){
        especialidades.remover(item);
    }
   public Iterador<Especialidade> listar(){
       Iterador<Especialidade> listaEspecialidades = especialidades.listar();
              
       return listaEspecialidades;
   }
    public Especialidade selecionar(int codigo){
        Especialidade selecao = especialidades.selecionar(codigo);
        
        return selecao;
    }
}
