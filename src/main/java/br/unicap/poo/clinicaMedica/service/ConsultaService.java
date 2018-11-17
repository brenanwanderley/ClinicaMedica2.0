
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.Agendamento;
import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.repository.ConsultaRepBridge;
import br.unicap.poo.clinicaMedica.repository.ConsultaConcreteRepFactory;
import br.unicap.poo.clinicaMedica.repository.ConsultaRepFactory;
import br.unicap.poo.clinicaMedica.iteradores.Iterador;
import br.unicap.poo.clinicaMedica.repository.ConsultaRepEnum;
import java.io.IOException;

import java.util.Date;


public class ConsultaService {
    private ConsultaRepBridge consultas;
    
    public ConsultaService(){
        ConsultaRepFactory instance = new ConsultaConcreteRepFactory();
        consultas = instance.getInstance();
    }
    public void AgendarConsulta(Consulta item){
        consultas.inserir(item);
    } 
    
    public void alterarConsulta(Consulta item){
        consultas.alterar(item);
        PacienteService pacService = new PacienteService();
        pacService.alterarPaciente(item.getPaciente());
    }
    
    public void cancelarConsulta(Consulta item){
        consultas.remover(item);
    }
    public Iterador<Consulta> verConsultas(Medico medico, Date data){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)consultas.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, data, medico);
        
        return (Iterador<Consulta>)(Iterador<?>) resultado;
    }
    public Iterador<Consulta> verConsultas(Medico medico){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)consultas.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, medico);
        
        return (Iterador<Consulta>)(Iterador<?>) resultado;
    }
    public Iterador<Consulta> verConsultas(Date data){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)consultas.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, data);
        
        return (Iterador<Consulta>)(Iterador<?>) resultado;
    }
    public Consulta selecionar(int codigo){
        Consulta selecao = consultas.selecionar(codigo);
        
        return selecao;
    }
    public static void setConfig(ConsultaRepEnum consultaEnum) throws IOException{
        ConsultaRepFactory factory = new ConsultaConcreteRepFactory();
        factory.setConfig(consultaEnum);
    }
}
