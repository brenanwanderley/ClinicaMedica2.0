package br.unicap.poo.clinicaMedica.service;

import br.unicap.poo.clinicaMedica.model.Agendamento;
import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.repository.ExameRepBridge;
import br.unicap.poo.clinicaMedica.repository.ExameRepFactory;
import java.util.List;
import java.util.Date;

public class ExameService {

    private ExameRepBridge exames;

    public ExameService(){
        ExameRepFactory instance = new ExameRepFactory();
        exames = instance.getInstance();
    }
    public void novoExame(Exame item) {
        exames.inserir(item);
    }

    public void alterarExame(Exame item) {
        exames.alterar(item);
    }

    public void cancelarExame(Exame item) {
        exames.remover(item);
    }
    
    public List<Exame> verExames(Medico medico){
        AgendamentoList list = new AgendamentoList();
        List<Agendamento> listagem = (List<Agendamento>)(List<?>)exames.listar();
        List<Agendamento> resultado = list.verAgendamentos(listagem, medico);
        
        return (List<Exame>)(List<?>) resultado;
    }
    public List<Exame> verExames(Date data){
        AgendamentoList list = new AgendamentoList();
        List<Agendamento> listagem = (List<Agendamento>)(List<?>)exames.listar();
        List<Agendamento> resultado = list.verAgendamentos(listagem, data);
        
        return (List<Exame>)(List<?>) resultado;       
    }
    public List<Exame> verExames(Medico medico, Date data){
        AgendamentoList list = new AgendamentoList();
        List<Agendamento> listagem = (List<Agendamento>)(List<?>)exames.listar();
        List<Agendamento> resultado = list.verAgendamentos(listagem, medico);
        
        return (List<Exame>)(List<?>) resultado;
    }
    public Exame selecionar(int codigo){
        Exame selecao = exames.selecionar(codigo);
        
        return selecao;
    }

}
