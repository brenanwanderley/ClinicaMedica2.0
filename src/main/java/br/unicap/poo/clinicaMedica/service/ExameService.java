package br.unicap.poo.clinicaMedica.service;

import br.unicap.poo.clinicaMedica.model.Agendamento;
import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.repository.ExameRepBridge;
import br.unicap.poo.clinicaMedica.repository.ExameConcreteRepFactory;
import br.unicap.poo.clinicaMedica.repository.ExameRepFactory;
import br.unicap.poo.clinicaMedica.iteradores.Iterador;
import br.unicap.poo.clinicaMedica.repository.ExameRepEnum;
import java.io.IOException;
import java.util.Date;

public class ExameService {

    private ExameRepBridge exames;

    public ExameService(){
        ExameRepFactory instance = new ExameConcreteRepFactory();
        exames = instance.getInstance();
    }
    public void novoExame(Exame item) {
        exames.inserir(item);
    }

    public void alterarExame(Exame item) {
        exames.alterar(item);
        ConsultaService service = new ConsultaService();
        service.alterarConsulta(item.getConsulta());
        PacienteService pacService = new PacienteService();
        pacService.alterarPaciente(item.getPaciente());
    }

    public void cancelarExame(Exame item) {
        exames.remover(item);
        item.getConsulta().removeExame(item);
        ConsultaService service = new ConsultaService();
        service.alterarConsulta(item.getConsulta());
    }
    
    public Iterador<Exame> verExames(Medico medico){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)exames.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, medico);
        
        return (Iterador<Exame>)(Iterador<?>) resultado;
    }
    public Iterador<Exame> verExames(Date data){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)exames.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, data);
        
        return (Iterador<Exame>)(Iterador<?>) resultado;       
    }
    public Iterador<Exame> verExames(Medico medico, Date data){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)exames.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, medico);
        
        return (Iterador<Exame>)(Iterador<?>) resultado;
    }
    public Exame selecionar(int codigo){
        Exame selecao = exames.selecionar(codigo);
        
        return selecao;
    }
    public static void setConfig(ExameRepEnum exameEnum) throws IOException{
        ExameRepFactory factory = new ExameConcreteRepFactory();
        factory.setConfig(exameEnum);
    }

}
