package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Danilo
 */
@ApplicationScoped
public class ProcedimentoMedicoCreateFromJson {
    private ProcedimentoMedico instance;
    
    @JsonCreator
    public ProcedimentoMedicoCreateFromJson(@JsonProperty("data") String data, 
                @JsonProperty("consultaID") int consultaId, 
                @JsonProperty("tipoID") int tipoId) throws AgendamentoException, ParseException{
        ConsultaService conService = new ConsultaService();
        TipoProcedimentoService exService = new TipoProcedimentoService();
        
        instance = new ProcedimentoMedico(data, conService.selecionar(consultaId), exService.selecionar(tipoId));
    }
    public ProcedimentoMedico getInstance(){
        return instance;
    }
    
}
