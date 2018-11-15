package br.unicap.poo.clinicaMedica.endPoint;

/**
 *
 * @author Danilo
 */
import br.unicap.poo.clinicaMedica.model.TipoExame;
import br.unicap.poo.clinicaMedica.service.TipoExameService;
import com.fasterxml.jackson.core.JsonProcessingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("tipoexame")
public class TipoExameEndPoint {
    TipoExameService service;
    public TipoExameEndPoint(){
        service = new TipoExameService();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarTipoExames() throws JsonProcessingException{
        return service.listar().toJson();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastrarTipoExame(TipoExame tipoExame){
        service.adicionarTipo(tipoExame);
    }
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterarTipoExame(TipoExame tipoExame){
        service.alterarTipo(tipoExame);
    }
    @Path("/{id}")
    @DELETE
    public void removerTipoExame(@PathParam("id")int id){
        TipoExame tipoExame = service.selecionar(id);
        
        service.remover(tipoExame);
    }
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public TipoExame selecionarTipoExame(@PathParam("id")int id){
         return service.selecionar(id);    
    }
}
