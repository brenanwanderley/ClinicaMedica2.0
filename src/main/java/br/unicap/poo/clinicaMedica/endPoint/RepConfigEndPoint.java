/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;
import br.unicap.poo.clinicaMedica.repository.ConsultaRepEnum;
import br.unicap.poo.clinicaMedica.repository.EspecialidadeRepEnum;
import br.unicap.poo.clinicaMedica.repository.ExameRepEnum;
import br.unicap.poo.clinicaMedica.repository.MedicoRepEnum;
import br.unicap.poo.clinicaMedica.repository.PacienteRepEnum;
import br.unicap.poo.clinicaMedica.repository.ProcedimentoMedicoRepEnum;
import br.unicap.poo.clinicaMedica.repository.SeguradoraPlanoRepEnum;
import br.unicap.poo.clinicaMedica.repository.TipoExameRepEnum;
import br.unicap.poo.clinicaMedica.repository.TipoProcedimentoRepEnum;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
import br.unicap.poo.clinicaMedica.service.EspecialidadeService;
import br.unicap.poo.clinicaMedica.service.ExameService;
import br.unicap.poo.clinicaMedica.service.MedicoService;
import br.unicap.poo.clinicaMedica.service.PacienteService;
import br.unicap.poo.clinicaMedica.service.ProcedimentoMedicoService;
import br.unicap.poo.clinicaMedica.service.SeguradoraPlanoService;
import br.unicap.poo.clinicaMedica.service.TipoExameService;
import br.unicap.poo.clinicaMedica.service.TipoProcedimentoService;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Danilo
 */
@Path("repconfig")
public class RepConfigEndPoint {
   
    @PUT
    @Path("/consulta")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setConsultaConfig(ConsultaRepEnum consultaEnum) throws IOException{
        ConsultaService.setConfig(consultaEnum);
    }
    @PUT
    @Path("/exame")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setExameConfig(ExameRepEnum exameEnum) throws IOException{
        ExameService.setConfig(exameEnum);
    }
    @PUT
    @Path("/procedimentomedico")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setProcedimentoConfig(ProcedimentoMedicoRepEnum procedimentoEnum) throws IOException{
        ProcedimentoMedicoService.setConfig(procedimentoEnum);
    }
    @PUT
    @Path("/medico")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setMedicoConfig(MedicoRepEnum medicoEnum) throws IOException{
        MedicoService.setConfig(medicoEnum);
    }
    @PUT
    @Path("/paciente")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setPacienteConfig(PacienteRepEnum pacienteEnum) throws IOException{
        PacienteService.setConfig(pacienteEnum);
    }
    @PUT
    @Path("/tipoexame")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setTipoExameConfig(TipoExameRepEnum tipoExameEnum) throws IOException{
        TipoExameService.setConfig(tipoExameEnum);
    }
    @PUT
    @Path("/tipoprocedimento")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setTipoProcedimentoConfig(TipoProcedimentoRepEnum tipoProcedimentonum) throws IOException{
        TipoProcedimentoService.setConfig(tipoProcedimentonum);
    }
    @PUT
    @Path("/especialidade")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setEspecialidadeConfig(EspecialidadeRepEnum especialdiadeEnum) throws IOException{
        EspecialidadeService.setConfig(especialdiadeEnum);
    }
    @PUT
    @Path("/seguradoraplano")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setSeguradoraPlanoConfig(SeguradoraPlanoRepEnum seguradoraPlanoEnum) throws IOException{
        SeguradoraPlanoService.setConfig(seguradoraPlanoEnum);
    }

}
