/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.poo.clinicaMedica.endPoint;



/**
 *
 * @author Danilo
 */

import br.unicap.poo.clinicaMedica.service.ConsultaService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("consulta")
public class ConsultaEndPoint {
    private ConsultaService service;
    
    public ConsultaEndPoint(){
        service = new ConsultaService();
    }
        
}
