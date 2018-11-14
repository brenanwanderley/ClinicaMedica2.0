package br.unicap.poo.clinicaMedica.service;

import br.unicap.poo.clinicaMedica.model.Agendamento;
import br.unicap.poo.clinicaMedica.model.Exame;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.repository.ExameRepBridge;
import br.unicap.poo.clinicaMedica.repository.ExameConcreteRepFactory;
import br.unicap.poo.clinicaMedica.repository.ExameRepFactory;
import br.unicap.poo.clinicaMedica.iteradores.Iterador;
import java.util.List;
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
    }

    public void cancelarExame(Exame item) {
        exames.remover(item);
    }
    
    public List<Exame> verExames(Medico medico){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)exames.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, medico);
        
        return (List<Exame>)(List<?>) resultado;
    }
    public List<Exame> verExames(Date data){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)exames.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, data);
        
        return (List<Exame>)(List<?>) resultado;       
    }
    public Iterador<Exame> verExames(Medico medico, Date data){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(List<?>)exames.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, medico);
        
        return (Iterador<Exame>)(Iterador<?>) resultado;
    }
    public Exame selecionar(int codigo){
        Exame selecao = exames.selecionar(codigo);
        
        return selecao;
    }

}
