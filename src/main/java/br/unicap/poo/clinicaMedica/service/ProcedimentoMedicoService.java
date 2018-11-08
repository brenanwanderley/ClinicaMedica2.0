
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.Agendamento;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.repository.Iterador;
import br.unicap.poo.clinicaMedica.repository.ProcedimentoMedicoRepBridge;
import br.unicap.poo.clinicaMedica.repository.ProcedimentoMedicoConcreteRepFactory;
import br.unicap.poo.clinicaMedica.repository.ProcedimentoMedicoRepFactory;
import java.util.Date;
import java.util.List;

public class ProcedimentoMedicoService {
    private ProcedimentoMedicoRepBridge procedimentos;
    
    public ProcedimentoMedicoService(){
        ProcedimentoMedicoRepFactory instance = new ProcedimentoMedicoConcreteRepFactory();
        procedimentos = instance.getInstance();
    }   
    public void agendarProcedimento(ProcedimentoMedico procedimento){
        procedimentos.inserir(procedimento);
    }
    
    public void alterarProcedimento(ProcedimentoMedico procedimento){
        procedimentos.alterar(procedimento);
    }
    
    
    public void cancelarProcedimento(ProcedimentoMedico procedimento){
        procedimentos.remover(procedimento);
    }
    
    
    public List<ProcedimentoMedico> verProcedimentos(Medico medico, Date data){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)procedimentos.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, data, medico);
        
        return (List<ProcedimentoMedico>)(List<?>) resultado;
        
    }
    public List<ProcedimentoMedico> verProcedimentos(Medico medico){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)procedimentos.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, medico);
        
        return (List<ProcedimentoMedico>)(List<?>) resultado;
    }
    public Iterador<ProcedimentoMedico> verProcedimentos(Date data){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(List<?>)procedimentos.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, data);
        
        return (Iterador<ProcedimentoMedico>)(Iterador<?>) resultado;
    }
    public ProcedimentoMedico selecionar(int codigo){
        ProcedimentoMedico selecao = procedimentos.selecionar(codigo);
        
        return selecao;
    }
}

