/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.service;
 
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.iteradores.Iterador;
import br.unicap.poo.clinicaMedica.repository.MedicoRepBridge;
import br.unicap.poo.clinicaMedica.repository.MedicoConcreteRepFactory;
import br.unicap.poo.clinicaMedica.repository.MedicoRepEnum;
import br.unicap.poo.clinicaMedica.repository.MedicoRepFactory;
import java.io.IOException;
/**
 *
 * @author aluno
 */
public class MedicoService {
    private MedicoRepBridge medicos;
    public MedicoService(){
        MedicoRepFactory instance = new MedicoConcreteRepFactory();
        medicos = instance.getInstance();
    }
    public void cadastrarMedico(Medico item){
        medicos.inserir(item);
    }
    public void alterarMedico(Medico item){
        medicos.alterar(item);
    }
    public void removerMedico(Medico item){
        medicos.remover(item);
    }
    public Medico selecionar(int codigo){
        Medico selecao = medicos.selecionar(codigo);
        
        return selecao;
    }
    public Iterador<Medico> listarMedico(){
        Iterador<Medico> listaMedicos = medicos.listar();
                
        return listaMedicos;
    }
    public static void setConfig(MedicoRepEnum medicoEnum) throws IOException{
        MedicoRepFactory factory = new MedicoConcreteRepFactory();
        factory.setConfig(medicoEnum);
    }
}
