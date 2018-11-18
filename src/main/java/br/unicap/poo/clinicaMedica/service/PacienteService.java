package br.unicap.poo.clinicaMedica.service;

import br.unicap.poo.clinicaMedica.model.Paciente;
import br.unicap.poo.clinicaMedica.repository.PacienteRepBridge;
import br.unicap.poo.clinicaMedica.repository.PacienteConcreteRepFactory;
import br.unicap.poo.clinicaMedica.repository.PacienteRepEnum;
import br.unicap.poo.clinicaMedica.repository.PacienteRepFactory;
import java.io.IOException;


public class PacienteService {

    private PacienteRepBridge pacientes;

    public PacienteService() {
        PacienteRepFactory instance = new PacienteConcreteRepFactory();
        pacientes = instance.getInstance();
    }
    
    public void cadastrarPaciente(Paciente item){
        pacientes.inserir(item);
    }
    
    public void alterarPaciente(Paciente item){
        pacientes.alterar(item);
    }
    
    public void removerPaciente(Paciente item){
        pacientes.remover(item);
    }
    
    public Paciente selecionar(String cpf){
        return pacientes.selecionar(cpf);        
    }
    public static void setConfig(PacienteRepEnum pacienteEnum) throws IOException{
        PacienteRepFactory factory = new PacienteConcreteRepFactory();
        factory.setConfig(pacienteEnum);
    }
}
