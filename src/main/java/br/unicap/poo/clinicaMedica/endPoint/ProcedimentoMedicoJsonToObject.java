package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.Consulta;
import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.model.TipoProcedimento;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Danilo
 */
@ApplicationScoped
public class ProcedimentoMedicoJsonToObject {
    private ProcedimentoMedico instance;
    
    @JsonCreator
    public ProcedimentoMedicoJsonToObject(@JsonProperty("data") String data, 
                @JsonProperty("consultaID") int consultaId, 
                @JsonProperty("tipoID") int tipoId) throws AgendamentoException{
        ConsultaService conService = new ConsultaService();
        TipoProcedimentoService exService = new TipoProcedimentoService();
        Consulta consulta = conService.selecionar(consultaId);
        TipoProcedimento tipo = exService.selecionar(tipoId);
        instance = new ProcedimentoMedico(data, consulta, tipo);
    }
    public ProcedimentoMedico getInstance(){
        return instance;
    }
    
}
