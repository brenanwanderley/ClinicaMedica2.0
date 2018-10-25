
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.Agendamento;
import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.repository.ConsultaRepBridge;
import br.unicap.poo.clinicaMedica.repository.ConsultaRepFactory;

import java.util.Date;
import java.util.List;


public class ConsultaService {
    private ConsultaRepBridge consultas;
    
    public ConsultaService(){
        ConsultaRepFactory instance = new ConsultaRepFactory();
        consultas = instance.getInstance();
    }
    public void AgendarConsulta(Consulta item){
        consultas.inserir(item);
    } 
    
    public void alterarConsulta(Consulta item){
        consultas.alterar(item);
    }
    
    public void cancelarConsulta(Consulta item){
        consultas.remover(item);
    }
    public List<Consulta> verConsultas(Medico medico, Date data){
        AgendamentoList list = new AgendamentoList();
        List<Agendamento> listagem = (List<Agendamento>)(List<?>)consultas.listar();
        List<Agendamento> resultado = list.verAgendamentos(listagem, data, medico);
        
        return (List<Consulta>)(List<?>) resultado;
    }
    public List<Consulta> verConsultas(Medico medico){
        AgendamentoList list = new AgendamentoList();
        List<Agendamento> listagem = (List<Agendamento>)(List<?>)consultas.listar();
        List<Agendamento> resultado = list.verAgendamentos(listagem, medico);
        
        return (List<Consulta>)(List<?>) resultado;
    }
    public List<Consulta> verConsultas(Date data){
        AgendamentoList list = new AgendamentoList();
        List<Agendamento> listagem = (List<Agendamento>)(List<?>)consultas.listar();
        List<Agendamento> resultado = list.verAgendamentos(listagem, data);
        
        return (List<Consulta>)(List<?>) resultado;
    }
    public Consulta selecionar(int codigo){
        Consulta selecao = consultas.selecionar(codigo);
        
        return selecao;
    }
}
