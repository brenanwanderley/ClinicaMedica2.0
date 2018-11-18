/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;
import br.unicap.poo.clinicaMedica.service.ConsultaService;
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
    @Path("consulta")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setConfig(ConsultaConfigParam consultaConfig) throws IOException{
        ConsultaService.setConfig(consultaConfig.getConsultaEnum());
    }
}
