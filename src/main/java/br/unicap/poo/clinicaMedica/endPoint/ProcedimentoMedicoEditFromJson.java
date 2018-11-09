/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;

import br.unicap.poo.clinicaMedica.model.ProcedimentoMedico;
import br.unicap.poo.clinicaMedica.model.exceptions.AgendamentoException;
import br.unicap.poo.clinicaMedica.model.exceptions.DataInvalidaException;
import br.unicap.poo.clinicaMedica.service.ProcedimentoMedicoService;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.ParseException;

/**
 *
 * @author Lucas Soares
 */
public class ProcedimentoMedicoEditFromJson {
    private ProcedimentoMedico edit;
    @JsonCreator
    public ProcedimentoMedicoEditFromJson(@JsonProperty("id") int id,
                             @JsonProperty("data") String data) throws AgendamentoException, DataInvalidaException, ParseException{
        ProcedimentoMedicoService service = new ProcedimentoMedicoService();
        edit = service.selecionar(id);
        edit.setData(data);
    }
    public ProcedimentoMedico getEdit(){
        return edit;
    }
}
