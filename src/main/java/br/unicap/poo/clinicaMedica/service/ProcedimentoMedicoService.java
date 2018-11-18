
package br.unicap.poo.clinicaMedica.service;
import br.unicap.poo.clinicaMedica.model.Agendamento;
import br.unicap.poo.clinicaMedica.model.Medico;
import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.iteradores.Iterador;
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
        ConsultaService service = new ConsultaService();
        service.alterarConsulta(procedimento.getConsulta());
        PacienteService pacService = new PacienteService();
        pacService.alterarPaciente(procedimento.getPaciente());
    }
    
    
    public void cancelarProcedimento(ProcedimentoMedico procedimento){
        procedimentos.remover(procedimento);
        procedimento.getConsulta().removeProcedimento(procedimento);
        ConsultaService service = new ConsultaService();
        service.alterarConsulta(procedimento.getConsulta());
    }
    
    
    public Iterador<ProcedimentoMedico> verProcedimentos(Medico medico, Date data){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)procedimentos.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, data, medico);
        
        return (Iterador<ProcedimentoMedico>)(Iterador<?>) resultado;
        
    }
    public Iterador<ProcedimentoMedico> verProcedimentos(Medico medico){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)procedimentos.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, medico);
        
        return (Iterador<ProcedimentoMedico>)(Iterador<?>) resultado;
    }
    public Iterador<ProcedimentoMedico> verProcedimentos(Date data){
        AgendamentoList list = new AgendamentoList();
        Iterador<Agendamento> listagem = (Iterador<Agendamento>)(Iterador<?>)procedimentos.listar();
        Iterador<Agendamento> resultado = list.verAgendamentos(listagem, data);
        
        return (Iterador<ProcedimentoMedico>)(Iterador<?>) resultado;
    }
    public ProcedimentoMedico selecionar(int codigo){
        ProcedimentoMedico selecao = procedimentos.selecionar(codigo);
        
        return selecao;
    }
}

